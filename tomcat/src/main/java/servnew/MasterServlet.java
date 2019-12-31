package servnew;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MasterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("\n\n\n    Welcome to MasterServ. You are accessing .do File");// .append("Served
																									// at:
																									// ").append(request.getContextPath());

		// HOW to get the Servlet Config
		ServletConfig scon = this.getServletConfig();

		// Can access a property like this:
		String configstring = scon.getInitParameter("Pokemon");
		System.out.println(configstring);

		ServletContext scontext = this.getServletContext();
		String scontextstring = scontext.getInitParameter("Sports");
		System.out.println(scontextstring);

		HttpSession sess = request.getSession();
		sess.setAttribute("user", "{'username', 'tom'},{'ordernum','222'}");
//		sess.setAttribute("username", "tom from subServlet");
		System.out.println("Session ID: " + sess.getId());
		sess.setMaxInactiveInterval(3600);
		System.out.println("User- MasterServlet: " + sess.getAttribute("user"));

		sess.invalidate();

		Cookie c = new Cookie("age", "75");
//		HttpServletResponse reponse;
		response.addCookie(c);

		if (request.getRequestURI().equals("/tomcat/subforward.do")) {
			// forward requires a RequestDispatcher

			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);
			String cc= "this is cookie: "+ c;
			System.out.println(cc);
			  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
