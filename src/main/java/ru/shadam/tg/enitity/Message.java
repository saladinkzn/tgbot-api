package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Message {
    private final int messageId;
    private final User from;
    private final Instant date;
    private final Chat chat;
    private final User forwardFrom;
    private final Chat forwardFromChat;
    private final Integer forwardFromMessageId;
    private final Instant forwardDate;
    private final Message replyToMessage;
    private final Instant editDate;
    private final String text;
    private final List<MessageEntity> entities;
    private final Audio audio;
    private final Document document;
    private final Game game;
    private final List<PhotoSize> photo;
    private final Sticker sticker;
    private final Video video;
    private final Voice voice;
    private final String caption;
    private final Contact contact;
    private final Location location;
    private final Venue venue;
    private final User newChatMember;
    private final User leftChatMember;
    private final String newChatTitle;
    private final List<PhotoSize> newChatPhoto;
    private final Boolean deleteChatPhoto;
    private final Boolean groupChatCreated;
    private final Boolean superGroupChatCreated;
    private final Boolean channelChatCreated;
    private final Integer migrateToChatId;
    private final Integer migrateFromChatId;
    private final Message pinnedMessage;

    // TODO: find out why this constructor cannot be detected
    @JsonCreator
    public Message(
            int messageId,
            User from,
            Instant date,
            Chat chat,
            User forwardFrom,
            Chat forwardFromChat,
            Integer forwardFromMessageId,
            Instant forwardDate,
            Message replyToMessage,
            Instant editDate,
            String text,
            List<MessageEntity> entities,
            Audio audio,
            Document document,
            Game game,
            List<PhotoSize> photo,
            Sticker sticker,
            Video video,
            Voice voice,
            String caption,
            Contact contact,
            Location location,
            Venue venue,
            User newChatMember,
            User leftChatMember,
            String newChatTitle,
            List<PhotoSize> newChatPhoto,
            Boolean deleteChatPhoto,
            Boolean groupChatCreated,
            Boolean superGroupChatCreated,
            Boolean channelChatCreated,
            Integer migrateToChatId,
            Integer migrateFromChatId,
            Message pinnedMessage
    ) {
        this.messageId = messageId;
        this.from = from;
        this.date = date;
        this.chat = chat;
        this.forwardFrom = forwardFrom;
        this.forwardFromChat = forwardFromChat;
        this.forwardFromMessageId = forwardFromMessageId;
        this.forwardDate = forwardDate;
        this.replyToMessage = replyToMessage;
        this.editDate = editDate;
        this.text = text;
        this.entities = entities;
        this.audio = audio;
        this.document = document;
        this.game = game;
        this.photo = photo;
        this.sticker = sticker;
        this.video = video;
        this.voice = voice;
        this.caption = caption;
        this.contact = contact;
        this.location = location;
        this.venue = venue;
        this.newChatMember = newChatMember;
        this.leftChatMember = leftChatMember;
        this.newChatTitle = newChatTitle;
        this.newChatPhoto = newChatPhoto;
        this.deleteChatPhoto = deleteChatPhoto;
        this.groupChatCreated = groupChatCreated;
        this.superGroupChatCreated = superGroupChatCreated;
        this.channelChatCreated = channelChatCreated;
        this.migrateToChatId = migrateToChatId;
        this.migrateFromChatId = migrateFromChatId;
        this.pinnedMessage = pinnedMessage;
    }

    public int getMessageId() {
        return messageId;
    }

    public User getFrom() {
        return from;
    }

    public Instant getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public User getForwardFrom() {
        return forwardFrom;
    }

    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    public Integer getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    public Instant getForwardDate() {
        return forwardDate;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public Instant getEditDate() {
        return editDate;
    }

    public String getText() {
        return text;
    }

    public List<MessageEntity> getEntities() {
        return entities;
    }

    public Audio getAudio() {
        return audio;
    }

    public Document getDocument() {
        return document;
    }

    public Game getGame() {
        return game;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public Video getVideo() {
        return video;
    }

    public Voice getVoice() {
        return voice;
    }

    public String getCaption() {
        return caption;
    }

    public Contact getContact() {
        return contact;
    }

    public Location getLocation() {
        return location;
    }

    public Venue getVenue() {
        return venue;
    }

    public User getNewChatMember() {
        return newChatMember;
    }

    public User getLeftChatMember() {
        return leftChatMember;
    }

    public String getNewChatTitle() {
        return newChatTitle;
    }

    public List<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    public Boolean getGroupChatCreated() {
        return groupChatCreated;
    }

    public Boolean getSuperGroupChatCreated() {
        return superGroupChatCreated;
    }

    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    public Integer getMigrateToChatId() {
        return migrateToChatId;
    }

    public Integer getMigrateFromChatId() {
        return migrateFromChatId;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    @JsonIgnore
    public LocalDateTime getDateTime() {
        return LocalDateTime.ofInstant(this.date, ZoneOffset.UTC);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forwardFrom=" + forwardFrom +
                ", forwardFromChat=" + forwardFromChat +
                ", forwardFromMessageId=" + forwardFromMessageId +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + replyToMessage +
                ", editDate=" + editDate +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                ", audio=" + audio +
                ", document=" + document +
                ", game=" + game +
                ", photo=" + photo +
                ", sticker=" + sticker +
                ", video=" + video +
                ", voice=" + voice +
                ", caption='" + caption + '\'' +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", newChatMember=" + newChatMember +
                ", leftChatMember=" + leftChatMember +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + newChatPhoto +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                ", superGroupChatCreated=" + superGroupChatCreated +
                ", channelChatCreated=" + channelChatCreated +
                ", migrateToChatId=" + migrateToChatId +
                ", migrateFromChatId=" + migrateFromChatId +
                ", pinnedMessage=" + pinnedMessage +
                '}';
    }
}
