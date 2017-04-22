import ru.shadam.tg.enitity.ChatId;

/**
 * @author sala
 */
public class ChatIdWrapper {
    private final ChatId chatId;

    public ChatIdWrapper(ChatId chatId) {
        this.chatId = chatId;
    }

    public ChatId getChatId() {
        return chatId;
    }
}
