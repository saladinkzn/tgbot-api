package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendStickerOptions;

/**
 * @author sala
 */
public interface SendStickerOperations {
    Message sendSticker(long chatId, String sticker, SendStickerOptions options);

    Message sendSticker(String chatId, String sticker, SendStickerOptions options);
}
