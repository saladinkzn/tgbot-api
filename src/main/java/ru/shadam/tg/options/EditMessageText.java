package ru.shadam.tg.options;

import ru.shadam.tg.enitity.ChatId;
import ru.shadam.tg.enitity.InlineKeyboardMarkup;
import ru.shadam.tg.enitity.ParseMode;

/**
 * @author sala
 */
public class EditMessageText {
    private ChatId<?> chatId;
    private Integer messageId;
    private String inlineMessageId;
    private String text;
    private ParseMode parseMode;
    private Boolean disableWebPagePreview;
    private InlineKeyboardMarkup replyMarkup;

    public EditMessageText(long chatId, Integer messageId, String inlineMessageId, String text, ParseMode parseMode, Boolean disableWebPagePreview, InlineKeyboardMarkup replyMarkup) {
        this.chatId = ChatId.longId(chatId);
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.text = text;
        this.parseMode = parseMode;
        this.disableWebPagePreview = disableWebPagePreview;
        this.replyMarkup = replyMarkup;
    }

    public EditMessageText(String chatId, Integer messageId, String inlineMessageId, String text, ParseMode parseMode, Boolean disableWebPagePreview, InlineKeyboardMarkup replyMarkup) {
        this.chatId = ChatId.stringId(chatId);
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.text = text;
        this.parseMode = parseMode;
        this.disableWebPagePreview = disableWebPagePreview;
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

    public String getText() {
        return text;
    }

    public ParseMode getParseMode() {
        return parseMode;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }
}
