package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * 商品信息添加
 */
/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		Product p=new Product();
		p.setImage_url(req.getParameter("image_url"));
		p.setGoods_message(req.getParameter("goods_message"));
		p.setGoods_prise(Double.parseDouble(req.getParameter("goods_prise")));
		//System.out.println(req.getParameter("image_url"));
		if(!str.isEmpty()) {
			//System.out.println("不空");
			list=JsonUtils.PathTolist(path, Product.class);
			int num=list.size();
			num++;
			p.setGoods_id(num);
			list.add(p);
		}
		else {
			int num=1;
			p.setGoods_id(num);
			list =new ArrayList<Product>();
			list.add(p);
		}
		JsonUtils.ListToFile(path, list);
		pw.print("succsess");
		//else
		//list.add(p);
		//System.out.println(JsonUtils.ListToJsonStr(list));
		//JsonUtils.ListToFile(path, list);
		//FileUtils.writeStringToFile(new File(path), JsonUtils.ListToJsonStr(list),"utf-8");
		//String str2=JsonUtils.FileTOString(path);
		//System.out.println(list.toString());
	}

}
