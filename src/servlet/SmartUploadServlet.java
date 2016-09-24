package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmartUploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filePath = getServletContext().getRealPath("/")+"smartUpload";
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(),request, response);
		System.out.println((getServletConfig()));
		su.setMaxFileSize(1024*1024*4);
		try {
			su.upload();
			su.save(filePath);
			request.setAttribute("message", "上传成功");
		} catch (SmartUploadException e) {
			request.setAttribute("message", "上传失败");
			e.printStackTrace();
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
