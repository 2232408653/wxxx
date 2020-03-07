package Server;
/***
 * @author 15185丁硕
 * 获得用户登录消息
 * 本来想以此判断，结果有时间差所以没用
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

import utils.JsonUtils;

/**
 * Servlet implementation class getLoginUserName
 */
@WebServlet("/getLoginUserName")
public class getLoginUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		// 1.设置输出的消息类型为json
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw=res.getWriter();
		String path="E:\\\\Data\\\\login.json";
		pw.print(JsonUtils.FileTOString(path));
	}

}
