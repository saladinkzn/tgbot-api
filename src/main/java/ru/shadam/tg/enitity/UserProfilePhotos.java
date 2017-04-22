package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserProfilePhotos {
    private int totalCount;
    private List<List<PhotoSize>> photos;

    public UserProfilePhotos(
            @JsonProperty("total_count") int totalCount,
            List<List<PhotoSize>> photos
    ) {
        this.totalCount = totalCount;
        this.photos = photos;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }
}
