package ru.belov.giphy.model;

import java.sql.Timestamp;
import java.util.Map;

import lombok.Data;

@Data
public class ExchangeRate {

    private String base;
    private String compared;
    private Timestamp timestamp;
    private Map<String, Double> rates;

    public ExchangeRate() {
    }

    public ExchangeRate(String base, Timestamp timestamp, Map<String, Double> rates) {
        this.base = base;
        this.timestamp = timestamp;
        this.rates = rates;
    }

    public ExchangeRate(String base, String compared, Timestamp timestamp, Map<String, Double> rates) {
        this.base = base;
        this.compared = compared;
        this.timestamp = timestamp;
        this.rates = rates;
    }

}
