package kosta.albanara.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/session/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here

		// get HTTPServletRequest from ServletRequest
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// get HttpServletResponse from ServletResponse
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// get session from HTTPServletRequest
		HttpSession httpSession = httpRequest.getSession();
		// to do what you want
		if (httpSession.getAttribute("id") == null) {
			
			httpResponse.sendRedirect("/Albanara/employeeLogInForm.jsp");
			
		}else {
		// pass the request along the filter chain
			chain.doFilter(request, response);
		}

		// �뿬湲곗꽌遺��꽣 �럹�씠吏� �궗�썑 �옉�뾽. �럹�씠吏� 濡쒕뵫�씠 �셿猷뚮릺怨� �궃 �썑 �떎�뻾�맖.
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
