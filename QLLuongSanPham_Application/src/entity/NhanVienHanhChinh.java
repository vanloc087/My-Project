package entity;

import java.util.Date;

public class NhanVienHanhChinh {
	private String maNhanVien;
	private String hoTen;
	private String gioiTinh;
	private String sdt;
	private Date ngaySinh;
	private String diaChi;
	private Date ngayBatDau;
	private double heSoluong;
	private String donViCongTac;
	private String chucVu;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public double getHeSoluong() {
		return heSoluong;
	}
	public void setHeSoluong(double heSoluong) {
		this.heSoluong = heSoluong;
	}
	public String getDonViCongTac() {
		return donViCongTac;
	}
	public void setDonViCongTac(String donViCongTac) {
		this.donViCongTac = donViCongTac;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVienHanhChinh other = (NhanVienHanhChinh) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}
	
	
	public NhanVienHanhChinh(String maNhanVien, String hoTen, String gioiTinh, double heSoluong, String donViCongTac,
			String chucVu) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.heSoluong = heSoluong;
		this.donViCongTac = donViCongTac;
		this.chucVu = chucVu;
	}
	public NhanVienHanhChinh(String maNhanVien, String hoTen, String gioiTinh, String sdt, Date ngaySinh, String diaChi,
			Date ngayBatDau, double heSoluong, String donViCongTac, String chucVu) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.ngayBatDau = ngayBatDau;
		this.heSoluong = heSoluong;
		this.donViCongTac = donViCongTac;
		this.chucVu = chucVu;
	}
	public NhanVienHanhChinh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVienHanhChinh(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVienHanhChinh [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", sdt="
				+ sdt + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", ngayBatDau=" + ngayBatDau + ", heSoluong="
				+ heSoluong + ", donViCongTac=" + donViCongTac + ", chucVu=" + chucVu + "]";
	}
	
}
 
 

