package ru.shadam.tg.options;

import ru.shadam.tg.enitity.ChatId;
import ru.shadam.tg.enitity.InlineKeyboardMarkup;

/**
 * @author sala
 */
public class EditMessageCaption {
    private ChatId<?> chatId;
    private Integer messageId;
    private String inlineMessageId;
    private String caption;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageCaption(long chatId, Integer messageId, String inlineMessageId, String caption, InlineKeyboardMarkup replyMarkup) {
        this.chatId = ChatId.longId(chatId);
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.caption = caption;
        this.replyMarkup = replyMarkup;
    }

    public EditMessageCaption(String chatId, Integer messageId, String inlineMessageId, String caption, InlineKeyboardMarkup replyMarkup) {
        this.chatId = ChatId.stringId(chatId);
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.caption = caption;
        this.replyMarkup = replyMarkup;
    }

    public ChatId<?> getChatId() {
        return chatId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public String getCaption() {
        return caption;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }
}
