package Server;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;

import eneity.UserInfo;
/***
 *@author 15185丁硕
 * 用户信息添加
 */


/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json;charset:utf-8");
		//System.out.println(req.getParameter("realname"));
		UserInfo u=new UserInfo();
		u.setAddress(req.getParameter("address"));
		u.setEmail(req.getParameter("email"));
		//System.out.println(u.getEmail());
		u.setNickname(req.getParameter("nickname"));
		u.setPwd(req.getParameter("pwd1"));
		u.setSex(req.getParameter("sex"));
		u.setTelnum(req.getParameter("telmun"));
		//ArrayList<UserInfo> users=new ArrayList<>();
		//users.add(u);
		//System.out.println(users.toString());
		List<UserInfo> users;
		PrintWriter pw=res.getWriter();
		String jsonStr=FileUtils.readFileToString(new File("E:\\Data\\users.json"));//从硬盘读取数据
		String birthStr=FileUtils.readFileToString(new File("E:\\Data\\birthDay.json"));
		String avatarUrl=FileUtils.readFileToString(new File("E:\\Data\\avatarUrl.json"));
		u.setAvatarUrl(avatarUrl);
		//System.out.println(birthStr);
		if(birthStr.isEmpty()) {
			birthStr="2018,2,2";	
		}
		u.setBirthDay(birthStr);
		UserInfo pdUserInfo=null;
		//System.out.println(jsonStr);
		//System.err.println(jsonStr.isEmpty());
		if(!jsonStr.isEmpty()) {//判断是否为空
		users=JSON.parseArray(jsonStr, UserInfo.class);
		for(UserInfo a:users) {
			if(a.getEmail().equals(u.getEmail())) {
				pdUserInfo=a;
			}
		}
		}
		else {
			 users=new ArrayList<>();
		}
		if(pdUserInfo==null) {
			//System.out.println("可以注册");
			users.add(u);//添加操作
			String str=JSON.toJSONString(users);
			//System.out.println(str);
			FileUtils.writeStringToFile(new File("E:\\Data\\birthDay.json"), "2018,2,2");
			FileUtils.writeStringToFile(new File("E:\\Data\\users.json"), str);
			pw.print("succsess");
		}
		else {
			//System.out.println("不可注册");
			
			pw.print("wrong");
			
		}
		
		
		
		//String pwd=req.getParameter("userPwd");
		
		//存储成员
		//String jsonStr=FileUtils.readFileToString(new File("E:\\Data\\users.json"));
		//System.out.println(jsonStr);
		//添加成员
//		List <user> users2=JSON.parseArray(jsonStr, user.class);
//		users2.add(user1);
//		String str2=JSON.toJSONString(users2);
//		FileUtils.writeStringToFile(new File("E:\\Data\\users.json"), str2);
//		PrintWriter pw=res.getWriter();
//		pw.print(JSON.toJSON(FileUtils.readFileToString(new File("E:\\Data\\users.json"),"utf-8")));
		
	}

}
