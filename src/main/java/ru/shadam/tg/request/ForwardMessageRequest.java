package ru.shadam.tg.request;

import ru.shadam.tg.enitity.ChatId;

/**
 * @author sala
 */
public class ForwardMessageRequest {
    private final ChatId<?> chatId;
    private final ChatId<?> fromChatId;
    private final Integer messageId;

    private Boolean notification;

    public ForwardMessageRequest(ChatId<?> chatId, ChatId<?> fromChatId, Integer messageId) {
        this.chatId = chatId;
        this.fromChatId = fromChatId;
        this.messageId = messageId;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public ChatId<?> getChatId() {
        return chatId;
    }

    public ChatId<?> getFromChatId() {
        return fromChatId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public Boolean getNotification() {
        return notification;
    }


    @Override
    public String toString() {
        return "ForwardMessageRequest{" +
                "chatId=" + chatId +
                ", fromChatId=" + fromChatId +
                ", messageId=" + messageId +
                ", notification=" + notification +
                '}';
    }
}
