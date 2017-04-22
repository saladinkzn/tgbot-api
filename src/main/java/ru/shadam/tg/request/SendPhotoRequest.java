package ru.shadam.tg.request;

import ru.shadam.tg.enitity.ChatId;
import ru.shadam.tg.enitity.KeyboardMarkup;
import ru.shadam.tg.options.SendPhotoOptions;

/**
 * @author sala
 */
public class SendPhotoRequest extends SendPhotoOptions {
    private ChatId<?> chatId;
    private String photo;

    public SendPhotoRequest(long chatId, String photo, String caption, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(caption, disableNotification, replyToMessageId, replyMarkup);
        this.chatId = ChatId.longId(chatId);
        this.photo = photo;
    }

    public SendPhotoRequest(String chatId, String photo, String caption, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(caption, disableNotification, replyToMessageId, replyMarkup);
        this.chatId = ChatId.stringId(chatId);
        this.photo = photo;
    }

    public ChatId<?> getChatId() {
        return chatId;
    }

    public String getPhoto() {
        return photo;
    }


    @Override
    public String toString() {
        return "SendPhotoRequest{" +
                "disableNotification=" + disableNotification +
                ", replyToMessageId=" + replyToMessageId +
                ", replyMarkup=" + replyMarkup +
                ", chatId=" + chatId +
                ", photo='" + photo + '\'' +
                '}';
    }
}
