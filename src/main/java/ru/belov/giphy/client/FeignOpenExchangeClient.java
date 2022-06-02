package ru.belov.giphy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openExchange", url = "${openexchangerates.url}")
public interface FeignOpenExchangeClient {

    @GetMapping("/latest.json")
    ResponseEntity<Object> getRate(
            @RequestParam("app_id") String appId,
            @RequestParam("symbols") String comparedCurrency
            );

    @GetMapping("/historical/{date}.json")
    ResponseEntity<Object> getYesterdayRate(
            @PathVariable("date") String date,
            @RequestParam("app_id") String appId,
            @RequestParam("symbols") String comparedCurrency
            );

}
