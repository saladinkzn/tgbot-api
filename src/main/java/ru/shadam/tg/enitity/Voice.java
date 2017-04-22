package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Voice extends Attachment {
    private int duration;
    private String mimeType;
    private Integer fileSize;

    public Voice(String fileId, int duration, String mimeType, Integer fileSize) {
        super(fileId);
        this.duration = duration;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public int getDuration() {
        return duration;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }
}
