package ru.belov.giphy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfaGiphyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfaGiphyApplication.class, args);
    }

}
