package com.tool.InsideOut_WebSite.Controllers.controllerCode;

import com.tool.InsideOut_WebSite.Controllers.errorController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.ILoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class errorControllerImpl implements errorController {
    Logger logger = LoggerFactory.getLogger(errorControllerImpl.class);
    @Override
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){

        logger.info("Handling error in errorControllerImpl");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        logger.info("Status code is {}", status);
        if(status != null){
            int statusCode = Integer.parseInt(status.toString());
            return switch (statusCode) {
                case 400 -> "errors/400";
                case 500 -> "errors/500";
                case 502 -> "errors/502";
                default -> "errors/404";
            };
        }

        return "errors/404";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
