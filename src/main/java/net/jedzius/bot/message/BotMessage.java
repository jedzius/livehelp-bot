package net.jedzius.bot.message;

import java.util.List;

public class BotMessage {
    private final List<String> keywords;
    private final String response;

    public BotMessage(List<String> keywords, String response) {
        this.keywords = keywords;
        this.response = response;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getResponse() {
        return response;
    }
}
