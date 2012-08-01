package rnd.util.web.logger;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import rnd.util.logger.Logger;
import rnd.util.web.MultipartResponse;

public class WebLogger extends Logger<HttpServletResponse> {

	private MultipartResponse multipartResponse;

	public void log(String message) {
		try {
			multipartResponse.startResponse("text/plain");
			handler.getOutputStream().println(message);
			multipartResponse.endResponse();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addListnerInt(HttpServletResponse handler) {
		try {
			multipartResponse = new MultipartResponse(handler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
