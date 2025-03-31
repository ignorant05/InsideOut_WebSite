
package com.tool.InsideOut_WebSite.helperFunctions.helperFunctionsImpl;

import com.tool.InsideOut_WebSite.helperFunctions.fileConversion;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class fileConversionImpl implements fileConversion {
  @Override
  public File convertFromMultipartFileToFile(
      MultipartFile multipartFile) throws IOException {
    String fileName = multipartFile.getOriginalFilename();
    assert fileName != null;
    File outputFile = new File(System.getProperty("java.io.tmpdir"), fileName);
    multipartFile.transferTo(outputFile);
    return outputFile;
  }
}
