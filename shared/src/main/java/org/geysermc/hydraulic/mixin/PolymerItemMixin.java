package com.geysermc.hydraulic.mixin;

import com.geysermc.hydraulic.util.BedrockUtil;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PolymerItem.class)
public class PolymerItemMixin {

    @Inject(method = "getPolymerItemStack", at = @At("HEAD"), cancellable = true)
    private void overrideItemForBedrock(ServerPlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        if (BedrockUtil.isBedrock(player)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }
}
