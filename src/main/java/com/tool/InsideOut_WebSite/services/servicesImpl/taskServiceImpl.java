
package com.tool.InsideOut_WebSite.services.servicesImpl;

import com.methods.required.classes.Operations;
import com.tool.InsideOut_WebSite.services.taskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

import com.tool.InsideOut_WebSite.helperFunctions.*;

@Service
public class taskServiceImpl implements taskService {

  @Autowired
  fileConversion fconv;

  @Override
  public ResponseEntity<byte[]> upload(
      @RequestParam("file") MultipartFile file,
      @RequestParam(value = "operation") String operation,
      @RequestParam(value = "compressionType", required = false) String type) {
    try {
      File inputFile = fconv.convertFromMultipartFileToFile(file);
      File processedFile = null;

      if ("compression".equals(operation)) {
        switch (type.toLowerCase()) {
          case "zip": {
            processedFile = Operations.compressToZip(inputFile);
            break;
          }
          case "gz": {
            processedFile = Operations.compressToGzip(inputFile);
            break;
          }
          case "bzip2": {
            processedFile = Operations.compressToBzip2(inputFile);
            break;
          }
          case "lz4": {
            processedFile = Operations.compressToLz4(inputFile);
            break;
          }
          case "xz": {
            processedFile = Operations.compressToXZ(inputFile);
            break;
          }
          case "tar": {
            processedFile = Operations.compressToTar(inputFile);
            break;
          }
          case "lzma": {
            processedFile = Operations.compressToLzma(inputFile);
            break;
          }
        }
      } else if ("decompression".equals(operation)) {
        String fileExtension = inputFile.getName().substring(inputFile.getName().lastIndexOf(".") + 1);

        if (fileExtension.isEmpty()) {
          return ResponseEntity
              .status(HttpStatus.BAD_REQUEST)
              .body(("Error: file without any extension " + inputFile.getName() + "/nPlease Provide a valid file.")
                  .getBytes());
        }

        switch (fileExtension.toLowerCase()) {
          case "zip": {
            processedFile = Operations.decompressFromZip(inputFile);
            break;
          }
          case "gz": {
            processedFile = Operations.decompressFromGzip(inputFile);
            break;
          }
          case "bzip2": {
            processedFile = Operations.decompressFromBzip2(inputFile);
            break;
          }
          case "lz4": {
            processedFile = Operations.decompressFromLz4(inputFile);
            break;
          }
          case "xz": {
            processedFile = Operations.decompressFromXZ(inputFile);
            break;
          }
          case "tar": {
            processedFile = Operations.decompressFromTar(inputFile);
            break;
          }
          case "lzma": {
            processedFile = Operations.decompressFromLzma(inputFile);
            break;
          }
          default:
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Error: Unable to decompress the file. Unknown file extension or processing error.".getBytes());
        }
      }

      assert processedFile != null;
      byte[] processedData = Files.readAllBytes(processedFile.toPath());

      HttpHeaders headers = new HttpHeaders();
      headers.setContentDisposition(
          ContentDisposition.attachment()
              .filename(processedFile.getName())
              .build());

      return ResponseEntity
          .ok()
          .headers(headers)
          .contentType(MediaType.APPLICATION_OCTET_STREAM)
          .body(processedData);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(("Error: " + e.getMessage()).getBytes());
    }
  }
}
