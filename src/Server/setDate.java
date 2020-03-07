package Server;
/****
 * @author 15185丁硕
 * 存储日期
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

@WebServlet("/setDate")
public class setDate extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加允许跨域
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		// 1.设置输出的消息类型为json
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw=res.getWriter();
		String birthDay = req.getParameter("value");
		//System.out.println(birthDay);
		FileUtils.writeStringToFile(new File("E:\\Data\\birthDay.json"), birthDay);
		
	}

}
