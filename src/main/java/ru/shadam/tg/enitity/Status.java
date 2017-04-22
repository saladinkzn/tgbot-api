package ru.shadam.tg.enitity;

/**
 * @author sala
 */
public enum Status {
    CREATOR,
    ADMINISTRATOR,
    MEMBER,
    LEFT,
    KICKED;

    public static Status create(String value) {
        for (Status status : values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Value not found: " + value);
    }

}
