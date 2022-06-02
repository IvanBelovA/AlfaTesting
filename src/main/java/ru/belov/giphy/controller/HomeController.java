package ru.belov.giphy.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.belov.giphy.enums.Currency;

@Controller
@RequestMapping("/giphy-app")
public class HomeController {

    @GetMapping("/get-gif")
    public String getRandomGif(Model model) {
        model.addAttribute("currencies", Arrays.asList(Currency.values()));
        return "home";
    }

}
