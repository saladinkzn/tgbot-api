package ru.shadam.tg.request;

import ru.shadam.tg.enitity.ChatId;
import ru.shadam.tg.enitity.KeyboardMarkup;
import ru.shadam.tg.enitity.ParseMode;
import ru.shadam.tg.options.SendMessageOptions;

/**
 * @author sala
 */
public class SendMessageRequest extends SendMessageOptions {
    private final ChatId<?> chatId;
    private final String text;

    public SendMessageRequest(long chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, KeyboardMarkup replyMarkup, Boolean disableNotification) {
        super(parseMode, disableWebPagePreview, replyToMessageId, replyMarkup, disableNotification);
        this.chatId = ChatId.longId(chatId);
        this.text = text;
    }

    public SendMessageRequest(String chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, KeyboardMarkup replyMarkup, Boolean disableNotification) {
        super(parseMode, disableWebPagePreview, replyToMessageId, replyMarkup, disableNotification);
        this.chatId = ChatId.stringId(chatId);
        this.text = text;
    }

    public ChatId<?> getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "SendMessageRequest{" +
                "chatId=" + chatId +
                ", text='" + text + '\'' +
                ", parseMode=" + parseMode +
                ", disableWebPagePreview=" + disableWebPagePreview +
                ", disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                '}';
    }
}
