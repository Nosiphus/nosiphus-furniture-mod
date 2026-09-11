package com.mrcrayfish.furniture;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class FurnitureConfigForge {

    public static class Client {
        public final ForgeConfigSpec.BooleanValue drawCollisionShapes;

        Client(ForgeConfigSpec.Builder builder) {
            builder.comment("Client configuration settings").push("client");
            this.drawCollisionShapes = builder
                    .comment("Draws the collision shape rather than the selection shape when hovering blocks. Used for debugging collisions.")
                    .translation("cfm.configgui.drawCollisionShapes")
                    .define("drawCollisionShapes", false);
            builder.pop();
        }
    }

    public static class Common {
        public final ForgeConfigSpec.IntValue maxMailQueue;
        public final ForgeConfigSpec.IntValue pullMailInterval;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Mail configuration settings").push("mail");
            this.maxMailQueue = builder
                    .comment("The maximum amount of mail that can be in a player's mail queue.")
                    .translation("cfm.configgui.maxMailQueue")
                    .defineInRange("maxMailQueue", 20, 1, Integer.MAX_VALUE);
            this.pullMailInterval = builder
                    .comment("The interval in ticks for mail boxes to pull mail from the player's queue")
                    .translation("cfm.configgui.pullMailInterval")
                    .defineInRange("pullMailInterval", 20, 1, Integer.MAX_VALUE);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();

        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }

    public static void init() {
        FurnitureConfig.setClientConfig(CLIENT.drawCollisionShapes::get);
        FurnitureConfig.setCommonConfig(COMMON.maxMailQueue::get, COMMON.pullMailInterval::get);
    }
}