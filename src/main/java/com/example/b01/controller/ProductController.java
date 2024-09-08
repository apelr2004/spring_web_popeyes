package com.example.b01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class ProductController {

    @GetMapping("/product/box")
    public void box() {
    }

    @GetMapping("/product/chicken")
    public void chicken() {
    }

    @GetMapping("/product/burger")
    public void burger() {
    }

    @GetMapping("/product/burger1")
    public void burger1() {
    }

    @GetMapping("/product/burger2")
    public void burger2() {
    }

    @GetMapping("/product/burger3")
    public void burger3() {
    }

    @GetMapping("/product/side")
    public void side() {
    }

    @GetMapping("/product/drink")
    public void drink() {
    }
    @GetMapping("/product/sauce")
    public void sauce() {
    }
}
