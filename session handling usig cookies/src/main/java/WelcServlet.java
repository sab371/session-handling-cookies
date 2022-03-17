import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/welcome")

public class WelcServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] c = req.getCookies();
		for(Cookie cook:c) {
			if(cook.getName().equals("username")) {
				String name = cook.getValue();
				PrintWriter out = res.getWriter();
				out.println("<b>Welcome!!!</b> "+name);
			}
		}
	}
}
