package com.sg.oauth.util;

import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;

public class ResponseUtil {

  public static void setJsonResponse(final HttpServletResponse response, final String json)
      throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.getOutputStream().println(json);
  }
}
