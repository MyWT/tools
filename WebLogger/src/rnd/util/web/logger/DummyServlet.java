package rnd.util.web.logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rnd.util.logger.Logger;
import rnd.util.logger.LoggerFactory;

public class DummyServlet extends HttpServlet {

	public DummyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger l = LoggerFactory.getWebLogger("logger");

		for (int i = 0; i < 5; i++) {
			l.log("hello " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				l.log(e.getMessage());
			}
		}

//		synchronized (l) {
//			l.notify();
//		}

	}

}
