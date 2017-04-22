package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * This object represents a Telegram user or bot.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {
    /**
     * Unique identifier for this user or bot
     */
    private final int id;
    /**
     * User‘s or bot’s first name
     */
    private final String firstName;
    /**
     * Optional. User‘s or bot’s last name
     */
    private final String lastName;
    /**
     * Optional. User‘s or bot’s username
     */
    private final String username;

    public User(int id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
