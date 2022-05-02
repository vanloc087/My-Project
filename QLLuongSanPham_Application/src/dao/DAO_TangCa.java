package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TangCa;

public class DAO_TangCa {
	
	public ArrayList<TangCa> getAllTangCa(){
		ArrayList<TangCa> list = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from TangCa";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTangCa= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayTangCa= rs.getDate(3);
				int soGio= rs.getInt(4);
				String maNguoiTao = rs.getString(5);
				Date ngayTao = rs.getDate(6);
				
				list.add(new TangCa(maTangCa, maNhanVien, ngayTangCa, soGio,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<TangCa> getAllTangCaTheoNV(){
		ArrayList<TangCa> list = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from TangCa order by maNhanVien";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTangCa= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayTangCa= rs.getDate(3);
				int soGio= rs.getInt(4);
				String maNguoiTao = rs.getString(5);
				Date ngayTao = rs.getDate(6);
				
				list.add(new TangCa(maTangCa, maNhanVien, ngayTangCa, soGio,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<TangCa> getAllTangCaTheoNguoiTao(){
		ArrayList<TangCa> list = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from TangCa order by maNguoiTao";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTangCa= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayTangCa= rs.getDate(3);
				int soGio= rs.getInt(4);
				String maNguoiTao = rs.getString(5);
				Date ngayTao = rs.getDate(6);
				
				list.add(new TangCa(maTangCa, maNhanVien, ngayTangCa, soGio,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<TangCa> getAllTangCaTheoNgayTao(){
		ArrayList<TangCa> list = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from TangCa order by ngayTao";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTangCa= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayTangCa= rs.getDate(3);
				int soGio= rs.getInt(4);
				String maNguoiTao = rs.getString(5);
				Date ngayTao = rs.getDate(6);
				
				list.add(new TangCa(maTangCa, maNhanVien, ngayTangCa, soGio,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<TangCa> getAllTangCaTheoSoGio(){
		ArrayList<TangCa> list = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from TangCa order by soGio";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTangCa= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayTangCa= rs.getDate(3);
				int soGio= rs.getInt(4);
				String maNguoiTao = rs.getString(5);
				Date ngayTao = rs.getDate(6);
				
				list.add(new TangCa(maTangCa, maNhanVien, ngayTangCa, soGio,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	public ArrayList<TangCa> getAllTangCaTheoMa(String ma){
		ArrayList<TangCa> list = new ArrayList<TangCa>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();

			String sql= "select * from TangCa where maNhanVien =?";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			pstm.setString(1, ma);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maTangCa= rs.getString(1);
				String maNhanVien= rs.getString(2);
				Date ngayTangCa= rs.getDate(3);
				int soGio= rs.getInt(4);
				String maNguoiTao = rs.getString(5);
				Date ngayTao = rs.getDate(6);
				
				list.add(new TangCa(maTangCa, maNhanVien, ngayTangCa, soGio,maNguoiTao,ngayTao));
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
			Connection con= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maTangCa FROM TangCa ORDER BY maTangCa DESC" ;
    	   PreparedStatement pstm = con.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maTangCa = rs.getString(1); 
    		  cl=maTangCa;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}
	
	//Thêm 
	
		public boolean create(TangCa cl) {
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
				String sql = "insert into TangCa values(?,?,?,?,?,?)";
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, cl.getMaTangCa());
				pstm.setString(2, cl.getMaNhanVien());
				pstm.setDate(3, cl.getNgayTangCa());
				pstm.setInt(4, cl.getSoGio());
				pstm.setString(5, cl.getMaNguoiTao());
				pstm.setDate(6, cl.getNgayTao());

				pstm.executeUpdate();
				return true;
			} catch (SQLException e1) {
				System.out.println(e1);
				return false;
			}

		}
		//Sửa
		public boolean suaTangCa(TangCa cl) throws Exception  {
				
				try {
					ConnectDB.getInstance().connect();
					ConnectDB.getInstance();
					Connection con= ConnectDB.getConnection();
					String sql = "update TangCa set maNhanVien = ?, ngayTangCa = ?, soGio = ?, maNguoiTao = ?, ngayTao = ?  where maTangCa = ?";
					PreparedStatement pstm = con.prepareStatement(sql);
					
					pstm.setString(6, cl.getMaTangCa());
					pstm.setString(1, cl.getMaNhanVien());
					pstm.setDate(2, cl.getNgayTangCa());
					pstm.setInt(3, cl.getSoGio());
					pstm.setString(4, cl.getMaNguoiTao());
					pstm.setDate(5, cl.getNgayTao());
					pstm.executeUpdate();
					return true;
				}catch (Exception e) {
					System.out.println(e);
					return false;
				}
			}
		// Xóa
		
		public boolean xoaTangCa(String ma) throws Exception  {
				
				try {
					ConnectDB.getInstance().connect();
					ConnectDB.getInstance();
					Connection con= ConnectDB.getConnection();
					String sql = "delete from TangCa where maTangCa = ?";
					PreparedStatement pstm = con.prepareStatement(sql);
					
					pstm.setString(1,ma);
					pstm.executeUpdate();
					return true;
				}catch (Exception e) {
					System.out.println(e);
					return false;
				}
			}
	

}
