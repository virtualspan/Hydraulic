package com.geysermc.hydraulic.util;

import org.geysermc.geyser.api.GeyserApi;
import net.minecraft.server.network.ServerPlayerEntity;

public class BedrockUtil {
    public static boolean isBedrock(ServerPlayerEntity player) {
        return GeyserApi.api().isBedrockPlayer(player.getUuid());
    }
}
