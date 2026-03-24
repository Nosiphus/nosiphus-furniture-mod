package com.mrcrayfish.furniture;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Author: MrCrayfish
 */
public class FurnitureConfig
{
    public static class Client
    {
        public final ModConfigSpec.BooleanValue drawCollisionShapes;

        Client(ModConfigSpec.Builder builder)
        {
            builder.comment("Client configuration settings").push("client");
            this.drawCollisionShapes = builder
                    .comment("Draws the collision shape rather than the selection shape when hovering blocks. Used for debugging collisions.")
                    .translation("cfm.configgui.drawCollisionShapes")
                    .define("drawCollisionShapes", false);
            builder.pop();
        }
    }

    public static class Common
    {
        public final ModConfigSpec.IntValue maxMailQueue;
        public final ModConfigSpec.IntValue pullMailInterval;

        Common(ModConfigSpec.Builder builder)
        {
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

    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static
    {
        final Pair<Client, ModConfigSpec> clientSpecPair = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();

        final Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}