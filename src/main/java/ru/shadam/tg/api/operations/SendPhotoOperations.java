package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendPhotoOptions;

import java.io.File;
import java.io.InputStream;

/**
 * @author sala
 */
public interface SendPhotoOperations {
    Message sendPhoto(long chatId, String photo, SendPhotoOptions options);

    Message sendPhoto(String chatId, String photo, SendPhotoOptions options);

    Message sendPhoto(long chatId, String fileName, InputStream stream, SendPhotoOptions options);

    Message sendPhoto(String chatId, String fileName, InputStream stream, SendPhotoOptions options);

    Message sendPhoto(long chatId, File file, SendPhotoOptions options);

    Message sendPhoto(String chatId, File file, SendPhotoOptions options);

    default Message sendPhoto(long chatId, String photo) {
        return sendPhoto(chatId, photo, SendPhotoOptions.EMPTY);
    }

    default Message sendPhoto(String chatId, String photo) {
        return sendPhoto(chatId, photo, SendPhotoOptions.EMPTY);
    }
}
