package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendAudioOptions;

/**
 * @author sala
 */
public interface SendAudioOperations {
    Message sendAudio(long chatId, String audio, SendAudioOptions options);

    Message sendAudio(String chatId, String audio, SendAudioOptions options);

    default Message sendAudio(long chatId, String audio) {
        return sendAudio(chatId, audio, SendAudioOptions.EMPTY);
    }

    default Message sendAudio(String chatId, String audion) {
        return sendAudio(chatId, audion, SendAudioOptions.EMPTY);
    }
}
