package com.bdi.erp.test;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

import com.bdi.erp.common.DBConnection;


public class DBTest {
	public static void main(String args[]) {
		Connection con = null;
		int cnt = 0;
		Scanner s = new Scanner(System.in);
		try {
			con = DBConnection.getCon();
			String sql = "select * from user_info";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Map<String,String>> result = new ArrayList<Map<String,String>>();
			while(rs.next()) {
				Map<String,String> subresult = new HashMap<String,String>();
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
				result.add(subresult);
				System.out.println(result);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				DBConnection.closeCon();
			}
		}
	}
}
