package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendLocationOptions extends SendOptions {
    public static final SendLocationOptions EMPTY = new SendLocationOptions(null, null, null);

    public SendLocationOptions(Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
    }
}
