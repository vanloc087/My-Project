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
import entity.CongNhan;



public class DAO_CongNhan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<CongNhan> getAllCongNhan(){
		ArrayList<CongNhan> dscn = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from CongNhan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
			    
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				CongNhan cn = new CongNhan(maCongNhan, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
				dscn.add(cn);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscn;

	}
	public ArrayList<CongNhan> getAllCongNhanTheoTen(){
		ArrayList<CongNhan> dscn = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from CongNhan order by hoTen";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String  maCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
			    
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				CongNhan cn = new CongNhan(maCongNhan, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
				dscn.add(cn);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscn;

	}
	public boolean create(CongNhan cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into CongNhan values(?,?,?,?,?,?)");
			stmt.setString(1, cn.getMaCongNhan());
			stmt.setString(2, cn.getHoTen());
			stmt.setString(3, cn.getGioiTinh());
			stmt.setString(4, cn.getSdt());
			stmt.setDate(5, (Date) cn.getNgaySinh());
			stmt.setString(6, cn.getDiaChi());
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
	
	public boolean Updata(CongNhan cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update CongNhan Set hoTen = ?, gioiTinh = ?, SDT=?, ngaySinh=?, diaChi=? where maCongNhan=?");
			stmt.setString(1, cn.getHoTen());
			stmt.setString(2, cn.getGioiTinh());
			stmt.setString(3, cn.getSdt());
			stmt.setDate(4, (Date) cn.getNgaySinh());
			stmt.setString(5, cn.getDiaChi());
			stmt.setString(6, cn.getMaCongNhan());
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Chú ý: Nhập số điện thoại sai cú pháp!Là số và 10 kí tự!)");
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
	public boolean delete(String macn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from CongNhan where maCongNhan = ?  ");
			stmt.setString(1, macn);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	
public CongNhan getCongNhanma(String ma){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		CongNhan cn = null;
		try {
			
			String sql = "Select *  from CongNhan where maCongNhan = '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String  maNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				String gioiTinh = rs.getString(3);
			   
				String SDT = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				String diaChi = rs.getString(6);
				cn = new CongNhan(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

public ArrayList<CongNhan> getCongNhanTen(String ten){
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<CongNhan> dscn = new ArrayList<CongNhan>();
	try {
		
		String sql = "Select *  from CongNhan where hoTen LIKE N'%"+ten+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
		    
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			CongNhan cn = new CongNhan(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
			dscn.add(cn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dscn;
}
public CongNhan getCongNhansdt(String sdt){
	
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	CongNhan cn = null;
	try {
		
		String sql = "Select *  from CongNhan where SDT = '"+sdt+"'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
		   
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			cn = new CongNhan(maNhanVien, hoTen, gioiTinh, SDT, ngaySinh, diaChi);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return cn;
}

public ArrayList<CongNhan> getCongNhanGT(String gt){
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	ArrayList<CongNhan> dscn = new ArrayList<CongNhan>();
	try {
		
		String sql = "Select *  from CongNhan where gioiTinh LIKE N'%"+gt+"%'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			String  maNhanVien = rs.getString(1);
			String hoTen = rs.getString(2);
			String gioiTinh = rs.getString(3);
		    
			String SDT = rs.getString(4);
			Date ngaySinh = rs.getDate(5);
			String diaChi = rs.getString(6);
			CongNhan cn = new CongNhan(maNhanVien, hoTen,gioiTinh, SDT, ngaySinh, diaChi);
			dscn.add(cn);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dscn;
}

	
}
