package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InlineQuery {
    private String id;
    private User from;
    private Location location;
    private String query;
    private String offset;

    public InlineQuery(String id, User from, Location location, String query, String offset) {
        this.id = id;
        this.from = from;
        this.location = location;
        this.query = query;
        this.offset = offset;
    }

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public Location getLocation() {
        return location;
    }

    public String getQuery() {
        return query;
    }

    public String getOffset() {
        return offset;
    }
}
