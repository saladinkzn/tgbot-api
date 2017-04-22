package ru.shadam.tg.enitity;

/**
 * @author sala
 */
public class KeyboardButton {
    private final String text;
    private final Boolean requestContact;
    private final Boolean requestLocation;

    public KeyboardButton(String text, Boolean requestContact, Boolean requestLocation) {
        this.text = text;
        this.requestContact = requestContact;
        this.requestLocation = requestLocation;
    }

    public String getText() {
        return text;
    }

    public Boolean getRequestContact() {
        return requestContact;
    }

    public Boolean getRequestLocation() {
        return requestLocation;
    }
}
