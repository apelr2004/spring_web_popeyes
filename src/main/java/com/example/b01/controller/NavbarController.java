package com.example.b01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class NavbarController {

    @GetMapping
    public String root() {

        return "redirect:/main";
    }

    @GetMapping("/main")
    public void main() {
    }

    @GetMapping("/navbar/history")
    public void history() {
    }

    @GetMapping("/navbar/product")
    public void product() {
    }

    @GetMapping("/navbar/news")
    public void news() {
    }
}
