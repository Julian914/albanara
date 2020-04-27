package kosta.albanara.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.action.ActionForward;
import kosta.albanara.action.InsertApplicationAction;
import kosta.albanara.action.RecruitmentListAction;
import kosta.albanara.action.UpdateRecruitmentAction;
import kosta.albanara.action.UpdateRecruitmentForm;
import kosta.albanara.action.InsertRecruitmentAction;
import kosta.albanara.action.InsertRecruitmentForm;


@WebServlet("/recruitment/*")
public class RecruitmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = null;
		String contextPath = null;
		String command = null;

		requestURI = request.getRequestURI();
		contextPath = request.getContextPath();
		command = requestURI.substring(contextPath.length() + 13);
		
		System.out.println(command);

		ActionForward actionForward = null;

		switch (command) {
		case "insertRecruitmentForm.do":
			try {
				actionForward = new InsertRecruitmentForm().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "insertRecruitmentAction.do":
			try {
				  actionForward = new InsertRecruitmentAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "updateRecruitmentForm.do":
			try {
				actionForward = new UpdateRecruitmentForm().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "updateRecruitmentAction.do":
			try {
				  actionForward = new UpdateRecruitmentAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "recruitmentList.do":  //진행중인 공고목록 불러오기
			try {
				actionForward = new RecruitmentListAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "insertApplication.do": 
			try {
				actionForward = new InsertApplicationAction().execute(request, response);
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
