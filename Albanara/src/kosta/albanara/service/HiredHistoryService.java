package kosta.albanara.service;

import javax.servlet.http.HttpServletRequest;
import kosta.albanara.dao.HiredHistoryDao;
import kosta.albanara.model.HiredHistory;

public class HiredHistoryService {
	private static HiredHistoryService service = new HiredHistoryService();
	private static HiredHistoryDao dao;
	
	public static HiredHistoryService getInstance() {
		dao = HiredHistoryDao.getInstance();
		return service;
	}
	
	public int insertHiredHistroyService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HiredHistory hiredHistory = new HiredHistory();
		
		hiredHistory.setEmployeeSeq(Integer.parseInt(request.getParameter("seq2")));
		hiredHistory.setRecruitmentSeq(Integer.parseInt(request.getParameter("seq")));
	
		//System.out.println(hiredHistory.getEmployeeSeq());
		//System.out.println(hiredHistory.getRecruitmentSeq());
		
		return dao.insertHiredHistroy(hiredHistory);
	}
}
