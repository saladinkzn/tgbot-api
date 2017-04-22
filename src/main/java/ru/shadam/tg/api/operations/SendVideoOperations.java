package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendVideoOptions;

/**
 * @author sala
 */
public interface SendVideoOperations {
    Message sendVideo(long chatId, String video, SendVideoOptions options);

    Message sendVideo(String chatId, String video, SendVideoOptions options);
}
