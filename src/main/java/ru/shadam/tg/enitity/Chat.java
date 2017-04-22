package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * This object represents a chat.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Chat {
    /**
     * Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    private final Long id;
    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    private final ChatType type;
    /**
     * Optional. Title, for supergroups, channels and group chats
     */
    private final String title;
    /**
     * Optional. Username, for private chats, supergroups and channels if available
     */
    private final String username;
    /**
     * Optional. First name of the other party in a private chat
     */
    private final String firstName;
    /**
     * Optional. Last name of the other party in a private chat
     */
    private final String lastName;
    /**
     * Optional. True if a group has ‘All Members Are Admins’ enabled.
     */
    private final Boolean allMembersAreAdministrators;

    public Chat(Long id, ChatType type, String title, String username, String firstName, String lastName, Boolean allMembersAreAdministrators) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.allMembersAreAdministrators = allMembersAreAdministrators;
    }

    public Long getId() {
        return id;
    }

    public ChatType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getAllMembersAreAdministrators() {
        return allMembersAreAdministrators;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", allMembersAreAdministrators=" + allMembersAreAdministrators +
                '}';
    }
}
