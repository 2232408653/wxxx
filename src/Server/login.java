package Server;
/***
 * @author 15185丁硕
 * 登录判断
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.apache.catalina.User;
import org.apache.commons.io.FileUtils;

import eneity.UserInfo;
import utils.JsonUtils;
/***
 * 丁硕
 *判断 登录信息
 */
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset:utf-8");
		PrintWriter pw=res.getWriter();
		String path="E:\\Data\\users.json";
		String jsonStr=FileUtils.readFileToString(new File("E:\\Data\\users.json"));
		if(jsonStr.isEmpty()) {
			pw.print("noUser");
			return ;
		}
		List<UserInfo> list=JsonUtils.PathTolist(path, UserInfo.class);
		if(list.size()==0) {
			pw.print("noUser");
			return ;
		}
		UserInfo u=null;
		String userName=req.getParameter("userName");
		//System.out.println(req.getParameter("userName"));
		String pwd=req.getParameter("userPwd");
		for(UserInfo a:list) {
			if(a.getEmail().equals(userName)) {
				u=a;
				//System.out.println(u.getPwd());
				break;
			}
		}
		if(u==null) {
			pw.print("noUser");
			return;
		}else if(!u.getPwd().equals(pwd)){
			pw.print("wrongPwd");
			return;
		}else {
			pw.print("success");
		}
		
	}

}
