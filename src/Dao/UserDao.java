package Dao;
/***
 * 
 * @author 15185丁硕
 *  用户信息存储工具包
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eneity.UserInfo;
import utils.DBUtil;

public class UserDao {
	public UserInfo selectByUserEmail(String x){
		UserInfo u=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from users where email=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, x);
			res=ps.executeQuery();
			if(res.next()) {
				u=new UserInfo();
				u.setAddress(res.getString("address"));
				//System.out.println(u.getAddress());
				u.setAvatarUrl(res.getString("avatarUrl"));
				u.setBirthDay(res.getString("birthDay"));
				u.setEmail(res.getString("email"));
				u.setNickname(res.getString("nickname"));
				u.setPwd(res.getString("pwd"));
				u.setRealname(res.getString("realname"));
				u.setSex(res.getString("sex"));
				u.setTelnum(res.getString("telnum"));
				System.out.println(u.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}
	
	public ArrayList<UserInfo> selectAllUser(){
		ArrayList<UserInfo> users=new ArrayList<>();
		UserInfo u=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from users";
			ps=conn.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()) {
				u=new UserInfo();
				u.setAddress(res.getString("address"));
				//System.out.println(u.getAddress());
				u.setAvatarUrl(res.getString("avatarUrl"));
				u.setBirthDay(res.getString("birthDay"));
				u.setEmail(res.getString("email"));
				u.setNickname(res.getString("nickname"));
				u.setPwd(res.getString("pwd"));
				u.setRealname(res.getString("realname"));
				u.setSex(res.getString("sex"));
				u.setTelnum(res.getString("telnum"));
				System.out.println(u.toString());
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}
	public boolean addUser(UserInfo u){
		boolean b=false;
		int rows=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT into users VALUES(?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getAddress());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getNickname());
			ps.setString(4, u.getPwd());
			ps.setString(5, u.getRealname());
			ps.setString(6, u.getSex());
			ps.setString(7, u.getTelnum());
			ps.setString(8, u.getBirthDay());
			ps.setString(9, u.getAvatarUrl());
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(rows);
		if(rows>0)
			b=true;		
		return b;
	}
	public int deletByUserEmail(String x){
		UserInfo u=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		int rows=0;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from users where email=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, x);
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rows;
	}
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Connection conn=null;
			PreparedStatement ps=null;
			String x="1@qq.com";
			ResultSet res=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from users where email=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, x);
				res=ps.executeQuery();
				if(res.next()) {
					System.out.println("x");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			UserDao u=new UserDao();
			u.selectByUserEmail(x);
			u.selectAllUser();
			u.addUser(u.selectByUserEmail(x));
			System.out.println(u.deletByUserEmail("23.00"));
		}
		
	}

