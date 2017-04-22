package ru.shadam.tg.enitity;

import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 */
public class InlineKeyboardMarkup implements KeyboardMarkup {
    private final List<List<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup(List<List<InlineKeyboardButton>> inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    public List<List<InlineKeyboardButton>> getInlineKeyboard() {
        return inlineKeyboard;
    }
}
