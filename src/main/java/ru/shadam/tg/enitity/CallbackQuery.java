package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CallbackQuery {
    /**
     *  Unique identifier for this query
     */
    private final String id;
    /**
     * Sender
     */
    private final User from;
    /**
     * Optional. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
     */
    private final Message message;

    /**
     * Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    private final String inlineMessageId;

    /**
     *  Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
     */
    private final String chatInstance;

    /**
     *  Optional. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    private final String data;

    /**
     *  Optional. Short name of a Game to be returned, serves as the unique identifier for the game
     */
    private final String gameShortName;

    public CallbackQuery(String id, User from, Message message, String inlineMessageId, String chatInstance, String data, String gameShortName) {
        this.id = id;
        this.from = from;
        this.message = message;
        this.inlineMessageId = inlineMessageId;
        this.chatInstance = chatInstance;
        this.data = data;
        this.gameShortName = gameShortName;
    }

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public Message getMessage() {
        return message;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public String getChatInstance() {
        return chatInstance;
    }

    public String getData() {
        return data;
    }

    public String getGameShortName() {
        return gameShortName;
    }
}
