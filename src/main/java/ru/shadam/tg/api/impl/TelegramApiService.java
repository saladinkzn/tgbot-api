package ru.shadam.tg.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.shadam.tg.api.TelegramApi;
import ru.shadam.tg.enitity.*;
import ru.shadam.tg.enitity.util.ResultWrapper;
import ru.shadam.tg.exception.TelegramClientException;
import ru.shadam.tg.hook.Update;
import ru.shadam.tg.io.NamedResource;
import ru.shadam.tg.options.*;
import ru.shadam.tg.request.SendMessageRequest;
import ru.shadam.tg.request.SendPhotoRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import static ru.shadam.tg.util.MultiValueMapUtil.addIfNotNull;

/**
 * @author sala
 */
public class TelegramApiService implements TelegramApi {
    private static final ParameterizedTypeReference<ResultWrapper<Message>>
            RESULT_WRAPPER_MESSAGE_REFERENCE = new ParameterizedTypeReference<ResultWrapper<Message>>() { };
    private final String baseUrl;
    private final String token;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public TelegramApiService(String baseUrl, String token, RestTemplate restTemplate, ObjectMapper objectMapper) {
        Assert.notNull(baseUrl, "baseUrl cannot be null");
        Assert.notNull(token, "token cannot be null");
        Assert.notNull(restTemplate, "restTemplate cannot be null");
        Assert.notNull(objectMapper, "objectMapper cannot be null");
        this.baseUrl = baseUrl;
        this.token = token;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout, List<String> allowedUpdates) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendMessage(long chatId, String text, SendMessageOptions options) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).pathSegment("bot" + token)
                .path("/sendMessage")
                .build()
                .toUri();
        SendMessageRequest messageRequest = new SendMessageRequest(
                chatId,
                text,
                options.getParseMode(),
                options.getDisableWebPagePreview(),
                options.getReplyToMessageId(),
                options.getReplyMarkup(),
                options.getDisableNotification()
        );
        ResponseEntity<ResultWrapper<Message>> responseEntity = restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(messageRequest), RESULT_WRAPPER_MESSAGE_REFERENCE
        );
        return responseEntity.getBody().getResult();
    }

    @Override
    public Message sendMessage(String chatId, String text, SendMessageOptions options) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).pathSegment("bot" + token)
                .path("/sendMessage")
                .build()
                .toUri();
        SendMessageRequest messageRequest = new SendMessageRequest(
                chatId,
                text,
                options.getParseMode(),
                options.getDisableWebPagePreview(),
                options.getReplyToMessageId(),
                options.getReplyMarkup(),
                options.getDisableNotification()
        );
        return restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(messageRequest), RESULT_WRAPPER_MESSAGE_REFERENCE
        ).getBody().getResult();
    }

    @Override
    public Message forwardMessage(long chatId, long fromChatId, int messageId, Boolean disableNotification) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message forwardMessage(String chatId, String fromChatId, int messageId, Boolean disableNotification) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendPhoto(long chatId, String photo, SendPhotoOptions options) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).pathSegment("bot" + token)
                .path("/sendMessage")
                .build()
                .toUri();

        SendPhotoRequest sendPhotoRequest = new SendPhotoRequest(
                chatId,
                photo,
                options.getCaption(),
                options.getDisableNotification(),
                options.getReplyToMessageId(),
                options.getReplyMarkup()
        );
        
        return restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(sendPhotoRequest), RESULT_WRAPPER_MESSAGE_REFERENCE
        ).getBody().getResult();
    }

    @Override
    public Message sendPhoto(String chatId, String photo, SendPhotoOptions options) {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).pathSegment("bot" + token)
                .path("/sendMessage")
                .build()
                .toUri();

        SendPhotoRequest sendPhotoRequest = new SendPhotoRequest(
                chatId,
                photo,
                options.getCaption(),
                options.getDisableNotification(),
                options.getReplyToMessageId(),
                options.getReplyMarkup()
        );

        return restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(sendPhotoRequest), RESULT_WRAPPER_MESSAGE_REFERENCE
        ).getBody().getResult();
    }

    @Override
    public Message sendPhoto(long chatId, String fileName, InputStream stream, SendPhotoOptions options) {
        NamedResource namedResource = prepareInputStream(fileName, stream);
        return sendPhoto(String.valueOf(chatId), namedResource, options);
    }

    @Override
    public Message sendPhoto(String chatId, String fileName, InputStream stream, SendPhotoOptions options) {
        NamedResource namedResource = prepareInputStream(fileName, stream);
        return sendPhoto(chatId, namedResource, options);
    }

    @Override
    public Message sendPhoto(long chatId, java.io.File file, SendPhotoOptions options) {
        return sendPhoto(String.valueOf(chatId), new FileSystemResource(file), options);
    }

    @Override
    public Message sendPhoto(String chatId, java.io.File file, SendPhotoOptions options) {
        return sendPhoto(chatId, new FileSystemResource(file), options);
    }
    
    private Message sendPhoto(String chatIdString, Resource namedResource, SendPhotoOptions options) {
        Assert.notNull(namedResource, "namedResource must not be null");
        Assert.notNull(options, "options must not be null");

        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).pathSegment("bot" + token)
                .path("/sendPhoto")
                .build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        LinkedMultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("chat_id", chatIdString);
        addIfNotNull(body, "caption", options.getCaption());
        addIfNotNull(body, "disable_notification", options.getDisableNotification());
        addIfNotNull(body, "reply_to_message_id", options.getReplyToMessageId());
        if (options.getReplyMarkup() != null) {
            try {
                body.add("reply_markup", objectMapper.writeValueAsString(options.getReplyMarkup()));
            } catch (JsonProcessingException jsonProcessingException) {
                throw new TelegramClientException("Error serializing reply markup", jsonProcessingException);
            }
        }

        body.add("photo", namedResource);

        return restTemplate.exchange(
                uri,
                HttpMethod.POST,
                new HttpEntity<>(body, headers),
                new ParameterizedTypeReference<ResultWrapper<Message>>() {}
        ).getBody().getResult();
    }

    @Override
    public Message sendAudio(long chatId, String audio, SendAudioOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendAudio(String chatId, String audio, SendAudioOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendDocument(long chatId, String document, SendDocumentOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendDocument(String chatId, String document, SendDocumentOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendSticker(long chatId, String sticker, SendStickerOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendSticker(String chatId, String sticker, SendStickerOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendVideo(long chatId, String video, SendVideoOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendVideo(String chatId, String video, SendVideoOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendVoice(long chatId, String voice, SendVoiceOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendVoice(String chatId, String voice, SendVoiceOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendLocation(long chatId, String location, SendLocationOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendLocation(String chatId, String location, SendLocationOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendVenue(long chatId, String venue, SendVenueOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendVenue(String chatId, String venue, SendVenueOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendContact(long chatId, String contact, SendContactOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Message sendContact(String chatId, String contact, SendContactOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean sendChatAction(long chatId, Action action) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean sendChatAction(String chatId, Action action) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(int userId, Integer offset, Integer limit) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public File getFile(String fileId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean kickChatMember(long chatId, Integer userId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean kickChatMember(String chatId, Integer userId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean leaveChat(long chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean leaveChat(String chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean unbanChatMember(long chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean unbanChatMember(String chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Chat getChat(long chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Chat getChat(String chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public List<ChatMember> getChatAdministrators(long chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public List<ChatMember> getChatAdministrators(String chatId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public int getChatMembersCount(long chatId) {
        return 0;
    }

    @Override
    public int getChatMembersCount(String chatId) {
        return 0;
    }

    @Override
    public ChatMember getChatMember(long chatId, int userId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public ChatMember getChatMember(String chatId, int userId) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override
    public Boolean answerCallbackQuery(String callbackQueryId, AnswerCallbackQueryOptions options) {
        throw new UnsupportedOperationException("unsupported");
    }

    private NamedResource prepareInputStream(String fileName, InputStream stream) {
        byte[] bytes;
        try {
            bytes = StreamUtils.copyToByteArray(stream);
        } catch (IOException io) {
            throw new TelegramClientException("Error buffering photo stream", io);
        }
        return new NamedResource(new ByteArrayResource(bytes), fileName);
    }
}
