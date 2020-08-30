package com.example.demo.httpclient;

public interface HttpClient {
    <T> T get(String httpGet, Class<T> classToGet);
}
