package ru.belov.giphy.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ru.belov.giphy.client.FeignGiphyClient;
import ru.belov.giphy.client.FeignOpenExchangeClient;
import ru.belov.giphy.exceptions.IncorrectCurrencyException;
import ru.belov.giphy.model.ExchangeRate;
import ru.belov.giphy.service.impl.RandomGifServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RandomGifServiceImplTest {

    @MockBean
    private FeignGiphyClient mockGiphyClient;

    @MockBean
    private FeignOpenExchangeClient mockExchangeClient;

    @Autowired
    private RandomGifServiceImpl gifService;

    private ExchangeRate yesterdayRate;
    private ExchangeRate nowRate;

    @BeforeEach
    void setUp() {
        Map<String, Double> now = Map.of("RUB", 55.55);
        Map<String, Double> yesterday = Map.of("RUB", 56.66);
        nowRate = new ExchangeRate("USD", new Timestamp(System.currentTimeMillis()), now);
        yesterdayRate = new ExchangeRate("USD", new Timestamp(System.currentTimeMillis()), yesterday);
    }

    @Test
    void whenDeliverCorrectCurrencyThenReturnResponseEntityMapObject() {
        //given
        String currency = "RUB";
        ResponseEntity<Map<String, Object>> expected =
                new ResponseEntity<Map<String,Object>>(
                        new HashMap<String,Object>(Map.of("nowRate", nowRate, "yestardayRate", yesterdayRate)),
                        HttpStatus.OK);

        //when
        Mockito.when(mockExchangeClient.getYesterdayRate(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
        .thenReturn(new ResponseEntity<Object>(yesterdayRate, HttpStatus.OK));

        Mockito.when(mockExchangeClient.getRate(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(new ResponseEntity<Object>(nowRate, HttpStatus.OK));

        Mockito.when(mockGiphyClient.getRandom(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(new ResponseEntity<Map<String,Object>>(new HashMap<String,Object>(), HttpStatus.OK));

        ResponseEntity<Map<String, Object>> actual= gifService.getRandomGif(currency);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void whenDeliverIncorrectCurrencyThenThrowCustomException () {
        //given
        String incorrectCurency = "RUBB";
        String expected = "Неправильная валюта: RUBB";

        //when
        Mockito.when(mockExchangeClient.getYesterdayRate(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
        .thenReturn(null);

        Mockito.when(mockExchangeClient.getRate(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(null);

        IncorrectCurrencyException exception = assertThrows(IncorrectCurrencyException.class,
                () -> gifService.getRandomGif(incorrectCurency));

        String actual = exception.getMessage();

        //then
        assertEquals(expected, actual);
    }

}
