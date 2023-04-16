package net.jedzius.bot.discord.handler;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.jedzius.bot.message.BotMessageService;
import org.jetbrains.annotations.NotNull;

public class MessageReceivedHandler extends ListenerAdapter {

    private final BotMessageService messageService;
    private final String channelId;

    public MessageReceivedHandler(BotMessageService messageService, String channelId) {
        this.messageService = messageService;
        this.channelId = channelId;
    }

    @Override
    public void onMessageReceived(@NotNull final MessageReceivedEvent event) {
        if(!event.getChannel().getId().equals(this.channelId))
            return;

        Message message = event.getMessage();
        String contentRaw = message.getContentRaw();

        this.messageService.findResponseByKeyword(contentRaw).ifPresent(response -> {
            event.getChannel().asTextChannel().sendMessage(response.getResponse()).queue();
        });
    }
}
