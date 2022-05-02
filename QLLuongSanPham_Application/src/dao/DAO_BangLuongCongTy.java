package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.BangLuongCongTy;

public class DAO_BangLuongCongTy {
	public ArrayList<BangLuongCongTy> getAllBangLuongThangLuong(){
		ArrayList<BangLuongCongTy> list = new ArrayList<BangLuongCongTy>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from BangLuongCongTy order by thangLuong";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maBangLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				Double tongLuongCongTy= rs.getDouble(3);
				Double tongLuongNhanVien= rs.getDouble(4);
				Double tongLuongCongNhan= rs.getDouble(5);
				int tongSanPham= rs.getInt(6);
				int tongGioTangCa= rs.getInt(7);
				String maNguoiTao= rs.getString(8);
				Date ngayTao= rs.getDate(9);
				
				
				list.add(new BangLuongCongTy(maBangLuong, thangLuong, tongLuongCongTy, tongLuongNhanVien, tongLuongCongNhan, tongSanPham, tongGioTangCa, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<BangLuongCongTy> getAllBangLuong(){
		ArrayList<BangLuongCongTy> list = new ArrayList<BangLuongCongTy>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from BangLuongCongTy";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maBangLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				Double tongLuongCongTy= rs.getDouble(3);
				Double tongLuongNhanVien= rs.getDouble(4);
				Double tongLuongCongNhan= rs.getDouble(5);
				int tongSanPham= rs.getInt(6);
				int tongGioTangCa= rs.getInt(7);
				String maNguoiTao= rs.getString(8);
				Date ngayTao= rs.getDate(9);
				
				
				list.add(new BangLuongCongTy(maBangLuong, thangLuong, tongLuongCongTy, tongLuongNhanVien, tongLuongCongNhan, tongSanPham, tongGioTangCa, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<BangLuongCongTy> getAllBangLuongMaNguoiTao(){
		ArrayList<BangLuongCongTy> list = new ArrayList<BangLuongCongTy>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from BangLuongCongTy order by maNguoiTao";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maBangLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				Double tongLuongCongTy= rs.getDouble(3);
				Double tongLuongNhanVien= rs.getDouble(4);
				Double tongLuongCongNhan= rs.getDouble(5);
				int tongSanPham= rs.getInt(6);
				int tongGioTangCa= rs.getInt(7);
				String maNguoiTao= rs.getString(8);
				Date ngayTao= rs.getDate(9);
				
				
				list.add(new BangLuongCongTy(maBangLuong, thangLuong, tongLuongCongTy, tongLuongNhanVien, tongLuongCongNhan, tongSanPham, tongGioTangCa, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<BangLuongCongTy> getAllBangLuongNgayTao(){
		ArrayList<BangLuongCongTy> list = new ArrayList<BangLuongCongTy>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from BangLuongCongTy order by ngayTao";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maBangLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				Double tongLuongCongTy= rs.getDouble(3);
				Double tongLuongNhanVien= rs.getDouble(4);
				Double tongLuongCongNhan= rs.getDouble(5);
				int tongSanPham= rs.getInt(6);
				int tongGioTangCa= rs.getInt(7);
				String maNguoiTao= rs.getString(8);
				Date ngayTao= rs.getDate(9);
				
				
				list.add(new BangLuongCongTy(maBangLuong, thangLuong, tongLuongCongTy, tongLuongNhanVien, tongLuongCongNhan, tongSanPham, tongGioTangCa, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	//Tim Bang Luong
		public ArrayList<BangLuongCongTy> timMa(String ma)
		{
	        ArrayList<BangLuongCongTy> list= new ArrayList<BangLuongCongTy>();
	       try {
	    	   ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
	    	   String sql="select * from BangLuongCongTy where maBangLuong =?" ;
	    	   PreparedStatement pstm = con.prepareStatement(sql);
	    	   pstm.setString(1, ma);
	    	 
	    	   ResultSet rs= pstm.executeQuery();
	    	  
	    	   while (rs.next()) {
	    		   String maBangLuong= rs.getString(1);
					String thangLuong= rs.getString(2);
					Double tongLuongCongTy= rs.getDouble(3);
					Double tongLuongNhanVien= rs.getDouble(4);
					Double tongLuongCongNhan= rs.getDouble(5);
					int tongSanPham= rs.getInt(6);
					int tongGioTangCa= rs.getInt(7);
					String maNguoiTao= rs.getString(8);
					Date ngayTao= rs.getDate(9);
	    		
	    		  
	    		BangLuongCongTy bl = new BangLuongCongTy(maBangLuong, thangLuong, tongLuongCongTy, tongLuongNhanVien, tongLuongCongNhan, tongSanPham, tongGioTangCa, maNguoiTao, ngayTao);
	    		   list.add(bl);
	    		  
	    		   
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
		
		}
	
	//thêm Phiếu
		public boolean create(BangLuongCongTy plcn) {
			try {
				ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
				String sql = "insert into BangLuongCongTy values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, plcn.getMaBangLuong());
				pstm.setString(2, plcn.getThangLuong());
				pstm.setDouble(3, plcn.getTongLuongCongTy());
				pstm.setDouble(4, plcn.getTongLuongNhanVien());
				pstm.setDouble(5, plcn.getTongLuongCongNhan());
				pstm.setInt(6, plcn.getTongSanPham());
				pstm.setInt(7, plcn.getTongSoGioTangCa());
				pstm.setString(8, plcn.getMaNguoiTao());
				pstm.setDate(9, plcn.getNgayTao());
				
				pstm.executeUpdate();
				return true;
			} catch (SQLException e1) {
				System.out.println(e1);
				return false;
			}

		}
	
	public String getMaLonNhat() {
		String  cl=null;
       try {
    	   ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maBangLuong FROM BangLuongCongTy ORDER BY maBangLuong DESC" ;
    	   PreparedStatement pstm = con.prepareStatement(sql);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maPhieuLuong = rs.getString(1); 
    		  cl=maPhieuLuong;
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cl;
	
	}
	public boolean xoaPL(String ma) throws Exception  {
		
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "delete from BangLuongCongTy where maBangLuong = ?";
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setString(1,ma);
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	//Dọc so tong san pham
		public String docSoSanPham(String thangNhoHon,String thangLonHon)
		{
	        String  plcn=null;
	       try {
	    	   ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
	    	   String sql="select sum(soLuongSanPham) from CaLam  where ngayLam < ? and ngayLam>= ?" ;
	    	   PreparedStatement pstm = con.prepareStatement(sql);
	    	   pstm.setString(1, thangLonHon);
	    	   pstm.setString(2, thangNhoHon);
	    	   ResultSet rs= pstm.executeQuery();
	    	  
	    	   while (rs.next()) {
	    		  int soLuongSanPham = rs.getInt(1); 
	    		  
	    		  plcn = Integer.toString(soLuongSanPham);
	    		  
	    		   
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return plcn;
		
		}
		
		
		public String docSoGioTangCa(String thangNhoHon,String thangLonHon)
		{
	        String  plcn=null;
	       try {
	    	   ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
	    	   String sql="select sum(soGio) from TangCa  where ngayTangCa < ? and ngayTangCa>= ? " ;
	    	   PreparedStatement pstm = con.prepareStatement(sql);
	    	   pstm.setString(1, thangLonHon);
	    	   pstm.setString(2, thangNhoHon);
	    	   ResultSet rs= pstm.executeQuery();
	    	  
	    	   while (rs.next()) {
	    		  int soNgayNghiTC = rs.getInt(1); 
	    		  
	    		  plcn = Integer.toString(soNgayNghiTC);
	    		  
	    		   
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return plcn;
		}
		
		
		public String docTongLuongNV(String thang)
		{
	        String  plcn=null;
	  
	       try {
	    	   ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
	    	   String sql="select sum(thanhTien) from PhieuLuongNhanVien  where thangLuong = ?" ;
	    	   PreparedStatement pstm = con.prepareStatement(sql);
	    	   pstm.setString(1, thang);
	    	   ResultSet rs= pstm.executeQuery();
	    	  
	    	   while (rs.next()) {
	    		  int soNgayNghiTC = rs.getInt(1); 
	    		  
	    		  plcn = Integer.toString(soNgayNghiTC);
	    		  
	    		   
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return plcn;
		}
		
		public String docTongLuongCN(String thang)
		{
	        String  plcn=null;
	       try {
	    	   ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection con= ConnectDB.getConnection();
	    	   String sql="select sum(thanhTien) from PhieuLuongCongNhan  where thangLuong = ?" ;
	    	   PreparedStatement pstm = con.prepareStatement(sql);
	    	   pstm.setString(1, thang);
	    	   ResultSet rs= pstm.executeQuery();
	    	  
	    	   while (rs.next()) {
	    		  int soNgayNghiTC = rs.getInt(1); 
	    		  
	    		  plcn = Integer.toString(soNgayNghiTC);
	    		  
	    		   
	    	   }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return plcn;
		}
		

}
