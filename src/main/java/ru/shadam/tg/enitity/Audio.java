package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Audio {
    private final String fileId;
    private final int duration;
    private final String performer;
    private final String title;
    private final String mimeType;
    private final Integer fileSize;

    public Audio(
            String fileId,
            int duration,
            String performer,
            String title,
            String mimeType,
            Integer fileSize
    ) {
        this.fileId = fileId;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public String getFileId() {
        return fileId;
    }

    public int getDuration() {
        return duration;
    }

    public String getPerformer() {
        return performer;
    }

    public String getTitle() {
        return title;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }
}
