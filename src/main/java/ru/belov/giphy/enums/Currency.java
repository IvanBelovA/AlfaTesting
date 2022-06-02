package ru.belov.giphy.enums;

public enum Currency {

    //Russian ruble
    RUB("RUB (Российский рубль)"),
    //Indian Rupee
    INR("INR (Индийский рупий)"),
    //Chinese Yuan
    CNY("CNY (Китайский юань)"),
    //Euro
    EUR("EUR (Евро)");

    private final String currencyRate;

    Currency(String currency) {
        this.currencyRate = currency;
    }

    public String getCurrency() {
        return currencyRate;
    }

}
