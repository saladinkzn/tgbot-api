package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Game {
    /**
     * Title of the game
     */
    private final String title;
    /**
     * Description of the game
     */
    private final String description;
    /**
     * Photo that will be displayed in the game message in chats.
     */
    private final List<PhotoSize> photo;
    /**
     *  Optional. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    private final String text;
    /**
     * Optional. Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    private final List<MessageEntity> textEntities;
    /**
     * Optional. Animation that will be displayed in the game message in chats. Upload via BotFather
     */
    private final Animation animation;

    public Game(String title, String description, List<PhotoSize> photo, String text, List<MessageEntity> textEntities, Animation animation) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.text = text;
        this.textEntities = textEntities;
        this.animation = animation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }

    public List<MessageEntity> getTextEntities() {
        return textEntities;
    }

    public Animation getAnimation() {
        return animation;
    }
}
