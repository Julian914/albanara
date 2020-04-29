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
import kosta.albanara.action.HiredHistoryAction;



@WebServlet("/HiredHistoryController/*")
public class HiredHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HiredHistoryController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+ 24);
		ActionForward forward = null;
		Action action = null;
		if (command.equals("insertHiredHistory.do")) {
			action = new HiredHistoryAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (forward != null){
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
