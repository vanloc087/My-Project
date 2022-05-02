package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongNhan;

import entity.PhieuLuongCongNhan;


public class DAO_PhieuLuongCongNhan {
	
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhanNgayTao(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan order by ngayTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhanThangLuong(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan order by thangLuong";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhanCN(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan order by maNguoiHuong";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhanMaNguoiTao(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan order by maNguoiTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhan(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	// lấy theo tên 
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhanTheoTen(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan order by hoTen";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	// lấy theo ngày tạo 
	public ArrayList<PhieuLuongCongNhan> getAllPhieuLuongCongNhanTheoNgayTao(){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan order by ngayTao";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	//doc pl theo cn
	public ArrayList<PhieuLuongCongNhan> getPhieuLuongTheoCN(String ma){
		ArrayList<PhieuLuongCongNhan> list = new ArrayList<PhieuLuongCongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from PhieuLuongCongNhan where maNguoiHuong =?";
			PreparedStatement pstm= conn.prepareStatement(sql);
			pstm.setString(1, ma);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhieuLuong= rs.getString(1);
				String thangLuong= rs.getString(2);
				String maNguoiHuong= rs.getString(3);
				String hoTen= rs.getString(4);
				String gioiTinh= rs.getString(5);
				int soSanPham= rs.getInt(6);
				int soSanPhamCa3= rs.getInt(7);
				int soSanPhamNgayCN= rs.getInt(8);
				Double donGia= rs.getDouble(9);
				Double thanhTien= rs.getDouble(10);
				String maNguoiTao= rs.getString(11);
				Date ngayTao= rs.getDate(12);
				
				
				list.add(new PhieuLuongCongNhan(maPhieuLuong,thangLuong,maNguoiHuong,hoTen,gioiTinh,soSanPham,soSanPhamCa3,soSanPhamNgayCN,donGia,thanhTien,maNguoiTao,ngayTao));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	
	
	public ArrayList<CongNhan> getAllCongNhan(){
		ArrayList<CongNhan> list = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CongNhan";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCongNhan= rs.getString(1);
				String hoTen= rs.getString(2);
				String gioiTinh= rs.getString(3);
				
				
				list.add(new CongNhan(maCongNhan, hoTen, gioiTinh));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	public ArrayList<CongNhan> getAllCongNhanTheoTen(){
		ArrayList<CongNhan> list = new ArrayList<CongNhan>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql= "select * from CongNhan order by hoTen";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCongNhan= rs.getString(1);
				String hoTen= rs.getString(2);
				String gioiTinh= rs.getString(3);
				
				
				list.add(new CongNhan(maCongNhan, hoTen, gioiTinh));
			}
			ConnectDB.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	
	//Tim Cong Nhan
	public ArrayList<CongNhan> timMa(String ma)
	{
        ArrayList<CongNhan> list= new ArrayList<CongNhan>();
       
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select * from CongNhan where maCongNhan =?" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, ma);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String maCongNhan = rs.getString(1); 
    		  String hoTen = rs.getString(2);
    		  String gioiTinh = rs.getString(3);
    		
    		  
    		CongNhan cn = new CongNhan(maCongNhan, hoTen, gioiTinh);
    		   list.add(cn);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return list;
	
	}
	
	public ArrayList<CongNhan> timCNTheoTen(String ten)
	{
        ArrayList<CongNhan> list= new ArrayList<CongNhan>();
        
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select * from CongNhan where hoTen like '%"+ten+"%'" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		   String maCongNhan = rs.getString(1); 
     		  String hoTen = rs.getString(2);
     		  String gioiTinh = rs.getString(3);
    		
    		  
      		CongNhan cn = new CongNhan(maCongNhan, hoTen, gioiTinh);
 		   list.add(cn);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return list;
	
	}
	
	
	
	//thêm Phiếu
	public boolean create(PhieuLuongCongNhan plcn) {
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
			String sql = "insert into PhieuLuongCongNhan values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, plcn.getMaPhieuLuong());
			pstm.setString(2, plcn.getThangLuong());
			pstm.setString(3, plcn.getMaNguoiHuong());
			pstm.setString(4, plcn.getHoTen());
			pstm.setString(5, plcn.getGioiTinh());
			pstm.setInt(6, plcn.getSoSanPham());
			pstm.setInt(7, plcn.getSoSanPhamCa3());
			pstm.setInt(8, plcn.getSoSanPhamNgayCN());
			pstm.setDouble(9, plcn.getDonGia());
			pstm.setDouble(10, plcn.getThanhTien());
			pstm.setString(11, plcn.getMaNguoiTao());
			pstm.setDate(12, plcn.getNgayTao());
			
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}

	}
	//Dọc so san pham
	public String docSoSanPham(String ma,String thangNhoHon,String thangLonHon)
	{
        String  plcn=null;
       
       try {
    		ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection conn= ConnectDB.getConnection();
    	   String sql="select sum(soLuongSanPham) from CaLam  where maCongNhan =?  and ngayLam < ? and ngayLam>= ?" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, ma);
    	   pstm.setString(2, thangLonHon);
    	   pstm.setString(3, thangNhoHon);
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
	
	//Dọc so san pham ca 3
		public String docSoSanPhamCa3(String ma,String thangNhoHon,String thangLonHon)
		{
	        String  plcn=null;
	       
	       try {
	    		ConnectDB.getInstance().connect();
				ConnectDB.getInstance();
				Connection conn= ConnectDB.getConnection();
	    	   String sql="select sum(soLuongSanPham) from CaLam  where maCongNhan =? and loaiCaLam='Ca 3' and ngayLam < ? and ngayLam>= ?" ;
	    	   PreparedStatement pstm = conn.prepareStatement(sql);
	    	   pstm.setString(1, ma);
	    	   pstm.setString(2, thangLonHon);
	    	   pstm.setString(3, thangNhoHon);
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
		
		//Dọc đơn giá
				public String docDonGia(String ma)
				{
			        String  plcn=null;
			        
			       try {
			    		ConnectDB.getInstance().connect();
						ConnectDB.getInstance();
						Connection conn= ConnectDB.getConnection();
			    	   String sql="select top 1 donGia from SanPham inner join CaLam on SanPham.maSanPham=CaLam.maSanPham where maCongNhan=?" ;
			    	   PreparedStatement pstm = conn.prepareStatement(sql);
			    	   pstm.setString(1, ma);
			    	 
			    	   ResultSet rs= pstm.executeQuery();
			    	  
			    	   while (rs.next()) {
			    		  Double soLuongSanPham = rs.getDouble(1); 
			    		  
			    		  plcn = Double.toString(soLuongSanPham);
			    		  
			    		   
			    	   }
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return plcn;
				
				}
				
				
				
				
				
		//Dọc so san pham ngay CN
				public String docSoSanPhamNgayCN(String ma,String thangNhoHon,String thangLonHon)
				{
			        String  plcn=null;
			        
			       try {
			    		ConnectDB.getInstance().connect();
						ConnectDB.getInstance();
						Connection conn= ConnectDB.getConnection();
			    	   String sql="select sum(soLuongSanPham) from CaLam  where maCongNhan =? and ngayChuNhat=1 and ngayLam < ? and ngayLam>= ?" ;
			    	   PreparedStatement pstm = conn.prepareStatement(sql);
			    	   pstm.setString(1, ma);
			    	   pstm.setString(2, thangLonHon);
			    	   pstm.setString(3, thangNhoHon);
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
				
				public String getMaLonNhat() {
					String  cl=null;
			       
			       try {
			    		ConnectDB.getInstance().connect();
						ConnectDB.getInstance();
						Connection conn= ConnectDB.getConnection();
			    	   String sql="SELECT top 1 maPhieuLuong FROM PhieuLuongCongNhan ORDER BY maPhieuLuong DESC" ;
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
						String sql = "delete from PhieuLuongCongNhan where maPhieuLuong = ?";
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
