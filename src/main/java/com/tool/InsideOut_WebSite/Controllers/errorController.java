package com.tool.InsideOut_WebSite.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public interface errorController {
    @RequestMapping("/error")
    String handleError(HttpServletRequest request);

    String getErrorPath();
}
