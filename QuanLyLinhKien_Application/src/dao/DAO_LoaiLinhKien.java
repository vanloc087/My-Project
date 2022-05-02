package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.LoaiLinhKien;

public class DAO_LoaiLinhKien {
	public ArrayList<LoaiLinhKien> getAllLoaiLinhKien() {
		ArrayList<LoaiLinhKien> list= new ArrayList<LoaiLinhKien>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from LoaiLinhKien";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maLoaiLK= rs.getString(1);
				String tenLoaiLK= rs.getString(2);
				
				
				list.add(new LoaiLinhKien(maLoaiLK,tenLoaiLK));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
		
	}

}
