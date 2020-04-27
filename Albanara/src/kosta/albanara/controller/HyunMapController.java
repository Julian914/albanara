package kosta.albanara.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.action.ActionForward;
import kosta.albanara.action.HyunMapAction;

@WebServlet("/Main/*")
public class HyunMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = null;
		String contextPath = null;
		String command = null;

		requestURI = request.getRequestURI();
		int findIndex = 0;
	       for (int i = 0; i < requestURI.length(); i++) {
	          String find = requestURI.substring(i, i + 1);
	          if (find.equals("/")) {
	             findIndex = i+1;
	          }
	       }
	    command = requestURI.substring(findIndex);

		ActionForward actionForward = null;

		switch (command) {
		case "hyunMapAction.do":
			try {
				actionForward = new HyunMapAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		// forward using redirect or dispatch

		if (actionForward != null)

		{
			if (actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(actionForward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
