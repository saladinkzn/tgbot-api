package ru.shadam.tg.enitity;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 */
public class InlineKeyboardButton {
    private final String text;
    private final String url;
    private final String callbackData;
    private final String switchInlineQuery;
    private final String switchInlineQueryCurrentChat;
    private final CallbackGame callbackGame;

    public InlineKeyboardButton(String text, String url, String callbackData, String switchInlineQuery, String switchInlineQueryCurrentChat, CallbackGame callbackGame) {
        this.text = text;
        this.url = url;
        this.callbackData = callbackData;
        this.switchInlineQuery = switchInlineQuery;
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        this.callbackGame = callbackGame;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public String getSwitchInlineQuery() {
        return switchInlineQuery;
    }

    public String getSwitchInlineQueryCurrentChat() {
        return switchInlineQueryCurrentChat;
    }

    public CallbackGame getCallbackGame() {
        return callbackGame;
    }
}
