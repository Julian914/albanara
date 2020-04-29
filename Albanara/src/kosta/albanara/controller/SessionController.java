package kosta.albanara.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kosta.albanara.action.Action;
import kosta.albanara.action.ActionForward;
import kosta.albanara.action.EmployeeUpdateAction;
import kosta.albanara.action.EmployeeUpdateFormAction;
import kosta.albanara.action.EmployerUpdateAction;
import kosta.albanara.action.EmployerUpdateFormAction;
import kosta.albanara.action.logOutAction;

@WebServlet("/session/*")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = null;
		String contextPath = null;
		String command = null;

		requestURI = request.getRequestURI();
		contextPath = request.getContextPath();
		command = requestURI.substring(contextPath.length() + 9);

		Action action = null;
		ActionForward actionForward = null;

		if (command.equals("UpdateEmployeesForm.do")) {

			action = new EmployeeUpdateFormAction();

			try {
				actionForward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("UpdateEmployees.do")) {

			action = new EmployeeUpdateAction();

			try {
				actionForward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("UpdateEmployersForm.do")){
    		
    		action = new EmployerUpdateFormAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("UpdateEmployers.do")){
    		
    		action = new EmployerUpdateAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if (command.equals("logOut.do")) {

			action = new logOutAction();

			try {
				actionForward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (actionForward != null) {
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
