package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import connectDB.Database;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAO_NhanVien {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> list= new ArrayList<NhanVien>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from NhanVien";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNV= rs.getString(1);
				String tenNV= rs.getString(2);
				String sdt= rs.getString(3);
				String diaChi= rs.getString(4);
				
				list.add(new NhanVien(maNV, tenNV,sdt, diaChi )  );
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	public NhanVien getElement(int index) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			Connection con = Database.getInstance().getConnection();
			
			String sql = "Select * from NhanVien";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String manv = rs.getString(1);
				String tennv = rs.getString(2);
				String sdt=rs.getString(3);
				String diachi=rs.getString(4);
				dsnv.add(new NhanVien(manv, tennv, sdt, diachi));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		if(index<0 || index>dsnv.size())
			return null;
		return dsnv.get(index);
	}
	public boolean create(NhanVien nv) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into NhanVien values(?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nv.getMaNV());
			pstm.setString(2, nv.getTenNV());
			pstm.setString(3, nv.getSDT());
			pstm.setString(4, nv.getDiaChi());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}

	}

	public boolean xoa(String maNV) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "delete from NhanVien where maNhanVien = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,maNV);
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
public boolean update(NhanVien nv) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update NhanVien set tenNhanVien = ?, SDT = ?, diaChi = ?  where maNhanVien = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, nv.getTenNV());
			pstm.setString(2, nv.getSDT());
			pstm.setString(3, nv.getDiaChi());
			pstm.setString(4, nv.getMaNV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
		
	
	

}