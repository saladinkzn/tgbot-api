package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author sala
 */
public enum ChatType {
    PRIVATE,
    GROUP,
    SUPERGROUP,
    CHANNEL,

    UNKNOWN;

    @JsonCreator
    public static ChatType create(String value) {
        for (ChatType type : values()) {
            if (type.name().toLowerCase().equals(value)) {
                return type;
            }
        }

        return UNKNOWN;
    }
}
