package com.tool.InsideOut_WebSite.Controllers.controllerCode;

import com.tool.InsideOut_WebSite.Controllers.errorController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class errorControllerImpl implements errorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode != null) {
            Integer sCode = Integer.parseInt(statusCode.toString());
            System.out.println(sCode);
            if(sCode == HttpServletResponse.SC_BAD_REQUEST) return "error/error-400";
            else if (sCode == HttpServletResponse.SC_METHOD_NOT_ALLOWED) return "error/error-405";
            else if (sCode == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) return "error/error-500";
            else if (sCode == HttpServletResponse.SC_BAD_GATEWAY) return "error/error-502";
            else if (sCode == HttpServletResponse.SC_NOT_FOUND) return "error";
        }
        return "error";
    }

}

// update the error file to return a specific paragrapsh with each code error (apparently use dom for everything)