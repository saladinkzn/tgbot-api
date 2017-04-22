package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Action;

/**
 * @author sala
 */
public interface SendChatActionOperations {
    Boolean sendChatAction(long chatId, Action action);

    Boolean sendChatAction(String chatId, Action action);
}
