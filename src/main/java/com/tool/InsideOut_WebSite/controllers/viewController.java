package com.tool.InsideOut_WebSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface viewController {
    @GetMapping(path = "/home")
    String home();

    @GetMapping(path = "/about")
    String about();

    @GetMapping(path = "/tasks")
    String tasks();
}
