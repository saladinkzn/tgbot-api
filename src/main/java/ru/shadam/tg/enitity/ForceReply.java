package ru.shadam.tg.enitity;

/**
 * @author sala
 */
public class ForceReply implements KeyboardMarkup {
    /**
     * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
     */
    private final Boolean forceReply;
    /**
     * Optional. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    private final Boolean selective;

    public ForceReply(Boolean forceReply, Boolean selective) {
        this.forceReply = forceReply;
        this.selective = selective;
    }

    public Boolean getForceReply() {
        return forceReply;
    }

    public Boolean getSelective() {
        return selective;
    }
}
