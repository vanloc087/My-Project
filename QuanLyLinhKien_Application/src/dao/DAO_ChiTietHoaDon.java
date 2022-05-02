package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.LinhKien;

public class DAO_ChiTietHoaDon {
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon() {
		ArrayList<ChiTietHoaDon> list= new ArrayList<ChiTietHoaDon>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from ChiTietHoaDon";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHoaDon= rs.getString(1);
				String maLinhKien= rs.getString(2);
				int soLuong= rs.getInt(3);
				Double giaBan= rs.getDouble(4);
				list.add(new ChiTietHoaDon(new HoaDon(maHoaDon), new LinhKien(maLinhKien), giaBan, soLuong));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
		
	}

}
