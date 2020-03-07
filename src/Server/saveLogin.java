package Server;
/***
 * @author 15185丁硕
 * 存储
 * 已弃用
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class saveLogin
 */
@WebServlet("/saveLogin")
public class saveLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加允许跨域
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		// 1.设置输出的消息类型为json
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw=res.getWriter();
		String str = req.getParameter("loginName");
		//System.out.println(birthDay);
		FileUtils.writeStringToFile(new File("E:\\Data\\login.json"), str);
	}
}
