package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          /*  Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies){
            	System.out.println(cookie.getName()+"£∫"+cookie.getValue());
            }
            */
            //ªÒ»°session
            HttpSession session = request.getSession();
            System.out.println("session_key"+(String)session.getAttribute("session_key"));
	}

}
