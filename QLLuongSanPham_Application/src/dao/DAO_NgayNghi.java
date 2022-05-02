package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NgayNghi;

public class DAO_NgayNghi {
	
	public ArrayList<NgayNghi> getAllNN(){
		ArrayList<NgayNghi> list = new ArrayList<NgayNghi>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from NgayNghi";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNgayNghi= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayNghi= rs.getDate(3);
				Date ngayHetNghi= rs.getDate(4);
				boolean troCap= rs.getBoolean(5);
				String lyDo = rs.getString(6);
				String maNguoiTao = rs.getString(7);
				Date ngayTao = rs.getDate(8);
				
				list.add(new NgayNghi(maNgayNghi, maNhanVien, ngayNghi, ngayHetNghi, troCap, lyDo, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<NgayNghi> getAllNNNV(){
		ArrayList<NgayNghi> list = new ArrayList<NgayNghi>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from NgayNghi order by maNhanVien";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNgayNghi= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayNghi= rs.getDate(3);
				Date ngayHetNghi= rs.getDate(4);
				boolean troCap= rs.getBoolean(5);
				String lyDo = rs.getString(6);
				String maNguoiTao = rs.getString(7);
				Date ngayTao = rs.getDate(8);
				
				list.add(new NgayNghi(maNgayNghi, maNhanVien, ngayNghi, ngayHetNghi, troCap, lyDo, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<NgayNghi> getAllNNTheoNguoiTao(){
		ArrayList<NgayNghi> list = new ArrayList<NgayNghi>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from NgayNghi order by maNguoiTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNgayNghi= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayNghi= rs.getDate(3);
				Date ngayHetNghi= rs.getDate(4);
				boolean troCap= rs.getBoolean(5);
				String lyDo = rs.getString(6);
				String maNguoiTao = rs.getString(7);
				Date ngayTao = rs.getDate(8);
				
				list.add(new NgayNghi(maNgayNghi, maNhanVien, ngayNghi, ngayHetNghi, troCap, lyDo, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<NgayNghi> getAllNNTheoNgayTao(){
		ArrayList<NgayNghi> list = new ArrayList<NgayNghi>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from NgayNghi order by ngayTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNgayNghi= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayNghi= rs.getDate(3);
				Date ngayHetNghi= rs.getDate(4);
				boolean troCap= rs.getBoolean(5);
				String lyDo = rs.getString(6);
				String maNguoiTao = rs.getString(7);
				Date ngayTao = rs.getDate(8);
				
				list.add(new NgayNghi(maNgayNghi, maNhanVien, ngayNghi, ngayHetNghi, troCap, lyDo, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<NgayNghi> getAllNNTheoTroCap(){
		ArrayList<NgayNghi> list = new ArrayList<NgayNghi>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from NgayNghi order by troCap";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNgayNghi= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayNghi= rs.getDate(3);
				Date ngayHetNghi= rs.getDate(4);
				boolean troCap= rs.getBoolean(5);
				String lyDo = rs.getString(6);
				String maNguoiTao = rs.getString(7);
				Date ngayTao = rs.getDate(8);
				
				list.add(new NgayNghi(maNgayNghi, maNhanVien, ngayNghi, ngayHetNghi, troCap, lyDo, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	public ArrayList<NgayNghi> getNgayNghiTheoMa(String ma){
		ArrayList<NgayNghi> list = new ArrayList<NgayNghi>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from NgayNghi where maNhanVien =?";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1, ma);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNgayNghi= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayNghi= rs.getDate(3);
				Date ngayHetNghi= rs.getDate(4);
				boolean troCap= rs.getBoolean(5);
				String lyDo = rs.getString(6);
				String maNguoiTao = rs.getString(7);
				Date ngayTao = rs.getDate(8);
				
				list.add(new NgayNghi(maNgayNghi, maNhanVien, ngayNghi, ngayHetNghi, troCap, lyDo, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	public String getMaLonNhat() {
		String  cl=null;
        
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maNgayNghi FROM NgayNghi ORDER BY maNgayNghi DESC" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maNN = rs.getString(1); 
    		  cl=maNN;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}
	//Thêm 
	
	public boolean create(NgayNghi cl) {
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql = "insert into NgayNghi values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cl.getMaNgayNghi());
			pstm.setString(2, cl.getMaNhanVien());
			pstm.setDate(3, cl.getNgayNghi());
			pstm.setDate(4, cl.getNgayHetNghi());
			pstm.setBoolean(5, cl.isTroCap());
			pstm.setString(6, cl.getLyDo());
			pstm.setString(7, cl.getMaNguoiTao());
			pstm.setDate(8, cl.getNgayTao());

			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}

	}
	//Sửa
	public boolean suaNgayNghi(NgayNghi cl) throws Exception  {
			
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection conn= ConnectDB.getConnection();
				String sql = "update NgayNghi set maNhanVien = ?, ngayNghi = ?, ngayHetNghi = ?, troCap = ?, lyDo = ?, maNguoiTao = ?, ngayTao = ?  where maNgayNghi = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setString(8, cl.getMaNgayNghi());
				pstm.setString(1, cl.getMaNhanVien());
				pstm.setDate(2, cl.getNgayNghi());
				pstm.setDate(3, cl.getNgayHetNghi());
				pstm.setBoolean(4, cl.isTroCap());
				pstm.setString(5, cl.getLyDo());
				pstm.setString(6, cl.getMaNguoiTao());
				pstm.setDate(7, cl.getNgayTao());
				pstm.executeUpdate();
				return true;
			}catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	// Xóa
	
	public boolean xoaNgayNghi(String ma) throws Exception  {
			
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection conn= ConnectDB.getConnection();
				String sql = "delete from NgayNghi where maNgayNghi = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setString(1,ma);
				pstm.executeUpdate();
				return true;
			}catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}

}
