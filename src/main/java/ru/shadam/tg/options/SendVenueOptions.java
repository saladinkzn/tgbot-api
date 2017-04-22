package ru.shadam.tg.options;

import ru.shadam.tg.enitity.KeyboardMarkup;

/**
 * @author sala
 */
public class SendVenueOptions extends SendOptions {
    public static final SendVenueOptions EMPTY = new SendVenueOptions(null, null, null, null);

    private String foursquareId;

    public SendVenueOptions(String foursquareId, Boolean disableNotification, Integer replyToMessageId, KeyboardMarkup replyMarkup) {
        super(disableNotification, replyToMessageId, replyMarkup);
        this.foursquareId = foursquareId;
    }

    public String getFoursquareId() {
        return foursquareId;
    }
}
