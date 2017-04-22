package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Venue {
    private final Location location;
    private final String title;
    private final String address;
    private final String foursquareId;

    public Venue(Location location, String title, String address,
                 @JsonProperty("foursquare_id") String foursquareId) {
        this.location = location;
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
    }

    public Location getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getFoursquareId() {
        return foursquareId;
    }
}
