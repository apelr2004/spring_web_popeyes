package com.example.b01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class NewsController {

    @GetMapping("/news/news1")
    public void news1() {
    }

    @GetMapping("/news/news2")
    public void news2() {
    }

    @GetMapping("/news/event1")
    public void event1() {
    }

    @GetMapping("/news/event2")
    public void event2() {
    }

}
