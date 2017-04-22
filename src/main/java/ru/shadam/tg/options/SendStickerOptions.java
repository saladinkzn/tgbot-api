package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendStickerOptions extends SendOptions {
    public static SendStickerOptions EMPTY = new SendStickerOptions(null, null, null);

    public SendStickerOptions(Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
    }
}
