package com.bdi.erp.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bdi.erp.common.DBConnection;
import com.bdi.erp.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean login(String id, String pwd) {
		Connection con = DBConnection.getCon();
		String sql = "select count(*) from user_info";
		sql += " where uiId=? and uiPwd=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int cnt = rs.getInt(1); //1부터 샘
			if(cnt==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				DBConnection.closeCon();
			}
		}
		return false;
	}
	public List<Map<String,String>> getUserList(Map<String,String[]> name){
			Connection con = null;
			List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
			try {
				con = DBConnection.getCon();
				String sql = "select * from user_info where 1=1";
				Iterator iterator = name.keySet().iterator();
				String key = (String)iterator.next();
				if(name.get(key)!=null && !name.get(key).equals("")) {
					sql += " and " + key + " like ?";
				}
				PreparedStatement ps = con.prepareStatement(sql);
				if(name.get(key)!=null && !name.get(key).equals("")) {
					ps.setString(1, "%"+name.get(key)+"%");
				}
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData rsmt = rs.getMetaData();
				Map<String,String> user;
				while(rs.next()) {
			/*		Map<String,String> subresult = new HashMap<String,String>();
					subresult.put("uiNum", rs.getString("uiNum"));
					subresult.put("uiName", rs.getString("uiName"));
					subresult.put("uiId",rs.getString("uiId"));
					subresult.put("uiPwd",rs.getString("uiPwd"));
					subresult.put("uiEmail",rs.getString("uiEmail"));
					subresult.put("uiEtc",rs.getString("uiEtc"));
					subresult.put("credat",rs.getString("credat"));
					subresult.put("cretim",rs.getString("cretim"));
					subresult.put("creusr",rs.getString("creusr"));
					subresult.put("moddat",rs.getString("moddat"));
					subresult.put("modtim",rs.getString("modtim"));
					subresult.put("modusr",rs.getString("modusr"));
					subresult.put("diNum",rs.getString("diNum"));
					userList.add(subresult);
					System.out.println(userList); */
					user = new HashMap<String,String>();
					for(int a=1;a<=rsmt.getColumnCount();a++) {
						String colNm = rsmt.getColumnLabel(a);
						user.put(colNm, rs.getString(colNm));
					}
					userList.add(user);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					DBConnection.closeCon();
				}
			}
			return userList;
	}
}
