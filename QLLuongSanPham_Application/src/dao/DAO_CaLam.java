package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CaLam;
import entity.LoaiSanPham;
import entity.SanPham;

public class DAO_CaLam {
	public ArrayList<CaLam> getAllCaLam(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from CaLam";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	public ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select * from SanPham";
			PreparedStatement pstm= con.prepareStatement(sql);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {				
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				Double donGiaSP = rs.getDouble(4);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(5));
				SanPham sp = new SanPham(maSP,tenSP,soLuongSP,donGiaSP,loaiSP);
				dsSP.add(sp);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSP;
	}
	
	public ArrayList<SanPham> getAllSanPhamTheoTen(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select * from SanPham order by tenSanPham";
			PreparedStatement pstm= con.prepareStatement(sql);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {				
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				Double donGiaSP = rs.getDouble(4);
				LoaiSanPham loaiSP = new LoaiSanPham(rs.getString(5));
				SanPham sp = new SanPham(maSP,tenSP,soLuongSP,donGiaSP,loaiSP);
				dsSP.add(sp);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSP;
	}
	/// theo ten 
	public ArrayList<CaLam> getAllCaLamTheoCN(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by maCongNhan";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	// theo ngay lam
	public ArrayList<CaLam> getAllCaLamTheoNgayLam(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by ngayLam";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<CaLam> getAllCaLamTheoNgayCN(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by ngayChuNhat";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	public ArrayList<CaLam> getAllCaLamTheoNgayTao(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by ngayTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	public ArrayList<CaLam> getAllCaLamTheoNVTao(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by maNguoiTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	public ArrayList<CaLam> getAllCaLamTheoCaLam(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by loaiCaLam";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	public ArrayList<CaLam> getAllCaLamTheoSP(){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam order by maSanPham";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	
	
	public ArrayList<CaLam> getCaLamTheoMa(String ma){
		ArrayList<CaLam> list = new ArrayList<CaLam>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CaLam where maCongNhan =?";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1, ma);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCaLam= rs.getString(1);
				String maCongNhan= rs.getString(2);
				String maSanPham= rs.getString(3);
				int soLuongSP= rs.getInt(4);
				String loaiCaLam= rs.getString(5);
				boolean ngayCN= rs.getBoolean(6);
				Date ngayLam = rs.getDate(7);
				String maNguoiTao = rs.getString(8);
				Date ngayTao = rs.getDate(9);
				
				
				
				list.add(new CaLam(maCaLam, maCongNhan, maSanPham, soLuongSP, loaiCaLam, ngayCN,ngayLam, maNguoiTao, ngayTao));
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
    	   String sql="SELECT top 1 maCaLam FROM CaLam ORDER BY maCaLam DESC" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maCaLam = rs.getString(1); 
    		  cl=maCaLam;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}
	//Thêm 
	
	public boolean create(CaLam cl) {
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql = "insert into CaLam values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cl.getMaCaLam());
			pstm.setString(2, cl.getMaCongNhan());
			pstm.setString(3, cl.getMaSanPham());
			pstm.setInt(4, cl.getSoLuongSP());
			pstm.setString(5, cl.getLoaiCaLam());
			pstm.setBoolean(6, cl.isNgayCN());
			pstm.setDate(7, cl.getNgayLam());
			pstm.setString(8, cl.getMaNguoiTao());
			pstm.setDate(9, cl.getNgayTao());

			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}

	}
	//Sửa
	public boolean suaCaLam(CaLam cl) throws Exception  {
			
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection conn= ConnectDB.getConnection();
				String sql = "update CaLam set maCongNhan = ?, maSanPham = ?, soLuongSanPham = ?, loaiCaLam = ?, ngayChuNhat = ?, ngayLam = ? ,  maNguoiTao = ?, ngayTao = ?  where maCaLam = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cl.getMaCongNhan());
				pstm.setString(2, cl.getMaSanPham());
				pstm.setInt(3,cl.getSoLuongSP());
				pstm.setString(4,cl.getLoaiCaLam());
				pstm.setBoolean(5,cl.isNgayCN());
				pstm.setDate(6, cl.getNgayLam());
				pstm.setString(7, cl.getMaNguoiTao());
				pstm.setDate(8, cl.getNgayTao());
				pstm.setString(9, cl.getMaCaLam());
				pstm.executeUpdate();
				return true;
			}catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	// Xóa
	
	public boolean xoaCaLam(String maCaLam) throws Exception  {
			
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection conn= ConnectDB.getConnection();
				String sql = "delete from CaLam where maCaLam = ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setString(1,maCaLam);
				pstm.executeUpdate();
				return true;
			}catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
	

}
