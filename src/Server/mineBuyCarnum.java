package Server;
/***
 * @author 15185丁硕
 * 减少购物车数据
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.buyInfoDao;
import eneity.Product;
import eneity.buyCarInfo;
import eneity.buyInfo;
import utils.JsonUtils;

/**
 * Servlet implementation class mineBuyCarnum
 */
@WebServlet("/mineBuyCarnum")
public class mineBuyCarnum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset:utf-8");
		PrintWriter pw=res.getWriter();
		String userName=req.getParameter("userName");
		//int num=Integer.parseInt(req.getParameter("num"));
		int id=Integer.parseInt(req.getParameter("id"));
		//System.out.println(id);
		//System.out.println(num);
		//System.out.println(userName);
		buyInfoDao b=new buyInfoDao();
		int num=0;
		ArrayList<buyInfo> c=b.selectAllBuyInfoByUserName(userName);
		for(buyInfo m:c) {
			if(m.getProductID()==id) {
				num=m.getNumber()-1;
			}
		}
		if(num==0) {
			pw.print("delete");
			return;
		}
		b.updataNumberByUserNameAndProductID(userName, id, num);
		ArrayList<buyInfo> buyInfos=b.selectAllBuyInfoByUserName(userName);
		if(buyInfos.size()==0) {
			pw.print("noBuyCar");
			return;
		}
		//System.out.println(buyInfos.size());
		String path="E:\\\\Data\\\\list.json";
		List<Product> proudcts=JsonUtils.PathTolist(path, Product.class);
		List<buyCarInfo> buyCarInfo=new ArrayList<>();
		for(Product p:proudcts) {
			for(buyInfo b2:buyInfos) {
				if(p.getGoods_id()==b2.getProductID()) {
					buyCarInfo b3=new buyCarInfo();
					b3.setGoods_id(p.getGoods_id());
					b3.setGoods_introduce(p.getGoods_message());
					b3.setGoods_number(b2.getNumber());
					b3.setGoods_price(p.getGoods_prise());
					b3.setGoods_style("商品品牌为未来科技");
					b3.setImage_url(p.getImage_url());
					b3.setIs_check(false);
					//System.out.println(b3.toString());
					buyCarInfo.add(b3);
				}
			}
		}
		if(buyCarInfo.size()==0) {
			pw.print("noBuyCar");
			return;
		}
		pw.print(JsonUtils.ListToJsonStr(buyCarInfo));
	}

}
