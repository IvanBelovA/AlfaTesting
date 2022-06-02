package ru.belov.giphy.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface RandomGifService {

    ResponseEntity<Map<String, Object>> getRandomGif(String currency);

}
