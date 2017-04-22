package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MessageEntity {
    /**
     * Type of the entity. Can be mention (@username), hashtag, bot_command, url, email, bold (bold text), italic (italic text), code (monowidth string), pre (monowidth block), text_link (for clickable text URLs), text_mention (for users without usernames)
     */
    private final MessageEntityType type;
    private final int offset;
    private final int length;
    private final String url;
    private final User user;

    public MessageEntity(MessageEntityType type, int offset, int length, String url, User user) {
        this.type = type;
        this.offset = offset;
        this.length = length;
        this.url = url;
        this.user = user;
    }

    public MessageEntityType getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public String getUrl() {
        return url;
    }

    public User getUser() {
        return user;
    }

    @JsonIgnore
    public String getEntityText(String text) {
        return text.substring(offset, offset + length);
    }
}
