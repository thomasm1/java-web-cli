package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter {

	@Override
	public void destroy() {

	}
 
	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException { 
		
		String username = servletRequest.getParameter("username"); 
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;  
		String sess = request.getRequestedSessionId();  
		 
		//request.getSession().getAttribute("validUser") == "validated"
		//&& 	(request.getSession().getAttribute("sessId") == sess
		if (sess == request.getRequestedSessionId()) {
			System.out.println("username filtered: "+username);
			System.out.println("sessId filtered: "+sess); 
			chain.doFilter(servletRequest, servletResponse);
		} else {
			request.getRequestDispatcher("/login.do").forward(servletRequest,
					servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
