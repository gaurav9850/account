package com.account.users.util;

import com.account.users.constants.Apis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate template;

    @Value("${apis.notification.url}" + ":" + "${apis.notification.port}" + Apis.KAFKA)
    private String notification;

    public Map notificationMail(String msg) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(notification)
                .queryParam("msg", msg);
        return template.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Map.class).getBody();
    }
}
