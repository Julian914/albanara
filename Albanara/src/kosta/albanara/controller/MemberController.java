package kosta.albanara.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.action.ActionForward;

@WebServlet("/Member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = null;
		String contextPath = null;
		String command = null;

		requestURI = request.getRequestURI();
		contextPath = request.getContextPath();
		command = requestURI.substring(contextPath.length() + 8);

		ActionForward actionForward = null;

		switch (command) {
		case "testAction.do":
			try {
				// actionForward = new TestAction().execute(request, response);
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
