package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public abstract class SendOptions {
    protected Boolean disableNotification;
    protected Integer replyToMessageId;
    protected KeyboardMarkup replyMarkup;

    public SendOptions() {
    }

    public SendOptions(Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        this.disableNotification = disableNotification;
        this.replyToMessageId = replyToMessageId;
        this.replyMarkup = replyMarkup;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    public KeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(KeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
