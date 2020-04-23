package kosta.albanara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.HyunMap;
import kosta.albanara.service.HyunMapService;

public class HyunMapAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HyunMapService service = HyunMapService.getInstance();
		
		List<HyunMap> list = service.mapList();
		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setPath("/NewFile.jsp");
		return forward;
	}

}
