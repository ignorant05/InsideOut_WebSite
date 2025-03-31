package com.tool.InsideOut_WebSite.services;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface taskService {
    public ResponseEntity<byte[]> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "operation") String operation,
            @RequestParam(value = "compressionType", required = false) String type);
}
