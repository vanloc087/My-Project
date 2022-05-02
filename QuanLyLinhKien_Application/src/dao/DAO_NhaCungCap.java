package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.NhaCungCap;

public class DAO_NhaCungCap {

	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> list= new ArrayList<NhaCungCap>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from NhaCungCap";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNCC= rs.getString(1);
				String tenNCC= rs.getString(2);
				String diaChi= rs.getString(3);
				String sDT= rs.getString(4);
				
				list.add(new NhaCungCap(maNCC, tenNCC, diaChi, sDT));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
		
	}

}