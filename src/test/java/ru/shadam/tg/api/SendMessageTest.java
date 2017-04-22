package ru.shadam.tg.api;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.client.RequestMatcher;
import ru.shadam.tg.enitity.*;
import ru.shadam.tg.options.SendMessageOptions;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

/**
 * @author sala
 */
public class SendMessageTest extends AbstractMessageTest {

    public static final int CHAT_ID = 151904085;
    public static final String TEXT = "Response";
    public static final int REPLY_MESSAGE_ID = 500;

    @Test
    public void sendMessage() {
        createExpectation("{\n" +
                "  \"ok\": true,\n" +
                "  \"result\": {\n" +
                "    \"message_id\": 499,\n" +
                "    \"from\": {\n" +
                "      \"id\": 273549269,\n" +
                "      \"first_name\": \"MrDotabuff-testing\",\n" +
                "      \"username\": \"MrDotabuffTestBot\"\n" +
                "    },\n" +
                "    \"chat\": {\n" +
                "      \"id\": 151904085,\n" +
                "      \"first_name\": \"Тимур\",\n" +
                "      \"last_name\": \"Шакуров\",\n" +
                "      \"username\": \"saladinkzn\",\n" +
                "      \"type\": \"private\"\n" +
                "    },\n" +
                "    \"date\": 1491862114,\n" +
                "    \"text\": \"Hello, world!\"\n" +
                "  }\n" +
                "}");

        Message message = telegramApi.sendMessage(123, "Hello, world!");
        assertEquals(499, message.getMessageId());

        assertEquals(273549269, message.getFrom().getId());
        assertEquals("MrDotabuff-testing", message.getFrom().getFirstName());
        assertEquals("MrDotabuffTestBot", message.getFrom().getUsername());

        Chat chat = message.getChat();
        assertEquals(151904085L, chat.getId().longValue());
        assertEquals("Тимур", chat.getFirstName());
        assertEquals("Шакуров", chat.getLastName());
        assertEquals("saladinkzn", chat.getUsername());
        assertEquals(ChatType.PRIVATE, chat.getType());
        assertEquals(Instant.ofEpochSecond(1491862114), message.getDate());
        assertEquals("Hello, world!", message.getText());
    }

    @Test
    public void sendReply() {
        int replyToMessageId = REPLY_MESSAGE_ID;
        int chatId = CHAT_ID;
        String text = TEXT;

        List<RequestMatcher> requestMatchers = Arrays.asList(
                jsonPath("$.reply_to_message_id", is(replyToMessageId)),
                jsonPath("$.chat_id", CoreMatchers.equalTo(chatId)),
                jsonPath("$.text", is(text))
        );

        createExpectation("{\n" +
                "  \"ok\": true,\n" +
                "  \"result\": {\n" +
                "    \"message_id\": 501,\n" +
                "    \"from\": {\n" +
                "      \"id\": 273549269,\n" +
                "      \"first_name\": \"MrDotabuff-testing\",\n" +
                "      \"username\": \"MrDotabuffTestBot\"\n" +
                "    },\n" +
                "    \"chat\": {\n" +
                "      \"id\": 151904085,\n" +
                "      \"first_name\": \"Тимур\",\n" +
                "      \"last_name\": \"Шакуров\",\n" +
                "      \"username\": \"saladinkzn\",\n" +
                "      \"type\": \"private\"\n" +
                "    },\n" +
                "    \"date\": 1492107642,\n" +
                "    \"reply_to_message\": {\n" +
                "      \"message_id\": 500,\n" +
                "      \"from\": {\n" +
                "        \"id\": 151904085,\n" +
                "        \"first_name\": \"Тимур\",\n" +
                "        \"last_name\": \"Шакуров\",\n" +
                "        \"username\": \"saladinkzn\"\n" +
                "      },\n" +
                "      \"chat\": {\n" +
                "        \"id\": 151904085,\n" +
                "        \"first_name\": \"Тимур\",\n" +
                "        \"last_name\": \"Шакуров\",\n" +
                "        \"username\": \"saladinkzn\",\n" +
                "        \"type\": \"private\"\n" +
                "      },\n" +
                "      \"date\": 1492107398,\n" +
                "      \"text\": \"хелло\"\n" +
                "    },\n" +
                "    \"text\": \"Response\"\n" +
                "  }\n" +
                "}", requestMatchers);



        SendMessageOptions options = new SendMessageOptions();
        options.setReplyToMessageId(replyToMessageId);

        Message response = telegramApi.sendMessage(chatId, text, options);

        Message replyToMessage = response.getReplyToMessage();
        Assert.assertNotNull(replyToMessage);
        assertEquals(500, replyToMessage.getMessageId());
        assertEquals("хелло", replyToMessage.getText());

    }

    @Test
    public void sendFullOptions() {
        List<RequestMatcher> requestMatchers = Arrays.asList(
                jsonPath("$.disable_notification", is(true)),
                jsonPath("$.reply_to_message_id", is(REPLY_MESSAGE_ID)),
                jsonPath("$.reply_markup.keyboard[0][0].text", is("asd")),
                jsonPath("$.parse_mode", is(ParseMode.HTML.toString())),
                jsonPath("$.disable_web_page_preview", is(true))
        );

        createExpectation("{}", requestMatchers);

        List<List<KeyboardButton>> asd = Collections.singletonList(Collections.singletonList(new KeyboardButton("asd", false, false)));

        SendMessageOptions sendMessageOptions = new SendMessageOptions(
                ParseMode.HTML,
                true,
                REPLY_MESSAGE_ID,
                new ReplyKeyboardMarkup(asd, false, true, false),
                true
        );

        telegramApi.sendMessage(CHAT_ID, TEXT, sendMessageOptions);
    }
}
