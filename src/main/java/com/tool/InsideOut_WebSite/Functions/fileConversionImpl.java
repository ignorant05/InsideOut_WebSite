package com.tool.InsideOut_WebSite.Functions;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class fileConversionImpl {
    public static File convertFromMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        File outputFile = new File(System.getProperty("java.io.tmpdir"),fileName);
        multipartFile.transferTo(outputFile);
        return outputFile;
    }
}
