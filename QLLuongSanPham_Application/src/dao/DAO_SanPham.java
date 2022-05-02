package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.LoaiSanPham;
import entity.SanPham;

public class DAO_SanPham {

	public ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select*from SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
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
	public ArrayList<LoaiSanPham> getAllLoaiSanPham(){
		ArrayList<LoaiSanPham> dsLoaiSP = new ArrayList<LoaiSanPham>();
		try {
			ConnectDB.getInstance().connect();
			ConnectDB.getInstance();
			Connection con= ConnectDB.getConnection();
			String sql = "select * from LoaiSanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {				
				String maLoaiSP = rs.getString(1);
				String tenLoaiSP = rs.getString(2);
				LoaiSanPham lsp = new LoaiSanPham(maLoaiSP,tenLoaiSP);
				dsLoaiSP.add(lsp);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoaiSP;
	}

	public boolean creatSanPham(SanPham sanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into SanPham values(?,?,?,?,?)");
			stmt.setString(1, sanPham.getMaSP());
			stmt.setString(2, sanPham.getTenSP());
			stmt.setInt(3, sanPham.getSoLuongSP());
			stmt.setDouble(4, sanPham.getDonGiaSP());
			stmt.setString(5, sanPham.getLoaiSP().getMaLoaiSP());

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
	
	public boolean createLoaiSP(LoaiSanPham loaiSanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert  into LoaiSanPham values(?,?)");
			stmt.setString(1, loaiSanPham.getMaLoaiSP());
			stmt.setString(2, loaiSanPham.getTenLoaiSP());

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
	public boolean deleteSanPham(String maSanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from SanPham where maSanPham = ? ");
			stmt.setString(1, maSanPham);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public boolean deleteLoaiSP(String maLoaiSanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0 ;
		try {
			stmt = con.prepareStatement("delete from LoaiSanPham where maLoaiSanPham = ?  ");
			stmt.setString(1, maLoaiSanPham);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n> 0;
	}
	public boolean updateSanPham(SanPham sanPham, String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update SanPham set maSanPham = ?,tenSanPham = ?,soLuong = ?,donGia = ?,maLoaiSanPham = ? where maSanPham = ?");
			
			stmt.setString(1, sanPham.getMaSP());
			stmt.setString(2, sanPham.getTenSP());
			stmt.setInt(3, sanPham.getSoLuongSP());
			stmt.setDouble(4, sanPham.getDonGiaSP());
			stmt.setString(5, sanPham.getLoaiSP().getMaLoaiSP());
			stmt.setString(6, dieuKien);
			
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
	public boolean updateLoaiSP(LoaiSanPham lsp,String dieuKien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt = con.prepareStatement("update loaiSanPham set maLoaiSanPham = ?,tenLoaiSanPham = ? where maLoaiSanPham=?");
			
			stmt.setString(1, lsp.getMaLoaiSP());
			stmt.setString(2, lsp.getTenLoaiSP());
			stmt.setString(3, dieuKien);
			
			n = stmt.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n>0;
	}
}
