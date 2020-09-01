package com.example.demo.httpclient;

import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientImp implements HttpClient {

    @Override
    public <T> T get(String httpGet, Class<T> classToGet) {
        var restTemplate = new RestTemplate();
        return restTemplate.getForObject(httpGet, classToGet);
    }
}
