package com.geysermc.hydraulic.mixin;

import com.geysermc.hydraulic.util.BedrockUtil;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PolymerBlock.class)
public class PolymerBlockMixin {

    @Inject(method = "getPolymerBlockState", at = @At("HEAD"), cancellable = true)
    private void overrideBlockStateForBedrock(ServerPlayerEntity player, CallbackInfoReturnable<BlockState> cir) {
        if (BedrockUtil.isBedrock(player)) {
            cir.setReturnValue(null); // Or Blocks.AIR.getDefaultState()
        }
    }
}
