package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;

/**
 * @author sala
 */
public interface ForwardMessageOperations {
    Message forwardMessage(long chatId, long fromChatId, int messageId, Boolean disableNotification);

    Message forwardMessage(String chatId, String fromChatId, int messageId, Boolean disableNotification);

    default Message forwardMessage(long chatId, long fromChatId, int messageId) {
        return forwardMessage(chatId, fromChatId, messageId, null);
    }

    default Message forwardMessage(String chatId, String fromChatId, int messageId) {
        return forwardMessage(chatId, fromChatId, messageId, null);
    }
}
