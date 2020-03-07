package Dao;
/**
 * 丁硕
 * 购物车数据库数据工具
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import eneity.buyInfo;
import utils.DBUtil;

public class buyInfoDao {
	
	public ArrayList<buyInfo> selectAllBuyInfoByUserName(String x){
		ArrayList<buyInfo> buyProucts=new ArrayList<>();
		buyInfo u=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from buyinfo where userName=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, x);
			res=ps.executeQuery();
			while(res.next()) {
				u=new buyInfo();
				u.setUserName(res.getString("userName"));
				u.setProductID(res.getInt("productID"));
				u.setNumber(res.getInt("number"));
				//System.out.println(u.toString());
				buyProucts.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return buyProucts;
	}
	public boolean addBuyInfo(buyInfo b) {
		boolean result=false;
		int rows=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT into buyinfo VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,b.getUserName());
			ps.setInt(2, b.getProductID());
			ps.setInt(3, b.getNumber()+1);
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println(rows);
		if(rows>0)
			result=true;		
		return result;
	}
	public int deleteByUserNameAndProductID(String userName,int proudctID) {
		int rows=0;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from buyinfo where userName=? and productID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,userName);
			ps.setInt(2, proudctID);
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(rows);
		return rows;
	}
	public int updataNumberByUserNameAndProductID(String userName,int proudctID,int number) {
		int rows=0;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE buyinfo set number=? WHERE userName=? and productID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, number);
			ps.setString(2,userName);
			ps.setInt(3, proudctID);
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(rows);
		return rows;
	}
	
		/*public static void main(String[] args) {
			// TODO Auto-generated method stub
			buyInfoDao a=new buyInfoDao();
			ArrayList<buyInfo> list=a.selectAllBuyInfoByUserName("1");
			buyInfo b=list.get(0);
			//a.addBuyInfo(b);
			//a.deleteByUserNameAndProductID(b.getUserName(), b.getProductID());
			a.updataNumberByUserNameAndProductID(b.getUserName(), b.getProductID(), (b.getNumber()+1));
			buyInfo b2=new buyInfo();
			a.addBuyInfo(b2);
		
		}*/
		
}

