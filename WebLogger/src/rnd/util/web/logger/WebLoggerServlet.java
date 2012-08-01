package rnd.util.web.logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rnd.util.logger.Logger;
import rnd.util.logger.LoggerFactory;

public class WebLoggerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WebLoggerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Logger l = LoggerFactory.getWebLogger("logger");
		l.addListner(response);

		synchronized (l) {
			try {
				l.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
