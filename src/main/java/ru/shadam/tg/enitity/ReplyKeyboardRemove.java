package ru.shadam.tg.enitity;

/**
 * @author sala
 */
public class ReplyKeyboardRemove implements KeyboardMarkup {
    private final Boolean removeKeyboard;
    private final Boolean selective;

    public ReplyKeyboardRemove(Boolean removeKeyboard, Boolean selective) {
        this.removeKeyboard = removeKeyboard;
        this.selective = selective;
    }

    public Boolean getRemoveKeyboard() {
        return removeKeyboard;
    }

    public Boolean getSelective() {
        return selective;
    }
}
