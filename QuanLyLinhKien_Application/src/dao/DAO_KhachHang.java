package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import connectDB.Database;
import entity.KhachHang;

public class DAO_KhachHang {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> list= new ArrayList<KhachHang>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from KhachHang";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maKhachHang= rs.getString(1);
				String tenKhachHang= rs.getString(2);
				String sDT= rs.getString(3);
				String diaChi= rs.getString(4);
				
				list.add(new KhachHang(maKhachHang, tenKhachHang,sDT, diaChi )  );
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	
	public ArrayList<KhachHang> getAllKhachHangTheoTen() {
		ArrayList<KhachHang> list= new ArrayList<KhachHang>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from KhachHang order by tenKH";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maKhachHang= rs.getString(1);
				String tenKhachHang= rs.getString(2);
				String sDT= rs.getString(3);
				String diaChi= rs.getString(4);
				
				list.add(new KhachHang(maKhachHang, tenKhachHang,sDT, diaChi )  );
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	
	public ArrayList<KhachHang> getAllKhachHangTheoDiaChi(String diachi) {
		ArrayList<KhachHang> list= new ArrayList<KhachHang>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from KhachHang where diaChi like '%" + diachi + "%'";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maKhachHang= rs.getString(1);
				String tenKhachHang= rs.getString(2);
				String sDT= rs.getString(3);
				String diaChi= rs.getString(4);
				
				list.add(new KhachHang(maKhachHang, tenKhachHang,sDT, diaChi )  );
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	public KhachHang getElement(int index) {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			Connection con = Database.getInstance().getConnection();
			
			String sql = "Select * from KhachHang";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String makh = rs.getString(1);
				String tenkh = rs.getString(2);
				String sdt=rs.getString(3);
				String diachi=rs.getString(4);
				dskh.add(new KhachHang(makh, tenkh, sdt, diachi));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		if(index<0 || index>dskh.size())
			return null;
		return dskh.get(index);
	}
	public boolean create(KhachHang kh) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into KhachHang values(?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, kh.getMaKhachHang());
			pstm.setString(2, kh.getTenKhachHang());
			pstm.setString(3, kh.getSDT());
			pstm.setString(4, kh.getDiaChi());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}

	}
	public boolean xoa(String maKH) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "delete from KhachHang where maKhachHang = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,maKH);
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean update(KhachHang cv) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update KhachHang set tenKH = ?, SDT = ?, diaChi = ?  where maKhachHang = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,cv.getTenKhachHang());
			pstm.setString(2, cv.getSDT());
			pstm.setString(3, cv.getDiaChi());
			pstm.setString(4,cv.getMaKhachHang());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public ArrayList<KhachHang> findname(String name)
	{
        ArrayList<KhachHang> khlist= new ArrayList<KhachHang>();
        Database.getInstance().connect();
		Connection conn = Database.getConnection();
       try {
    	   String sql="select * from KhachHang where tenKH like '%" + name + "%'" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String makh = rs.getString(1); 
    		  String tenkh = rs.getString(2);
    		  String sdt = rs.getString(3);
              String dc = rs.getString(4);
    		
    		  
    		KhachHang kh = new KhachHang(makh,tenkh,sdt , dc );
    		   khlist.add(kh);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return khlist;
	
	}
	
	public ArrayList<KhachHang> findDiaChi(String diaChi)
	{
        ArrayList<KhachHang> khlist= new ArrayList<KhachHang>();
        Database.getInstance().connect();
		Connection conn = Database.getConnection();
       try {
    	   String sql="select * from KhachHang where diaChi like '%" + diaChi + "%'" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String makh = rs.getString(1); 
    		  String tenkh = rs.getString(2);
    		  String sdt = rs.getString(3);
              String dc = rs.getString(4);
    		
    		  
    		KhachHang kh = new KhachHang(makh,tenkh,sdt , dc );
    		   khlist.add(kh);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return khlist;
	
	}
	
	
	public ArrayList<KhachHang> findid(String id)
	{
        ArrayList<KhachHang> khlist= new ArrayList<KhachHang>();
        Database.getInstance().connect();
		Connection conn = Database.getConnection();
       try {
    	   String sql="select * from KhachHang where maKhachHang =?" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, id);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String makh = rs.getString(1); 
    		  String tenkh = rs.getString(2);
    		  String sdt = rs.getString(3);
              String dc = rs.getString(4);
    		
    		  
    		KhachHang kh = new KhachHang(makh,tenkh,sdt , dc );
    		   khlist.add(kh);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return khlist;
	
	}
	
	
	public ArrayList<KhachHang> findsdt(String Sdt)
	{
        ArrayList<KhachHang> khlist= new ArrayList<KhachHang>();
        Database.getInstance().connect();
		Connection conn = Database.getConnection();
       try {
    	   String sql="select * from KhachHang where SDT =?" ;
    	   PreparedStatement pstm = conn.prepareStatement(sql);
    	   pstm.setString(1, Sdt);
    	 
    	   ResultSet rs= pstm.executeQuery();
    	  
    	   while (rs.next()) {
    		  String makh = rs.getString(1); 
    		  String tenkh = rs.getString(2);
    		  String sdt = rs.getString(3);
              String dc = rs.getString(4);
    		
    		  
    		KhachHang kh = new KhachHang(makh,tenkh,sdt , dc );
    		   khlist.add(kh);
    		  
    		   
    	   }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return khlist;
	
	}
		
	
	

}