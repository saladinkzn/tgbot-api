package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendVideoOptions extends SendOptions {
    public static final SendVideoOptions EMPTY = new SendVideoOptions(
            null, null, null, null, null, null, null
    );

    private Integer duration;
    private Integer width;
    private Integer height;
    private String caption;

    public SendVideoOptions(Integer duration, Integer width, Integer height, String caption, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
        this.duration = duration;
        this.width = width;
        this.height = height;
        this.caption = caption;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getCaption() {
        return caption;
    }
}
