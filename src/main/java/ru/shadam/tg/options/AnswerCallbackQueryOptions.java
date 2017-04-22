package ru.shadam.tg.options;

/**
 * @author sala
 */
public class AnswerCallbackQueryOptions {
    public static final AnswerCallbackQueryOptions EMPTY = new AnswerCallbackQueryOptions(null, null, null, null);

    private String text;
    private Boolean showAlert;
    private String url;
    private Integer cacheTime;

    public AnswerCallbackQueryOptions(String text, Boolean showAlert, String url, Integer cacheTime) {
        this.text = text;
        this.showAlert = showAlert;
        this.url = url;
        this.cacheTime = cacheTime;
    }

    public String getText() {
        return text;
    }

    public Boolean getShowAlert() {
        return showAlert;
    }

    public String getUrl() {
        return url;
    }

    public Integer getCacheTime() {
        return cacheTime;
    }
}
