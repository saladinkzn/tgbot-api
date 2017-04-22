package ru.shadam.tg.exception;

/**
 * This exception means that request was not sended to telegram server.
 *
 * @author sala
 */
public class TelegramClientException extends RuntimeException {
    public TelegramClientException(String message) {
        super(message);
    }

    public TelegramClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
