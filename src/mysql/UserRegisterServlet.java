package mysql;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterServlet extends HttpServlet {


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
	        UserDaoImpl udi = new UserDaoImpl();
	        udi.addUser(name, password);
	        request.getRequestDispatcher("UserLoginServlet").forward(request, response);
	}

}
