package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.TaiKhoan;

public class DAO_TaiKhoan {
	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> list= new ArrayList<TaiKhoan>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from TaiKhoan";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTaiKhoan= rs.getString(1);
				String maNguoiDung= rs.getString(2);
				String matKhau= rs.getString(3);
				
				list.add(new TaiKhoan(maTaiKhoan, maNguoiDung, matKhau));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
		
	}

}
