package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendDocumentOptions;

/**
 * @author sala
 */
public interface SendDocumentOperations {
    Message sendDocument(long chatId, String document, SendDocumentOptions options);

    Message sendDocument(String chatId, String document, SendDocumentOptions options);
}
