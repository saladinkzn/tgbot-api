package ru.shadam.tg.enitity;

/**
 * You can provide an animation for your game so that it looks stylish in chats (check out Lumberjack for an example). This object represents an animation file to be displayed in the message containing a game.
 */
public class Animation {
    /**
     * 	Unique file identifier
     */
    private final String fileId;
    /**
     * Optional. Animation thumbnail as defined by sender
     */
    private final PhotoSize thumb;
    /**
     * Optional. Original animation filename as defined by sender
     */
    private final String fileName;
    /**
     * Optional. MIME type of the file as defined by sender
     */
    private final String mimeType;
    /**
     * Optional. File size
     */
    private final Integer fileSize;

    public Animation(String fileId, PhotoSize thumb, String fileName, String mimeType, Integer fileSize) {
        this.fileId = fileId;
        this.thumb = thumb;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public String getFileId() {
        return fileId;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Integer getFileSize() {
        return fileSize;
    }
}
