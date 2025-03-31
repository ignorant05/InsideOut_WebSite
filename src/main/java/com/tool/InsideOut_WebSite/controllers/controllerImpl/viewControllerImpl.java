package com.tool.InsideOut_WebSite.controllers.controllerImpl;

import com.tool.InsideOut_WebSite.controllers.viewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewControllerImpl implements viewController {

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @GetMapping(path = "/about")
    public String about() {
        return "about";
    }

    @GetMapping(path = "/tasks")
    public String tasks() {
        return "tasks";
    }
}
