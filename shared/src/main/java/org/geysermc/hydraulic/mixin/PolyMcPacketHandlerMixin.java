package com.geysermc.hydraulic.mixin;

import com.geysermc.hydraulic.util.BedrockUtil;
import dev.theepicblock.polymc.packets.PolyMcPacketHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PolyMcPacketHandler.class)
public class PolyMcPacketHandlerMixin {

    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private void skipPacketForBedrock(ServerPlayerEntity player, Packet<?> packet, CallbackInfo ci) {
        if (BedrockUtil.isBedrock(player)) {
            ci.cancel();
        }
    }
}
