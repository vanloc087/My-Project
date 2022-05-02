package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.sql.Date;
import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.SanPham;
import entity.ChiTietHopDong;
import entity.HopDong;

public class DAO_HopDong {

	public ArrayList<HopDong> getAllHopDong(){
		ArrayList<HopDong> dsHD = new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from HopDong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maHD = rs.getString(1);
				Date ngayTaoHD = rs.getDate(2);
				Date ngayHetHan = rs.getDate(3);
				SanPham sp = new SanPham(rs.getString(4));
				KhachHang kh = new KhachHang(rs.getString(5));
				NhanVienHanhChinh nv = new NhanVienHanhChinh(rs.getString(6));
				HopDong hd = new HopDong(maHD,ngayTaoHD,ngayHetHan,nv,kh,sp);
				dsHD.add(hd);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHD;
		
	}
	public ArrayList<ChiTietHopDong> getAllChiTietHopDong(){
		ArrayList<ChiTietHopDong> dsCTHD = new ArrayList<ChiTietHopDong>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from ChiTietHopDong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maHD = rs.getString(1);
				String tenHD = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				double giaTriHD = rs.getDouble(4);
				boolean thanhToan = rs.getBoolean(5);
				HopDong hd = new HopDong(maHD);
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hd, tenHD, soLuongSP, giaTriHD, thanhToan);
				dsCTHD.add(chiTietHopDong);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCTHD;
		
	}
	public ArrayList<ChiTietHopDong> getTatCaHopDong(){
		ArrayList<ChiTietHopDong> dsCTHD = new ArrayList<ChiTietHopDong>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from ChiTietHopDong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maHD = rs.getString(1);
				String tenHD = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				double giaTriHD = rs.getDouble(4);
				boolean thanhToan = rs.getBoolean(5);
				HopDong hd = new HopDong(maHD);
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hd, tenHD, soLuongSP, giaTriHD, thanhToan);
				dsCTHD.add(chiTietHopDong);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCTHD;
		
	}
	public String getChiTietHopDong(String ma){
		String thongTinChiTiet = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT c.maHopDong, tenHopDong, soLuongSanPham, giaTriHopDong,ThanhToan,\r\n" + 
					"       c.maSanPham, tenSanPham, donGia , maLoaiSanPham,\r\n" + 
					"	   c.maKhachHang,K.hoTen,k.gioiTinh,k.diaChi,k.SDT,\r\n" + 
					"	   c.maNhanVien,N.hoTen,chucVu\r\n" + 
					"FROM ((((HopDong C\r\n" + 
					"INNER JOIN ChiTietHopDong O ON C.maHopDong = O.maHopDong)\r\n" + 
					"INNER JOIN SanPham S ON C.maSanPham = S.maSanPham )\r\n" + 
					"INNER JOIN KhachHang K ON C.maKhachHang = K.maKhachHang )\r\n" + 
					"INNER JOIN NhanVien N ON C.maNhanVien = N.maNhanVien)\r\n" + 
					"WHERE c.maHopDong = "+"'"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maHD = rs.getString(1);
				String tenHD = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				double giaTriHD = rs.getDouble(4);
				boolean tinhTrang = rs.getBoolean(5);
				HopDong hd = new HopDong(maHD);
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hd,tenHD,soLuongSP,giaTriHD,tinhTrang);
				String maSP = rs.getString(6);
				String tenSP = rs.getString(7);
				double donGiaSP = rs.getDouble(8);
				String maLoaiSP = rs.getString(9);
				String maKH = rs.getString(10);
				String tenKH = rs.getString(11);
				String gioiTinh = rs.getString(12);
				String diaChi = rs.getString(13);
				String sdt = rs.getString(14);
				String maNV = rs.getString(15);
				String tenNV = rs.getString(16);
				String chucVu = rs.getString(17);
				
				thongTinChiTiet ="   Mã hợp đồng:\t"+chiTietHopDong.getMaHD().getMaHD()+"\t\t\t  \t\tMã khách hàng:\t"+maKH
						        +"\n   Tên hợp đồng:\t"+chiTietHopDong.getTenHD()+"                  "+"\t\t\t\tTên khách hàng:\t"+tenKH
						        +"\n   Số lượng sản phẩm:\t"+chiTietHopDong.getSoLuongSP()+"\t\t\t\t\tGiới tính:\t\t"+gioiTinh
						        +"\n   Giá trị hợp đồng:\t"+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(chiTietHopDong.getGiaTriHD())+"  "+"\t\t\t\tĐịa chỉ khách hàng:\t"+diaChi
						        +"\n   Tình trạng thanh toán:\t"+(chiTietHopDong.isThanhToan()?"Đã thanh toán \t":"Chưa thanh toán")+"\t  \t\t\tSố điện thoại khách hàng:\t"+sdt
						        +"\n"
						        +"\n   Mã nhân viên tạo:\t"+maNV+"\t\t  \t\t\tMã sản phẩm:\t\t"+maSP
						        +"\n   Tên nhân viên tạo:\t"+tenNV+"         "+"\t\t\t\tTên sản phẩm:\t\t"+tenSP
						        +"\n   Chức vụ nhân viên tạo:\t"+chucVu+"\t\t\t\t\tĐơn giá:\t\t"+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(donGiaSP)
				                +"\n   \t\t\t\t\t\t\tMã loại sản phẩm:\t"+maLoaiSP;
						
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return thongTinChiTiet;
	}
	public boolean creatHopDong(HopDong hopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into HopDong values(?,?,?,?,?,?)");
			stmt.setString(1,hopDong.getMaHD());
			stmt.setDate(2,(Date) hopDong.getNgayTao());
			stmt.setDate(3,(Date) hopDong.getNgayHetHan());
			stmt.setString(4,hopDong.getMaSP().getMaSP());
			stmt.setString(5, hopDong.getMaKH().getMaKhachHang());
			stmt.setString(6, hopDong.getMaNV().getMaNhanVien());

			n = stmt.executeUpdate();			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean createChiTietHopDong(ChiTietHopDong chiTietHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into ChiTietHopDong values(?,?,?,?,?)");
			stmt.setString(1,chiTietHopDong.getMaHD().getMaHD());
			stmt.setString(2, chiTietHopDong.getTenHD());
			stmt.setInt(3, chiTietHopDong.getSoLuongSP());
			stmt.setDouble(4, chiTietHopDong.getGiaTriHD());
			stmt.setBoolean(5, chiTietHopDong.isThanhToan());

			n = stmt.executeUpdate();			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean saveHopDong(ChiTietHopDong chiTietHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into TatCaHopDong values(?,?,?,?,?,?,?,?)");
			stmt.setString(1,chiTietHopDong.getMaHD().getMaHD());
			stmt.setString(2, chiTietHopDong.getTenHD());
			stmt.setInt(3, chiTietHopDong.getSoLuongSP());
			stmt.setDouble(4, chiTietHopDong.getGiaTriHD());
			stmt.setBoolean(5, chiTietHopDong.isThanhToan());
			stmt.setString(6, chiTietHopDong.getMaHD().getMaKH().getMaKhachHang());
			stmt.setString(7, chiTietHopDong.getMaHD().getMaSP().getMaSP());
			stmt.setString(8, chiTietHopDong.getMaHD().getMaNV().getMaNhanVien());

			n = stmt.executeUpdate();			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean deleteHopDong(String maHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from HopDong where maHopDong = ? ");
			stmt.setString(1, maHopDong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public boolean deleteChiTietHopDong(String maHopDong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from ChiTietHopDong where maHopDong = ?  ");
			stmt.setString(1, maHopDong);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public boolean updateChiTietHopDong(ChiTietHopDong chiTietHopDong, String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update ChiTietHopDong set maHopDong = ?,tenHopDong = ?,soLuongSanPham = ?,giaTriHopDong = ?,ThanhToan = ? where maHopDong = ?");
			
			stmt.setString(1, chiTietHopDong.getMaHD().getMaHD());
			stmt.setString(2, chiTietHopDong.getTenHD());
			stmt.setInt(3, chiTietHopDong.getSoLuongSP());
			stmt.setDouble(4, chiTietHopDong.getGiaTriHD());
			stmt.setBoolean(5, chiTietHopDong.isThanhToan());
			stmt.setString(6, dieuKien);
			
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
	public boolean updateHopDong(HopDong hopDong,String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update HopDong set maHopDong = ?,ngayTaoHopDong = ?,ngayHetHanHopDong=?,maSanPham=?,maKhachHang=?,maNhanVien=? where maHopDong=?");
			
			stmt.setString(1,hopDong.getMaHD());
			stmt.setDate(2,(Date) hopDong.getNgayTao());
			stmt.setDate(3,(Date) hopDong.getNgayHetHan());
			stmt.setString(4,hopDong.getMaSP().getMaSP());
			stmt.setString(5, hopDong.getMaKH().getMaKhachHang());
			stmt.setString(6, hopDong.getMaNV().getMaNhanVien());
			stmt.setString(7, dieuKien);
			
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
//	public String getMaLonNhat() {
//		String  hd=null;
//       
//       try {
//    	   ConnectDB.getInstance();
//    	   Connection con = ConnectDB.getConnection();
//    	   String sql="SELECT top 1 maHopDong FROM HopDong ORDER BY maHopDong DESC" ;
//    	   PreparedStatement pstm = con.prepareStatement(sql);
//    	   ResultSet rs= pstm.executeQuery();
//    	  
//    	   while (rs.next()) {
//    		  String maHopDong = rs.getString(1); 
//    		  hd=maHopDong;
//    		  
//    		   
//    	   }
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//	return hd;
//	
//	}
}
