package ru.shadam.tg.request;

import java.util.List;

/**
 * @author sala
 */
public class GetUpdatesRequest {
    /**
     * 	Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id. The negative offset can be specified to retrieve updates starting from -offset update from the end of the updates queue. All previous updates will forgotten.
     */
    private final Integer offset;
    /**
     *  Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     */
    private final Integer limit;
    /**
     * Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
     */
    private final Integer timeout;
    /**
     * List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.
     */
    private final List<String> allowedUpdates;

    public GetUpdatesRequest() {
        offset = null;
        limit = null;
        timeout = null;
        allowedUpdates = null;
    }

    public GetUpdatesRequest(Integer offset, Integer limit, Integer timeout, List<String> allowedUpdates) {
        this.offset = offset;
        this.limit = limit;
        this.timeout = timeout;
        this.allowedUpdates = allowedUpdates;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public List<String> getAllowedUpdates() {
        return allowedUpdates;
    }
}
