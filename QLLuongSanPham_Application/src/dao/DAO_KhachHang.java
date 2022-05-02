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
import entity.KhachHang;


public class DAO_KhachHang implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<KhachHang> getAllKhachHang(){
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select*from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maKhachHang = rs.getString(1);
				String hoTen = rs.getString(2);	
				String gioiTinh = rs.getString(3);
				String sDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);

				KhachHang kh = new KhachHang(maKhachHang, hoTen, gioiTinh, sDT, ngaySinh, diaChi);
				dskh.add(kh);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public boolean Updata(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update KhachHang Set hoTen = ?, gioiTinh = ?, SDT=?, ngaySinh=?, diaChi=? where maKhachHang=?");
			stmt.setString(1, kh.getHoTen());
			stmt.setString(2, kh.getGioiTinh());
			stmt.setString(3, kh.getsDT());
			stmt.setDate(4, (Date) kh.getNgaySinh());
			stmt.setString(5, kh.getDiaChi());
			stmt.setString(6, kh.getMaKhachHang());
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {

		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				
			}
		}
		return n>0;
		
	}
	
	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into KhachHang values(?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getHoTen());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setString(4, kh.getsDT());
			stmt.setDate(5, (Date) kh.getNgaySinh());
			stmt.setString(6, kh.getDiaChi());
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
	
	public boolean delete(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKhachHang = ?  ");
			stmt.setString(1, maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Chú ý: Không Thể Xóa Vì Khách Hàng Đang Còn Hợp Đồng! ");
		}
		return n> 0;
	}
public KhachHang getkhachHangma(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		KhachHang kh = null;
		try {
			
			String sql = "Select *  from KhachHang where maKhachHang = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				kh = new KhachHang(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

public ArrayList<KhachHang> getkhachHangTen(String ten){
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	try {
		
		String sql = "Select *  from KhachHang where hoTen LIKE N'%"+ten+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			KhachHang kh = new KhachHang(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
			dskh.add(kh);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dskh;
}
public KhachHang getkhachHangsdt(String sdt){
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	KhachHang kh = null;
	try {
		
		String sql = "Select *  from KhachHang where SDT = '"+sdt+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			kh = new KhachHang(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return kh;
}

public ArrayList<KhachHang> getkhachHangGT(String gt){
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	try {
		String sql = "Select *  from KhachHang where gioiTinh Like N'%"+gt+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			KhachHang kh = new KhachHang(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
			dskh.add(kh);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dskh;
}

}

