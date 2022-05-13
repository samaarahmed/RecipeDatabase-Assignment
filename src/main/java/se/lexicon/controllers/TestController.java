package se.lexicon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String greeting(Model model){
       String message = "Hello Group 40";

        model.addAttribute("message", message);
        return "home";
    }

}
