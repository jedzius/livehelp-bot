package net.jedzius.bot.bootstrap;

import net.jedzius.bot.discord.DiscordInstance;

public class Bootstrap {

    public static String TOKEN = "MTAwMTM5NTg3NjU2NjE1NTI2NQ.GV2FgJ.2q4hFWkFuxAzckvTmenz2g7WiswnjIy9raK0cg";
    public static String CHANNEL_ID = "854350252744507395";

    public static void main(String[] args) {
        new DiscordInstance(TOKEN, CHANNEL_ID);
    }
}
