package com.github.easytag.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heart")
public class HeartController {

    @GetMapping("/heart")
    public String heart() {
        return "heart";
    }

}
