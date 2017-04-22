package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendLocationOptions;

/**
 * @author sala
 */
public interface SendLocationOperations {
    Message sendLocation(long chatId, String location, SendLocationOptions options);

    Message sendLocation(String chatId, String location, SendLocationOptions options);
}
