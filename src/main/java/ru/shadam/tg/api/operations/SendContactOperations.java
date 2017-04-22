package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendContactOptions;

/**
 * @author sala
 */
public interface SendContactOperations {
    Message sendContact(long chatId, String contact, SendContactOptions options);

    Message sendContact(String chatId, String contact, SendContactOptions options);
}
