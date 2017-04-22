package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendAudioOptions extends SendOptions {
    public static final SendAudioOptions EMPTY = new SendAudioOptions(null, null, null, null, null, null, null);

    private String caption;
    private Integer duration;
    private String performer;
    private String title;

    public SendAudioOptions(String caption, Integer duration, String performer, String title, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
        this.caption = caption;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getPerformer() {
        return performer;
    }

    public String getTitle() {
        return title;
    }
}
