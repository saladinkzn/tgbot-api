package ru.shadam.tg.enitity;

/**
 * @author sala
 */
public abstract class Attachment {
    private final String fileId;

    public Attachment(String fileId) {
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }
}
