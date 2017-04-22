package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendVoiceOptions;

/**
 * @author sala
 */
public interface SendVoiceOperations {
    Message sendVoice(long chatId, String voice, SendVoiceOptions options);

    Message sendVoice(String chatId, String voice, SendVoiceOptions options);
}
