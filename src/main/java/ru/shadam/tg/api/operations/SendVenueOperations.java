package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Message;
import ru.shadam.tg.options.SendVenueOptions;

/**
 * @author sala
 */
public interface SendVenueOperations {
    Message sendVenue(long chatId, String venue, SendVenueOptions options);

    Message sendVenue(String chatId, String venue, SendVenueOptions options);
}
