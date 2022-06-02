package ru.belov.giphy.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphyClient", url = "${giphy.url}")
public interface FeignGiphyClient {

    @GetMapping("/random")
    ResponseEntity<Map<String, Object>> getRandom (
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
            );

}
