package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendDocumentOptions extends SendOptions {
    public static final SendDocumentOptions EMPTY = new SendDocumentOptions(null, null, null, null);

    private String caption;

    public SendDocumentOptions(String caption, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
