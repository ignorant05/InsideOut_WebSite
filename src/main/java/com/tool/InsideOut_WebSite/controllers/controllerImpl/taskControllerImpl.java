package com.tool.InsideOut_WebSite.controllers.controllerImpl;

import com.tool.InsideOut_WebSite.controllers.taskController;
import com.tool.InsideOut_WebSite.services.taskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class taskControllerImpl implements taskController {

    @Autowired
    private taskService service;

    @Override
    @PostMapping("/generate")
    public ResponseEntity<byte[]> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "compressionType", required = false) String type) {
        return service.upload(file, operation, type);
    }
}
