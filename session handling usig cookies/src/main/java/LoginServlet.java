import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/home")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException {
		String usrname = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		if(usrname.equals("user") && password.equals("abcd")) {
			Cookie c = new Cookie("username",usrname);
			res.addCookie(c);
			res.sendRedirect("welcome");
		}
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			out.write("<b>Invalid login!!! Please try again</b>");
			rd.include(req,res);
			//out.close();
		}
	}
}
