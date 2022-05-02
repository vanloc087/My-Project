package entity;

import java.sql.Date;

public class BangLuongCongTy {
	private String maBangLuong;
	private String thangLuong;
	private double tongLuongCongTy;
	private double tongLuongNhanVien;
	private double tongLuongCongNhan;
	private int tongSanPham;
	private int tongSoGioTangCa;
	private String maNguoiTao;
	private Date ngayTao;
	public String getMaBangLuong() {
		return maBangLuong;
	}
	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}
	public String getThangLuong() {
		return thangLuong;
	}
	public void setThangLuong(String thangLuong) {
		this.thangLuong = thangLuong;
	}
	public double getTongLuongCongTy() {
		return tongLuongCongTy;
	}
	public void setTongLuongCongTy(double tongLuongCongTy) {
		this.tongLuongCongTy = tongLuongCongTy;
	}
	public double getTongLuongNhanVien() {
		return tongLuongNhanVien;
	}
	public void setTongLuongNhanVien(double tongLuongNhanVien) {
		this.tongLuongNhanVien = tongLuongNhanVien;
	}
	public double getTongLuongCongNhan() {
		return tongLuongCongNhan;
	}
	public void setTongLuongCongNhan(double tongLuongCongNhan) {
		this.tongLuongCongNhan = tongLuongCongNhan;
	}
	public int getTongSanPham() {
		return tongSanPham;
	}
	public void setTongSanPham(int tongSanPham) {
		this.tongSanPham = tongSanPham;
	}
	public int getTongSoGioTangCa() {
		return tongSoGioTangCa;
	}
	public void setTongSoGioTangCa(int tongSoGioTangCa) {
		this.tongSoGioTangCa = tongSoGioTangCa;
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
	public BangLuongCongTy(String maBangLuong, String thangLuong, double tongLuongCongTy, double tongLuongNhanVien,
			double tongLuongCongNhan, int tongSanPham, int tongSoGioTangCa, String maNguoiTao, Date ngayTao) {
		super();
		this.maBangLuong = maBangLuong;
		this.thangLuong = thangLuong;
		this.tongLuongCongTy = tongLuongCongTy;
		this.tongLuongNhanVien = tongLuongNhanVien;
		this.tongLuongCongNhan = tongLuongCongNhan;
		this.tongSanPham = tongSanPham;
		this.tongSoGioTangCa = tongSoGioTangCa;
		this.maNguoiTao = maNguoiTao;
		this.ngayTao = ngayTao;
	}
	public BangLuongCongTy(String maBangLuong) {
		super();
		this.maBangLuong = maBangLuong;
	}
	public BangLuongCongTy() {
		super();
	}
	@Override
	public String toString() {
		return "BangLuongCongTy [maBangLuong=" + maBangLuong + ", thangLuong=" + thangLuong + ", tongLuongCongTy="
				+ tongLuongCongTy + ", tongLuongNhanVien=" + tongLuongNhanVien + ", tongLuongCongNhan="
				+ tongLuongCongNhan + ", tongSanPham=" + tongSanPham + ", tongSoGioTangCa=" + tongSoGioTangCa
				+ ", maNguoiTao=" + maNguoiTao + ", ngayTao=" + ngayTao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maBangLuong == null) ? 0 : maBangLuong.hashCode());
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
		BangLuongCongTy other = (BangLuongCongTy) obj;
		if (maBangLuong == null) {
			if (other.maBangLuong != null)
				return false;
		} else if (!maBangLuong.equals(other.maBangLuong))
			return false;
		return true;
	}
	
	
	

}
