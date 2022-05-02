package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
public class DAO_HoaDon {
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> list= new ArrayList<HoaDon>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getInstance().getConnection();
			String sql= "select * from HoaDon";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHoaDon= rs.getString(1);
				String maKhachHang= rs.getString(2);
				String maNhanVien = rs.getString(3);
				Date ngayTao= rs.getDate(4);
				String noiNhan= rs.getString(5);
				double tongtien= rs.getDouble(6);
				
				list.add ( new HoaDon(maHoaDon, ngayTao, new KhachHang(maKhachHang), new NhanVien(maNhanVien), noiNhan,tongtien));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return list;
	}
	//Lấy hóa đơn theo mã
	public ArrayList<HoaDon> getHoaDonTheoMa(String maHD){
		ArrayList<HoaDon> list= new ArrayList<HoaDon>();
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from HoaDon where maHoaDon = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maHoaDon = rs.getString(1);
				System.out.println(maHoaDon);
				String maKhachHang= rs.getString(2);
				String maNhanVien = rs.getString(3);
				Date ngayTao= rs.getDate(4);
				String noiNhan= rs.getString(5);
				double tongtien = rs.getDouble(6);
				HoaDon s = new HoaDon(maHoaDon, ngayTao, new KhachHang(maKhachHang), new NhanVien(maNhanVien), noiNhan, tongtien);
				list.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//Tạo hóa hơn
	public boolean create(HoaDon p) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update HoaDon set maKhachHang = ?, maNhanVien = ?, ngayTao = ?, noiNhan = ?, tongtien=?  where maHoaDon =  ?");
			stmt.setString(1, p.getMaHoaDon());
			stmt.setString(2, p.getMaKhachHang().getMaKhachHang());
			stmt.setString(3, p.getMaNhanVien().getMaNV());
			stmt.setDate(4, (Date) p.getNgayTao());
			stmt.setString(5, p.getNoiNhan());
			stmt.setDouble(6, p.getTongtien());
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	//Xóa hóa đơn
	public boolean delete(String maHD) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDon where maHoaDon = ?");
			stmt.setString(1, maHD);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}