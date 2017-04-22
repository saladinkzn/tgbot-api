package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendMessageOptions;

/**
 * @author sala
 */
public interface SendMessageOperations {
    Message sendMessage(long chatId, String text, SendMessageOptions options);

    Message sendMessage(String chatId, String text, SendMessageOptions options);

    default Message sendMessage(long chatId, String text) {
        return sendMessage(chatId, text, SendMessageOptions.EMPTY);
    }

    default Message sendMessage(String chatId, String text) {
        return sendMessage(chatId, text, SendMessageOptions.EMPTY);
    }
}
