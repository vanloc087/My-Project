package entity;

import java.sql.Date;

public class PhieuLuongCongNhan {
	private String maPhieuLuong;
	private String thangLuong;
	private String maNguoiHuong;
	private String hoTen;
	private String gioiTinh;
	private int soSanPham;
	private int soSanPhamCa3;
	private int soSanPhamNgayCN;
	private Double donGia;
	private Double thanhTien;
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
	public int getSoSanPham() {
		return soSanPham;
	}
	public void setSoSanPham(int soSanPham) {
		this.soSanPham = soSanPham;
	}
	public int getSoSanPhamCa3() {
		return soSanPhamCa3;
	}
	public void setSoSanPhamCa3(int soSanPhamCa3) {
		this.soSanPhamCa3 = soSanPhamCa3;
	}
	public int getSoSanPhamNgayCN() {
		return soSanPhamNgayCN;
	}
	public void setSoSanPhamNgayCN(int soSanPhamNgayCN) {
		this.soSanPhamNgayCN = soSanPhamNgayCN;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
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
	public PhieuLuongCongNhan(String maPhieuLuong, String thangLuong, String maNguoiHuong, String hoTen,
			String gioiTinh, int soSanPham, int soSanPhamCa3, int soSanPhamNgayCN, Double donGia, Double thanhTien,
			String maNguoiTao, Date ngayTao) {
		super();
		this.maPhieuLuong = maPhieuLuong;
		this.thangLuong = thangLuong;
		this.maNguoiHuong = maNguoiHuong;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soSanPham = soSanPham;
		this.soSanPhamCa3 = soSanPhamCa3;
		this.soSanPhamNgayCN = soSanPhamNgayCN;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.maNguoiTao = maNguoiTao;
		this.ngayTao = ngayTao;
	}
	public PhieuLuongCongNhan(String maPhieuLuong) {
		super();
		this.maPhieuLuong = maPhieuLuong;
	}
	public PhieuLuongCongNhan() {
		super();
	}
	
	
	
	public PhieuLuongCongNhan(int soSanPham) {
		super();
		this.soSanPham = soSanPham;
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
		PhieuLuongCongNhan other = (PhieuLuongCongNhan) obj;
		if (maPhieuLuong == null) {
			if (other.maPhieuLuong != null)
				return false;
		} else if (!maPhieuLuong.equals(other.maPhieuLuong))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PhieuLuongCongNhan [maPhieuLuong=" + maPhieuLuong + ", thangLuong=" + thangLuong + ", maNguoiHuong="
				+ maNguoiHuong + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", soSanPham=" + soSanPham
				+ ", soSanPhamCa3=" + soSanPhamCa3 + ", soSanPhamNgayCN=" + soSanPhamNgayCN + ", donGia=" + donGia
				+ ", thanhTien=" + thanhTien + ", maNguoiTao=" + maNguoiTao + ", ngayTao=" + ngayTao + "]";
	}
	
	
	
	

}
