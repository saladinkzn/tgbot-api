package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendVoiceOptions {
    public static final SendVideoOptions EMPTY = new SendVideoOptions(
            null, null, null, null, null, null, null
    );

    private String caption;
    private Integer duration;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private KeyboardMarkup replyMarkup;

    public SendVoiceOptions(String caption, Integer duration, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        this.caption = caption;
        this.duration = duration;
        this.disableNotification = disableNotification;
        this.replyToMessageId = replyToMessageId;
        this.replyMarkup = replyMarkup;
    }

    public String getCaption() {
        return caption;
    }

    public Integer getDuration() {
        return duration;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public KeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }
}
