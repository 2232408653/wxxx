package Server;
/***
 * @author 15185丁硕
 * 获得所有产品
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
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;

import eneity.Product;
import utils.JsonUtils;

/**
 * Servlet implementation class getAllProducers
 */
@WebServlet("/getAllProducers")
public class getAllProducers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
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
		//Product p=new Product();
		//		p.setGoods_id("001");
		//		p.setGoods_message("你好");
		//		p.setGoods_cell("12");
		//System.out.println(str.isEmpty());
		if(!str.isEmpty()) {
			//System.out.println("不空");
			list=JsonUtils.PathTolist(path, Product.class);
			pw.print(JSON.toJSON(JsonUtils.FileTOString(path)));
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
