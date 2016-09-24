package mysql;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String name;
            String password;
            name = request.getParameter("name");
	        password = request.getParameter("password");
	        HttpSession session = request.getSession(); 
	        UserDaoImpl udi = new UserDaoImpl();
	       
	        User user = new User();
	        user = udi.queryUser(name, password);
	        if(user!=null){
	        	session.setAttribute("user", user);
	        	request.getRequestDispatcher("MyJsp.jsp").forward(request, response);
	        }
	        else
	            request.getRequestDispatcher("User_register.jsp").forward(request, response);
	}

}
