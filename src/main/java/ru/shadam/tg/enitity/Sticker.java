package ru.shadam.tg.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sala
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Sticker extends Attachment {
    private final int width;
    private final int height;
    private final PhotoSize thumb;
    private final String emoji;
    private final Integer fileSize;

    public Sticker(
            String fileId,
            int width,
            int height,
            PhotoSize thumb,
            String emoji,
            Integer fileSize
    ) {
        super(fileId);
        this.width = width;
        this.height = height;
        this.thumb = thumb;
        this.emoji = emoji;
        this.fileSize = fileSize;
    }

    public int getWidth() {
        return width;
    }
}
