package ru.shadam.tg.enitity;

/**
 * This object contains information about one member of the chat.
 */
public class ChatMember {
    /**
     * Information about the user
     */
    private final User user;
    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “left” or “kicked”
     */
    private final Status status;

    public ChatMember(User user, Status status) {
        this.user = user;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }
}
