package ru.shadam.tg.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.client.ResponseActions;
import org.springframework.web.client.RestTemplate;
import ru.shadam.tg.api.impl.TelegramApiService;
import ru.shadam.tg.mapper.ObjectMapperFactory;
import ru.shadam.tg.util.LoggingClientHttpRequestInterceptor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author sala
 */
public abstract class AbstractMessageTest {
    protected static final String BASE_URL = "https://api.telegram.org";
    protected static final String TOKEN = "TOKEN";
    protected TelegramApi telegramApi;
    protected MockRestServiceServer server;

    @Before
    public void setUp() throws Exception {
        ObjectMapperFactory objectMapperFactory = new ObjectMapperFactory();

        ObjectMapper objectMapper = objectMapperFactory.getObjectMapper();

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter(objectMapper);

        RestTemplate restTemplate = new RestTemplate(Collections.singletonList(messageConverter));

        restTemplate.setInterceptors(Collections.singletonList(new LoggingClientHttpRequestInterceptor()));

        server = MockRestServiceServer.bindTo(restTemplate).build();

        telegramApi = new TelegramApiService(BASE_URL, TOKEN, restTemplate, objectMapper);
    }

    protected void createExpectation(String body) {
        createExpectation(body, Collections.emptyList());
    }

    protected void createExpectation(String body, RequestMatcher... requestMatchers) {
        createExpectation(body, Arrays.asList(requestMatchers));
    }

    protected void createExpectation(String body, List<RequestMatcher> requestMatchers) {
        ResponseActions responseActions = server.expect(ExpectedCount.manyTimes(), requestTo(BASE_URL + "/bot" + TOKEN + "/sendMessage"))
                .andExpect(method(HttpMethod.POST));
        requestMatchers.forEach(responseActions::andExpect);
        responseActions
                .andRespond(withSuccess(body, MediaType.APPLICATION_JSON_UTF8));
    }
}
