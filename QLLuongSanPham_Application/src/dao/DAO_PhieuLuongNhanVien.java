package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;

import entity.NhanVienHanhChinh;

import entity.PhieuLuongNhanVien;

public class DAO_PhieuLuongNhanVien {
	
	public ArrayList<PhieuLuongNhanVien> getAllPhieuLuongNhanVien(){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	public ArrayList<PhieuLuongNhanVien> getAllPhieuLuongNhanVienTen(){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien order by hoTen";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongNhanVien> getAllPhieuLuongNhanVienThangLuong(){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien order by thangLuong";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongNhanVien> getAllPhieuLuongNhanVienNguoiTao(){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien order by maNguoiTao";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongNhanVien> getAllPhieuLuongNhanVienNgayTao(){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien order by ngayTao";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongNhanVien> getAllPhieuLuongNhanVienNV(){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien order by maNguoiHuong";
			
			PreparedStatement pstm= con.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	//doc pl theo cn
	public ArrayList<PhieuLuongNhanVien> getPhieuLuongTheoNV(String ma){
		ArrayList<PhieuLuongNhanVien> list = new ArrayList<PhieuLuongNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongNhanVien where maNguoiHuong =?";
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1, ma);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				String chucVu= rs.getString(6);
				String donViCongTac= rs.getString(7);
				double heSoLuong= rs.getDouble(8);
				int ngayNghi= rs.getInt(9);
				int ngayNghiCoPhep= rs.getInt(10);
				int soGioTangCa= rs.getInt(11);
				double thanhTien= rs.getDouble(12);
				String maNguoiTao= rs.getString(13);
				Date ngayTao= rs.getDate(14);
				
				
				list.add(new PhieuLuongNhanVien(maPhieuLuong, thangLuong, maNguoiHuong, hoTen, gioiTinh, chucVu, donViCongTac, heSoLuong, ngayNghi, ngayNghiCoPhep, soGioTangCa, thanhTien, maNguoiTao, ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	
	//Tim Nhan Vien
	public ArrayList<NhanVienHanhChinh> timMa(String ma)
	{
        ArrayList<NhanVienHanhChinh> list= new ArrayList<NhanVienHanhChinh>();
        
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select * from NhanVien where maNhanVien =?" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, ma);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maCongNhan = rs.getString(1); 
    		  String hoTen = rs.getString(2);
    		  String gioiTinh = rs.getString(3);
    		  Double heSoLuong =rs.getDouble(8);
    		  String chucVu = rs.getString(10);
    		  String donVi = rs.getString(9);
    		
    		  
    		NhanVienHanhChinh nv = new NhanVienHanhChinh(maCongNhan, hoTen, gioiTinh,heSoLuong,chucVu,donVi);
    		   list.add(nv);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return list;
	
	}
	
	
//	thêm Phiếu
	public boolean create(PhieuLuongNhanVien plcn) {
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql = "insert into PhieuLuongNhanVien values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, plcn.getMaPhieuLuong());
			pstm.setString(2, plcn.getThangLuong());
			pstm.setString(3, plcn.getMaNguoiHuong());
			pstm.setString(4, plcn.getHoTen());
			pstm.setString(5, plcn.getGioiTinh());
			pstm.setString(6, plcn.getChucVu());
			pstm.setString(7, plcn.getDonViCongTac());
			pstm.setDouble(8, plcn.getHeSoLuong());
			pstm.setDouble(9, plcn.getNgayNghi());
			pstm.setDouble(10, plcn.getNgayNghiCoPhep());
			pstm.setInt(11, plcn.getSoGioTangCa());
			pstm.setDouble(12, plcn.getThanhTien());
			pstm.setString(13, plcn.getMaNguoiTao());
			pstm.setDate(14, plcn.getNgayTao());
			
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}

	}
	//Dọc so san pham
	public String docSoNgayNghi(String ma,String thangNhoHon,String thangLonHon)
	{
        String  plcn=null;
       
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select count(ngayNghi) from NgayNghi  where maNhanVien =? and ngayNghi < ? and ngayNghi>= ?" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, ma);
    	   pstm.setString(2, thangLonHon);
    	   pstm.setString(3, thangNhoHon);
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  int soNgayNghi = rs.getInt(1); 
    		  
    		  plcn = Integer.toString(soNgayNghi);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return plcn;
	}
	
	public String docSoNgayNghiTroCap(String ma,String thangNhoHon,String thangLonHon)
	{
        String  plcn=null;
        
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select count(ngayNghi) from NgayNghi  where maNhanVien =? and ngayNghi < ? and ngayNghi>= ? and troCap=1" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, ma);
    	   pstm.setString(2, thangLonHon);
    	   pstm.setString(3, thangNhoHon);
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
	
	
	public String docSoGioTangCa(String ma,String thangNhoHon,String thangLonHon)
	{
        String  plcn=null;
   
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select sum(soGio) from TangCa  where maNhanVien =? and ngayTangCa < ? and ngayTangCa>= ? " ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, ma);
    	   pstm.setString(2, thangLonHon);
    	   pstm.setString(3, thangNhoHon);
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
			
	public String getMaLonNhat() {
		String  cl=null;
     
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="SELECT top 1 maPhieuLuong FROM PhieuLuongNhanVien ORDER BY maPhieuLuong DESC" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
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
			Connection conn= ConnectDB.getConnection();
			String sql = "delete from PhieuLuongNhanVien where maPhieuLuong = ?";
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
