package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.buyInfoDao;
import eneity.buyInfo;
/***
 *@author 15185丁硕
 * 购物车添加
 */
/**
 * Servlet implementation class addbuyCarInfo
 */
@WebServlet("/addbuyCarInfo")
public class addbuyCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json;charset:utf-8");
		PrintWriter pw=res.getWriter();
		//System.out.println(req.getParameter("userName"));
		//System.out.println(req.getParameter("productID"));
		buyInfo b=new buyInfo();
		b.setUserName(req.getParameter("userName"));
		b.setProductID(Integer.parseInt(req.getParameter("productID")));
		//System.out.println(b.toString());
		buyInfoDao x=new buyInfoDao();
		ArrayList<buyInfo> buys=x.selectAllBuyInfoByUserName(b.getUserName());
		buyInfo b2=null;
		if(!(buys.size()==0)) {
			for(buyInfo a:buys) {
				if(a.getProductID()==b.getProductID()) {
					b2=a;
				}
			}
		}
		if(b2==null) {
			x.addBuyInfo(b);
			pw.print("add");
			return;
		}else {
			x.updataNumberByUserNameAndProductID(b2.getUserName(), b2.getProductID(), b2.getNumber()+1);
			pw.print("update");
		}
		
		
	}

}
