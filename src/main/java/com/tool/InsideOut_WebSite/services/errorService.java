
package com.tool.InsideOut_WebSite.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface errorService {
  String handleError(HttpServletRequest request);
}
