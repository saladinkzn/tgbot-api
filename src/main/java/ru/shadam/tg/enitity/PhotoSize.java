package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PhotoSize {
    private final String fileId;
    private final int width;
    private final int height;
    private final Integer fileSize;

    public PhotoSize(
            @JsonProperty("file_id") String fileId,
            int width,
            int height,
            @JsonProperty("file_size") Integer fileSize
    ) {
        this.fileId = fileId;
        this.width = width;
        this.height = height;
        this.fileSize = fileSize;
    }

    public String getFileId() {
        return fileId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Integer getFileSize() {
        return fileSize;
    }
}
