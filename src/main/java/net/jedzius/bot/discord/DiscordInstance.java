package net.jedzius.bot.discord;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.jedzius.bot.discord.handler.MessageReceivedHandler;
import net.jedzius.bot.message.BotMessageService;

public class DiscordInstance {

    private BotMessageService messageService = new BotMessageService();

    public DiscordInstance(String token, String channelId) {
        messageService.load();

        var jda = JDABuilder.createLight(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(
                        new MessageReceivedHandler(this.messageService, channelId)
                )
                .disableIntents(GatewayIntent.GUILD_PRESENCES)
                .build();
    }
}
