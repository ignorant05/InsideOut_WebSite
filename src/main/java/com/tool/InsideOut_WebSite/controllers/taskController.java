package com.tool.InsideOut_WebSite.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public interface taskController {
        ResponseEntity<byte[]> upload(
                        @RequestParam("file") MultipartFile file,
                        @RequestParam(value = "compressionType", required = false) String type,
                        @RequestParam(value = "operation") String operation);
}
