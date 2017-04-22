package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;
import ru.shadam.tg.enitity.ParseMode;

/**
 * @author sala
 */
public class SendMessageOptions extends SendOptions {
    public static final SendMessageOptions EMPTY = new SendMessageOptions(null, null, null, null, null);

    protected ParseMode parseMode;
    protected Boolean disableWebPagePreview;

    public SendMessageOptions() {
    }

    public SendMessageOptions(ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, KeyboardMarkup replyMarkup, Boolean disableNotification) {
        super(disableNotification, replyToMessageId, replyMarkup);
        this.parseMode = parseMode;
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public ParseMode getParseMode() {
        return parseMode;
    }

    public void setParseMode(ParseMode parseMode) {
        this.parseMode = parseMode;
    }

    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public void setDisableWebPagePreview(Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }
}
