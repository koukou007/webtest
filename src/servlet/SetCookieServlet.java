package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

           doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      /*  Cookie cookie = new Cookie("name","koucaipeng");
        cookie.setMaxAge(60*1000);
		response.addCookie(cookie);
		response.sendRedirect("/GetCookieServlet");*/
		
		//…Ë÷√Session
	    HttpSession session =request.getSession();
	    session.setAttribute("session_key", "session_value");
	}

}
