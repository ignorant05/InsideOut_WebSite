package com.tool.InsideOut_WebSite.helperFunctions;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public interface fileConversion {
    public File convertFromMultipartFileToFile(MultipartFile multipartFile) throws Exception;
}
