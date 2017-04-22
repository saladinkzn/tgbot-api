package ru.shadam.tg.options;

import ru.shadam.tg.enitity.ChatId;
import ru.shadam.tg.enitity.InlineKeyboardMarkup;

/**
 * @author sala
 */
public class EditMessageReplyMarkup {
    private ChatId<?> chatId;
    private Integer messageId;
    private String inlineMessageId;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageReplyMarkup(long chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup) {
        this.chatId = ChatId.longId(chatId);
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.replyMarkup = replyMarkup;
    }

    public EditMessageReplyMarkup(String chatId, Integer messageId, String inlineMessageId, InlineKeyboardMarkup replyMarkup) {
        this.chatId = ChatId.stringId(chatId);
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
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

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }
}
