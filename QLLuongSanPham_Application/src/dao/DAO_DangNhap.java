package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.DangNhap;


public class DAO_DangNhap  implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String mkc;

public String getTKTen(String tk){
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			
			String stmt = "select *from TaiKhoan where tenTaiKhoan=?";
			PreparedStatement ps= con.prepareStatement(stmt);
			ps.setString(1, tk);	
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				this.mkc = rs.getString(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mkc;
	}

public boolean Updata(DangNhap dn) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt=null;
	int n=0;
	try {
		stmt = con.prepareStatement("Update TaiKhoan Set matKhau = ? where tenTaiKhoan= ?");			
		stmt.setString(1, dn.getMatKhau());
		stmt.setString(2, dn.getTaiKhoan());
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
	
	
}
