package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendPhotoOptions extends SendOptions {
    public static final SendPhotoOptions EMPTY = new SendPhotoOptions(
            null, null, null, null
    );

    private String caption;

    public SendPhotoOptions(String caption, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
