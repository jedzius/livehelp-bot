package net.jedzius.bot.message;

import java.util.*;

public class BotMessageService {
    private final List<BotMessage> botMessageMap = new ArrayList<>();

    public void load() {
        this.botMessageMap.add(new BotMessage(
                Arrays.asList("dupa", "dupa1"),
                "to jest wlasnie response na wiadomosc dupa oraz dupa1"
        ));

        this.botMessageMap.add(new BotMessage(
                Arrays.asList("witam", "spierdalaj"),
                "elo spierdalaj"
        ));
    }

    public Optional<BotMessage> findResponseByKeyword(String keyword) {
        return this.botMessageMap
                .stream()
                .filter(botMessage -> botMessage.getKeywords().contains(keyword))
                .findFirst();
    }
}
