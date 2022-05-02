package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.Database;
import entity.LinhKien;
import entity.LoaiLinhKien;
import entity.NhaCungCap;
import entity.NhanVien;


public class DAO_LinhKien {
	public static ArrayList<LinhKien> getAllLinhKien() {
		ArrayList<LinhKien> list = new ArrayList<LinhKien>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from LinhKien";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maLinhKien= rs.getString(1);
				String tenLinhKien= rs.getString(2);
				String maLoaiLK = rs.getString(3);
				int soLuong = rs.getInt(4);
				Double donGia = rs.getDouble(5);
				String maNCC= rs.getString(6);
				
				list.add(new LinhKien(maLinhKien,tenLinhKien,new LoaiLinhKien(maLoaiLK),soLuong,donGia,new NhaCungCap(maNCC)));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	//Lấy linh kien theo mã
	public ArrayList<LinhKien> getLinhKienTheoMa(String maLK){
		ArrayList<LinhKien> list= new ArrayList<LinhKien>();
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from LinhKien where maLinhKien = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maLK);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maLinhKien = rs.getString(1);
				System.out.println(maLinhKien);
				String tenLinhKien= rs.getString(2);
				String maLoaiLK = rs.getString(3);
				int soLuong= rs.getInt(4);
				Double donGia= rs.getDouble(5);
				String maNCC = rs.getString(6);
				LinhKien s = new LinhKien(maLinhKien,tenLinhKien,new LoaiLinhKien(maLoaiLK),soLuong,donGia,new NhaCungCap(maNCC));
				list.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//thêm linh kiện mới
	public static boolean create(LinhKien lk) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into LinhKien values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, lk.getMaLinhKien());
			pstm.setString(2, lk.getTenLinhKien());
			pstm.setString(3, lk.getMaLoaiLK().getMaLoaiLK());
			pstm.setInt(4, lk.getSoLuong());
			pstm.setDouble(5, lk.getDonGia());
			pstm.setString(6, lk.getMaNCC().getMaNCC());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	//Xóa linh kiện
	public static boolean delete(String maLK) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "delete from LinhKien where maLinhKien = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,maLK);
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean update(LinhKien lk) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update LinhKien set tenLinhKien = ?, maLoaiLK = ?, soLuong = ? donGia = ? maNCC = ? where maLinhKien = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, lk.getMaLinhKien());
			pstm.setString(2, lk.getTenLinhKien());
			pstm.setString(3, lk.getMaLoaiLK().getMaLoaiLK());
			pstm.setInt(4, lk.getSoLuong());
			pstm.setDouble(5, lk.getDonGia());
			pstm.setString(6, lk.getMaNCC().getMaNCC());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}