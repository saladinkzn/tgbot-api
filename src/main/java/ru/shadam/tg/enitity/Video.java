package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Video extends Attachment {
    private final int width;
    private final int height;
    private final int duration;
    private final PhotoSize thumb;
    private final String mimeType;
    private final Integer fileSize;

    public Video(
            @JsonProperty("file_id") String fileId,
            int width,
            int height,
            int duration,
            PhotoSize thumb,
            @JsonProperty("mime_type") String mimeType,
            @JsonProperty("file_size") Integer fileSize
    ) {
        super(fileId);
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.thumb = thumb;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDuration() {
        return duration;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }
}
