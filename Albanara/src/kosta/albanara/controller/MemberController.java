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
import kosta.albanara.action.BasicInformationAction;
import kosta.albanara.action.EmployeeDeleteAction;
import kosta.albanara.action.EmployeeFormAction;
import kosta.albanara.action.EmployeeLogInAction;
import kosta.albanara.action.EmployeeLogInFormAction;
import kosta.albanara.action.EmployeeSignUpAction;
import kosta.albanara.action.EmployeeUpdateAction;
import kosta.albanara.action.EmployeeUpdateFormAction;
import kosta.albanara.action.EmployerDeleteAction;
import kosta.albanara.action.EmployerDetailAction;
import kosta.albanara.action.InsertResumeAction;
import kosta.albanara.action.InsertResumeForm;
import kosta.albanara.action.RecommendEmployeeFormAction;
import kosta.albanara.action.EmployerLogInFormAction;
import kosta.albanara.action.SearchResumeAction;
import kosta.albanara.action.ShowEmployeeAction;
import kosta.albanara.action.UpdateResumeAction;
import kosta.albanara.action.UpdateResumeFormAction;
import kosta.albanara.action.ShowEmployerPageAction;
import kosta.albanara.action.logOutAction;
import kosta.albanara.action.recommendEmployeeFormAction;
import kosta.albanara.action.EmployerFormAction;
import kosta.albanara.action.EmployerLogInAction;
import kosta.albanara.action.EmployerSignUpAction;
import kosta.albanara.action.EmployerUpdateAction;
import kosta.albanara.action.EmployerUpdateFormAction;
import kosta.albanara.action.MapAction;
 
@WebServlet("/member/*")
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
		
		Action action = null;
		ActionForward actionForward = null;

		switch (command) {
		case "testAction.do":
			try {
				// actionForward = new TestAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "showEmployee.do":
			try {
				actionForward = new ShowEmployeeAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;			
		}
		if(command.equals("employeeSignUpForm.do")) {
    		action = new EmployeeFormAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertEmployees.do")){
    		action = new EmployeeSignUpAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertResumeForm.do")){
    		action = new InsertResumeForm();
    		try {
				actionForward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertResume.do")) {
    		action = new InsertResumeAction();
    		try {
				actionForward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("searchResume.do")) {
    		action = new SearchResumeAction();
    		try {
				actionForward = action.execute(request, response);
				System.out.println("123");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employerSignUpForm.do")) {
    		action = new EmployerFormAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertEmployers.do")){
    		action = new EmployerSignUpAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employeeLogInForm.do")){
    		action = new EmployeeLogInFormAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employerLogInForm.do")){
    		action = new EmployerLogInFormAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employerLogIn.do")){
    		
    		action = new EmployerLogInAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteEmployers.do")){
    		
    		
    		action = new EmployerDeleteAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateResume.do")) {
    		action = new UpdateResumeFormAction();
    		try {
				actionForward = action.execute(request, response);
				System.out.println("5678");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateResumeAction.do")) {
    		action = new UpdateResumeAction();
    		try {
				actionForward = action.execute(request, response);
				System.out.println("1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("basicInformation.do")) {
    		action = new BasicInformationAction();
    		try {
				actionForward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("detailEmployers.do")) {
    		action = new EmployerDetailAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteEmployees.do")){
    		
    		
    		action = new EmployeeDeleteAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employeeLogIn.do")){
    		
    		action = new EmployeeLogInAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("logOut.do")){
    		
    		action = new logOutAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("detailEmployers.do")) {
    		action = new EmployerDetailAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteEmployees.do")){
    		
    		
    		action = new EmployeeDeleteAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employeeLogIn.do")){
    		
    		action = new EmployeeLogInAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("logOut.do")){
    		
    		action = new logOutAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("detailEmployers.do")) {
    		action = new EmployerDetailAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteEmployees.do")){
    		
    		
    		action = new EmployeeDeleteAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employeeLogIn.do")){
    		
    		action = new EmployeeLogInAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("logOut.do")){
    		
    		action = new logOutAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("detailEmployers.do")) {
    		action = new EmployerDetailAction();
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteEmployees.do")){
    		
    		
    		action = new EmployeeDeleteAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("employeeLogIn.do")){
    		
    		action = new EmployeeLogInAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("logOut.do")){
    		
    		action = new logOutAction();
    		
    		try {
				actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("showEmployersPage.do")){
    		
    		action = new ShowEmployerPageAction(); 
    		
    		try {
    			actionForward = action.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		
    	}else if(command.equals("recommendEmployeeActionForm.do")) {
    		action = new RecommendEmployeeFormAction();
    		try {
				actionForward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}

		if (actionForward != null){
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
