package ru.shadam.tg.hook;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ru.shadam.tg.enitity.CallbackQuery;
import ru.shadam.tg.enitity.ChosenInlineResult;
import ru.shadam.tg.enitity.InlineQuery;
import ru.shadam.tg.enitity.Message;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Update {
    private final int updateId;
    private final Message message;
    private final Message editedMessage;
    private final Message channelPost;
    private final Message editChannelPost;
    private final InlineQuery inlineQuery;
    private final ChosenInlineResult chosenInlineResult;
    private final CallbackQuery callbackQuery;

    // this class will not be handled by custom object mapper, so we need to go full-annotation here
    @JsonCreator
    public Update(
            int updateId,
            Message message,
            Message editedMessage,
            Message channelPost,
            Message editChannelPost,
            InlineQuery inlineQuery,
            ChosenInlineResult chosenInlineResult,
            CallbackQuery callbackQuery) {
        this.updateId = updateId;
        this.message = message;
        this.editedMessage = editedMessage;
        this.channelPost = channelPost;
        this.editChannelPost = editChannelPost;
        this.inlineQuery = inlineQuery;
        this.chosenInlineResult = chosenInlineResult;
        this.callbackQuery = callbackQuery;
    }

    public int getUpdateId() {
        return updateId;
    }

    public Message getMessage() {
        return message;
    }

    public Message getEditedMessage() {
        return editedMessage;
    }

    public Message getChannelPost() {
        return channelPost;
    }

    public Message getEditChannelPost() {
        return editChannelPost;
    }

    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }


    @Override
    public String toString() {
        return "Update{" +
                "updateId=" + updateId +
                ", message=" + message +
                ", editedMessage=" + editedMessage +
                ", channelPost=" + channelPost +
                ", editChannelPost=" + editChannelPost +
                ", inlineQuery=" + inlineQuery +
                ", chosenInlineResult=" + chosenInlineResult +
                ", callbackQuery=" + callbackQuery +
                '}';
    }
}
