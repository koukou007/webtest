package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelCreateAuto extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		out.println("\tQ1\tQ2\tQ3\tQ4\tQ5");
		out.println("Apples\t78\t87\t92\t29\t=SUM(B2:E2)");
	    out.println("Orange\t77\t86\t93\t30\t=SUM(B3:E3)");
		out.close();
	}

}
