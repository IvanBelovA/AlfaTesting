package ru.belov.giphy.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.belov.giphy.exceptions.IncorrectCurrencyException;
import ru.belov.giphy.service.RandomGifService;

@RestController
@RequestMapping("giphy-app/api")
public class RandomGifController {

    @Autowired
    private RandomGifService rateService;

    @GetMapping("/random-gif")
    public ResponseEntity<Map<String, Object>> getRandomGif(
            @RequestParam(value = "currency") String currency) {
        return rateService.getRandomGif(currency);
    }

    @ExceptionHandler(IncorrectCurrencyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIncorrectCurrencyException(IncorrectCurrencyException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}
