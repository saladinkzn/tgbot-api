package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Contains information about why a request was unsuccessfull.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseParameters {
    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    private final Long migrateToChatId;
    /**
     *  Optional. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
     */
    private final Integer retryAfter;

    public ResponseParameters(Long migrateToChatId, Integer retryAfter) {
        this.migrateToChatId = migrateToChatId;
        this.retryAfter = retryAfter;
    }

    public Long getMigrateToChatId() {
        return migrateToChatId;
    }

    public Integer getRetryAfter() {
        return retryAfter;
    }
}
