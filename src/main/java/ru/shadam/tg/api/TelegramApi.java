package ru.shadam.tg.api;

import ru.shadam.tg.api.operations.*;
import ru.shadam.tg.enitity.UserProfilePhotos;
import ru.shadam.tg.options.AnswerCallbackQueryOptions;

/**
 * @author sala
 */
public interface TelegramApi extends
        ForwardMessageOperations,
        GetUpdateOperations,
        SendAudioOperations,
        SendMessageOperations,
        SendDocumentOperations,
        SendPhotoOperations,
        SendStickerOperations,
        SendVideoOperations,
        SendVoiceOperations,
        SendLocationOperations,
        SendVenueOperations,
        SendContactOperations,
        SendChatActionOperations,
        ChatOperations,
        FileOperations {


    UserProfilePhotos getUserProfilePhotos(int userId, Integer offset, Integer limit);

    Boolean answerCallbackQuery(String callbackQueryId, AnswerCallbackQueryOptions options);
}
