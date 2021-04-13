package ru.geekbrains.spring.springlesson3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    //localhost:8189/app/test
    @GetMapping("/test")
    @ResponseBody
    public String showTestMessage(){return "Test returns success";}
}
