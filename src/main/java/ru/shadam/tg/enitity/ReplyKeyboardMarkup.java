package ru.shadam.tg.enitity;

import java.util.List;

/**
 * @author sala
 */
public class ReplyKeyboardMarkup implements KeyboardMarkup {
    private final List<List<KeyboardButton>> keyboard;
    private final Boolean resizeKeyboard;
    private final Boolean oneTimeKeyboard;
    private final Boolean selective;

    public ReplyKeyboardMarkup(List<List<KeyboardButton>> keyboard, Boolean resizeKeyboard, Boolean oneTimeKeyboard, Boolean selective) {
        this.keyboard = keyboard;
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
        this.selective = selective;
    }

    public List<List<KeyboardButton>> getKeyboard() {
        return keyboard;
    }

    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    public Boolean getSelective() {
        return selective;
    }
}
