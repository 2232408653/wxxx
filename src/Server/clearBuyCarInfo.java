package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import eneity.Product;
import utils.JsonUtils;
/***
 * @author 15185丁硕
 * 结算服务
 * 就是将销量加1
 */
/**
 * Servlet implementation class clearBuyCarInfo
 */
@WebServlet("/clearBuyCarInfo")
public class clearBuyCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset:utf-8");
		PrintWriter pw=res.getWriter();
		String path="E:\\\\Data\\\\list.json";
		String str=JsonUtils.FileTOString(path);
		//System.out.println(str);
		//System.out.println("123");
		List<Product> list=new ArrayList<>();
		int id=Integer.parseInt(req.getParameter("id"));
		int num=Integer.parseInt(req.getParameter("num"));
		//Product p=new Product();
		//		p.setGoods_id("001");
		//		p.setGoods_message("你好");
		//		p.setGoods_cell("12");
		//System.out.println(str.isEmpty());
		if(!str.isEmpty()) {
			//System.out.println("不空");
			list=JsonUtils.PathTolist(path, Product.class);
			Iterator<Product> it = list.iterator();
			Product p=null;
			while(it.hasNext()) {
				p = it.next();
				if(p.getGoods_id()==id) {
					p.setGoods_cell(p.getGoods_cell()+num);
					it.remove();
					break;
				}
			}
			list.add(p);
			JsonUtils.ListToFile(path, list);
			//pw.print(JSON.toJSON(JsonUtils.FileTOString(path)));
			//list.add(p);
		}
		else {
			pw.print("null");
		}
		//else
		//list.add(p);
		//System.out.println(JsonUtils.ListToJsonStr(list));
		//JsonUtils.ListToFile(path, list);
		//FileUtils.writeStringToFile(new File(path), JsonUtils.ListToJsonStr(list),"utf-8");
		//String str2=JsonUtils.FileTOString(path);
		//System.out.println(list.toString());
		
		}

}
