package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.NhanVienHanhChinh;

public class DAO_NhanVienHanhChinh implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinh(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				Date ngayBatDau = rs.getDate(7);
				double heSoluong = rs.getDouble(8);
				String donViCongTac = rs.getString(9);
				String chucVu = rs.getString(10);
				
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinhTheoTen(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from NhanVien order by hoTen";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				Date ngayBatDau = rs.getDate(7);
				double heSoluong = rs.getDouble(8);
				String donViCongTac = rs.getString(9);
				String chucVu = rs.getString(10);
				
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinhTheoCV(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from NhanVien order by chucVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				Date ngayBatDau = rs.getDate(7);
				double heSoluong = rs.getDouble(8);
				String donViCongTac = rs.getString(9);
				String chucVu = rs.getString(10);
				
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public ArrayList<NhanVienHanhChinh> getAllNhanVienHanhChinhTheoDV(){
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from NhanVien order by donViCongTac";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				Date ngayBatDau = rs.getDate(7);
				double heSoluong = rs.getDouble(8);
				String donViCongTac = rs.getString(9);
				String chucVu = rs.getString(10);
				
				NhanVienHanhChinh nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
				dsnvhc.add(nvhc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnvhc;
		
	}
	public boolean create(NhanVienHanhChinh nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getHoTen());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setString(4, nv.getSdt());
			stmt.setDate(5, (Date) nv.getNgaySinh());
			stmt.setString(6, nv.getDiaChi());
			stmt.setDate(7, (Date) nv.getNgayBatDau());
			stmt.setDouble(8, nv.getHeSoluong());
			stmt.setString(9, nv.getDonViCongTac());
			stmt.setString(10, nv.getChucVu());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean Updata(NhanVienHanhChinh nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update NhanVien Set hoTen = ?, gioiTinh = ?, SDT=?, ngaySinh=?, diaChi=?, ngayBatDau=?, heSoluong=?, donViCongTac=?, chucVu=?  where maNhanVien=?");
			stmt.setString(1, nv.getHoTen());
			stmt.setString(2, nv.getGioiTinh());
			stmt.setString(3, nv.getSdt());
			stmt.setDate(4, (Date) nv.getNgaySinh());
			stmt.setString(5, nv.getDiaChi());
			stmt.setDate(6, (Date) nv.getNgaySinh());
			stmt.setDouble(7, nv.getHeSoluong());
			stmt.setString(8, nv.getDonViCongTac());
			stmt.setString(9, nv.getChucVu());
			stmt.setString(10, nv.getMaNhanVien());
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			JOptionPane.showConfirmDialog(null,"Vui lòng chọn lại ngày sinh!");
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
		
	}

	public NhanVienHanhChinh getnhanvienma(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		NhanVienHanhChinh nvhc = null;
		try {
			
			String sql = "Select *  from NhanVien where maNhanVien = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);

				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				Date ngayBatDau = rs.getDate(7);
				double heSoluong = rs.getDouble(8);
				String donViCongTac = rs.getString(9);
				String chucVu = rs.getString(10);
				nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nvhc;
	}
	
public ArrayList<NhanVienHanhChinh> getnhanvienten(String ten){
		
		ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		NhanVienHanhChinh nvhc = null;
		try {
			
			String sql = "Select *  from NhanVien where hoTen LIKE N'%"+ten+"%'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				Date ngayBatDau = rs.getDate(7);
				double heSoluong = rs.getDouble(8);
				String donViCongTac = rs.getString(9);
				String chucVu = rs.getString(10);
				nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
				dsnvhc.add(nvhc);
			}
		} catch (Exception e) {
			
		}
		return dsnvhc;
		
	}
public NhanVienHanhChinh getnhanviensdt(String sdt){
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	NhanVienHanhChinh nvhc = null;
	try {
		
		String sql = "Select *  from NhanVien where SDT = '"+sdt+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			Date ngayBatDau = rs.getDate(7);
			double heSoluong = rs.getDouble(8);
			String donViCongTac = rs.getString(9);
			String chucVu = rs.getString(10);
			nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
			
		}
	} catch (Exception e) {
		
	}
	return nvhc;
	
}
public ArrayList<NhanVienHanhChinh> locnhanvien(String Gioitinh1,String donvicongtac1,String chucVu1){
	ArrayList<NhanVienHanhChinh> dsnvhc = new ArrayList<NhanVienHanhChinh>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	NhanVienHanhChinh nvhc = null;
	try {
		
		String sql = "select * from NhanVien where  gioiTinh LIKE N'%"+Gioitinh1+"%' AND donViCongTac LIKE N'%"+donvicongtac1+"%'  AND chucVu LIKE N'%"+chucVu1+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			Date ngayBatDau = rs.getDate(7);
			double heSoluong = rs.getDouble(8);
			String donViCongTac = rs.getString(9);
			String chucVu = rs.getString(10);
			nvhc = new NhanVienHanhChinh(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi, ngayBatDau, heSoluong,donViCongTac,chucVu);
			dsnvhc.add(nvhc);
			
		}
	} catch (Exception e) {
		
	}
	return dsnvhc;
	
}
			
					
	public boolean delete(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNhanVien = ?  ");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Chú ý: Không Thể Xóa Vì Nhân Viên Đang Còn Hợp Đồng Và có Tài khoản Đăng nhập! ");
		}
		return n> 0;
	}
}
