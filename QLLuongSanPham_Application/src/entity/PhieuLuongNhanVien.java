package entity;

import java.sql.Date;

public class PhieuLuongNhanVien {
	private String maPhieuLuong;
	private String thangLuong;
	private String maNguoiHuong;
	private String hoTen;
	private String gioiTinh;
	private String chucVu;
	private String donViCongTac;
	private double heSoLuong;
	private int ngayNghi;
	private int ngayNghiCoPhep;
	private int soGioTangCa;
	private double thanhTien;
	private String maNguoiTao;
	private Date ngayTao;
	public String getMaPhieuLuong() {
		return maPhieuLuong;
	}
	public void setMaPhieuLuong(String maPhieuLuong) {
		this.maPhieuLuong = maPhieuLuong;
	}
	public String getThangLuong() {
		return thangLuong;
	}
	public void setThangLuong(String thangLuong) {
		this.thangLuong = thangLuong;
	}
	public String getMaNguoiHuong() {
		return maNguoiHuong;
	}
	public void setMaNguoiHuong(String maNguoiHuong) {
		this.maNguoiHuong = maNguoiHuong;
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
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getDonViCongTac() {
		return donViCongTac;
	}
	public void setDonViCongTac(String donViCongTac) {
		this.donViCongTac = donViCongTac;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public int getNgayNghi() {
		return ngayNghi;
	}
	public void setNgayNghi(int ngayNghi) {
		this.ngayNghi = ngayNghi;
	}
	public int getNgayNghiCoPhep() {
		return ngayNghiCoPhep;
	}
	public void setNgayNghiCoPhep(int ngayNghiCoPhep) {
		this.ngayNghiCoPhep = ngayNghiCoPhep;
	}
	public int getSoGioTangCa() {
		return soGioTangCa;
	}
	public void setSoGioTangCa(int soGioTangCa) {
		this.soGioTangCa = soGioTangCa;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getMaNguoiTao() {
		return maNguoiTao;
	}
	public void setMaNguoiTao(String maNguoiTao) {
		this.maNguoiTao = maNguoiTao;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public PhieuLuongNhanVien(String maPhieuLuong, String thangLuong, String maNguoiHuong, String hoTen,
			String gioiTinh, String chucVu, String donViCongTac, double heSoLuong, int ngayNghi, int ngayNghiCoPhep,
			int soGioTangCa, double thanhTien, String maNguoiTao, Date ngayTao) {
		super();
		this.maPhieuLuong = maPhieuLuong;
		this.thangLuong = thangLuong;
		this.maNguoiHuong = maNguoiHuong;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.donViCongTac = donViCongTac;
		this.heSoLuong = heSoLuong;
		this.ngayNghi = ngayNghi;
		this.ngayNghiCoPhep = ngayNghiCoPhep;
		this.soGioTangCa = soGioTangCa;
		this.thanhTien = thanhTien;
		this.maNguoiTao = maNguoiTao;
		this.ngayTao = ngayTao;
	}
	public PhieuLuongNhanVien(String maPhieuLuong) {
		super();
		this.maPhieuLuong = maPhieuLuong;
	}
	public PhieuLuongNhanVien() {
		super();
	}
	@Override
	public String toString() {
		return "PhieuLuongNhanVien [maPhieuLuong=" + maPhieuLuong + ", thangLuong=" + thangLuong + ", maNguoiHuong="
				+ maNguoiHuong + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", chucVu=" + chucVu
				+ ", donViCongTac=" + donViCongTac + ", heSoLuong=" + heSoLuong + ", ngayNghi=" + ngayNghi
				+ ", ngayNghiCoPhep=" + ngayNghiCoPhep + ", soGioTangCa=" + soGioTangCa + ", thanhTien=" + thanhTien
				+ ", maNguoiTao=" + maNguoiTao + ", ngayTao=" + ngayTao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhieuLuong == null) ? 0 : maPhieuLuong.hashCode());
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
		PhieuLuongNhanVien other = (PhieuLuongNhanVien) obj;
		if (maPhieuLuong == null) {
			if (other.maPhieuLuong != null)
				return false;
		} else if (!maPhieuLuong.equals(other.maPhieuLuong))
			return false;
		return true;
	}
	
	

}
