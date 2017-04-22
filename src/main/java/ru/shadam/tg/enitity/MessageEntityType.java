package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author sala
 */
public enum MessageEntityType {
    MENTION,
    HASHTAG,
    BOT_COMMAND,
    URL,
    EMAIL,
    BOLD,
    ITALIC,
    CODE,
    PRE,
    TEXT_LINK,
    TEXT_MENTION,

    UNKNOWN;

    @JsonValue
    public String value() {
        return this.name().toLowerCase();
    }
}
