package com.example.nasastealphoto.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UrlCreator {

    public static final String API_KEY = "api_key";
    public static final String SOL = "sol";
    @Value("${nasa.host}")
    private String nasaHost;

    @Value("${nasa.api.key}")
    private String nasaApiKey;

    @Value("${nasa.path}")
    private String nasaPath;

    public String getUrl(String sol) {
        return UriComponentsBuilder.fromHttpUrl(nasaHost + nasaPath)
                .queryParam(API_KEY, nasaApiKey)
                .queryParam(SOL, sol)
                .toUriString();
    }
}
