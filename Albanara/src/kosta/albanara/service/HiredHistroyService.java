package kosta.albanara.service;

import javax.servlet.http.HttpServletRequest;

import kosta.albanara.dao.HiredHistoryDao;
import kosta.albanara.model.HiredHistroy;

public class HiredHistroyService {
	private static HiredHistroyService service;
	private static HiredHistoryDao dao;
	
	public static HiredHistroyService getInstance() {
		dao = HiredHistoryDao.getInstance();
		return service;
	}
	
	public int insertHiredHistroyService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HiredHistroy hiredHistory = new HiredHistroy();
		hiredHistory.setHiredHistorySeq(Integer.parseInt(request.getParameter("hiredHistorySeq")));
		hiredHistory.setEmployeeSeq(Integer.parseInt(request.getParameter("employeeSeq")));
		hiredHistory.setRecruitmentSeq(Integer.parseInt(request.getParameter("recruitmentSeq")));
		hiredHistory.setIsCompleted(Integer.parseInt(request.getParameter("isCompleted")));
		return dao.insertHiredHistroy(hiredHistory);
	}
}
