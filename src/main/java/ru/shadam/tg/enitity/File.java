package ru.shadam.tg.enitity;

/**
 * @author sala
 */
public class File extends Attachment {
    private Integer fileSize;
    private String filePath;

    public File(String fileId, Integer fileSize, String filePath) {
        super(fileId);
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }
}
