package serf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Welcome to the Master Servlet");
		System.out.println("Welcome to the Master Servlet");

		// How to get the Servlet Config
		// ServletConfig scon = this.getServletConfig();

		// Can access a property like this:
		// String configstring = scon.getInitParameter("Pokemon");

		String configstring = this.getInitParameter("Pokemon");
		System.out.println(configstring);

		ServletContext sconxt = this.getServletContext();
		String contextstring = sconxt.getInitParameter("SportsTeam");
		System.out.println(contextstring);

		HttpSession sess = request.getSession();

		System.out.println(sess.getId());
		System.out.println(sess.getAttribute("user"));

		sess.invalidate();

		Cookie c = new Cookie("age", "75");
		response.addCookie(c);

		if (request.getRequestURI().equals("/ServletEx/subredirect.do")) {
			response.sendRedirect("/ServletEx/SubServlet");
		}
		if (request.getRequestURI().equals("/ServletEx/subforward.do")) {
			// forward requires a RequestDispatcher

			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
