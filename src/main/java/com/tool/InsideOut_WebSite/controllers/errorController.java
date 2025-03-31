package com.tool.InsideOut_WebSite.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface errorController {
    @GetMapping("/error")
    String handleError(HttpServletRequest request);
}
