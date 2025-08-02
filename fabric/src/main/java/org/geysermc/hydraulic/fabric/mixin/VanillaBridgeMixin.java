package org.geysermc.hydraulic.fabric.mixin;

import org.geysermc.hydraulic.fabric.util.BedrockUtil;
import dev.patbox.polymc.network.VanillaBridge;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VanillaBridge.class)
public class VanillaBridgeMixin {

    @Inject(method = "sendPacket", at = @At("HEAD"), cancellable = true)
    private static void skipPacketForBedrock(ServerPlayerEntity player, Packet<?> packet, CallbackInfo ci) {
        if (BedrockUtil.isBedrock(player)) {
            ci.cancel(); // Skip sending packet to Bedrock players
        }
    }
}
