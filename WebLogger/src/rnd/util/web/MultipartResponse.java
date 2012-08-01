package rnd.util.web;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/** 
 * <blockquote><pre>
 * MultipartResponse multi = new MultipartResponse(res);
 * &nbsp;
 * multi.startResponse("text/plain");
 * out.println("On your mark");
 * multi.endResponse();
 * &nbsp;
 * try { Thread.sleep(2000); } catch (InterruptedException e) { }
 * &nbsp;
 * multi.startResponse("text/plain");
 * out.println("Get set");
 * multi.endResponse();
 * &nbsp;
 * multi.finish();
 * </pre></blockquote>
 */
public class MultipartResponse {

  HttpServletResponse res;
  ServletOutputStream out;
  boolean endedLastResponse = true;

  public MultipartResponse(HttpServletResponse response) throws IOException {
    res = response;
    out = res.getOutputStream();

    res.setContentType("multipart/x-mixed-replace;boundary=End");
    out.println("--End");
  }

  public void startResponse(String contentType) throws IOException {
    if (!endedLastResponse) {
      endResponse();
    }
    out.println("Content-type: " + contentType);
    endedLastResponse = false;
  }

  public void endResponse() throws IOException {
    out.println("--End");
    out.flush();
    endedLastResponse = true;
  }

  public void finish() throws IOException {
    out.println("--End--");
    out.flush();
  }
}
