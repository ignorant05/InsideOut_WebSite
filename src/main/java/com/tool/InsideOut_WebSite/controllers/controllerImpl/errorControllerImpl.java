package com.tool.InsideOut_WebSite.controllers.controllerImpl;

import com.tool.InsideOut_WebSite.controllers.errorController;
import com.tool.InsideOut_WebSite.services.servicesImpl.errorServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorControllerImpl implements errorController {

    private errorServiceImpl service;

    public errorControllerImpl(errorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        return service.handleError(request);
    }
}
