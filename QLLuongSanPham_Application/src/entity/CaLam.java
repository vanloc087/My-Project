package entity;

import java.sql.Date;

public class CaLam {
	private String maCaLam;
	private String maCongNhan;
	private String maSanPham;
	private int soLuongSP;
	private String loaiCaLam;
	private boolean ngayCN;
	private Date ngayLam;
	private String maNguoiTao;
	private Date ngayTao;
	
	public Date getNgayLam() {
		return ngayLam;
	}
	public void setNgayLam(Date ngayLam) {
		this.ngayLam = ngayLam;
	}
	public String getMaCaLam() {
		return maCaLam;
	}
	public void setMaCaLam(String maCaLam) {
		this.maCaLam = maCaLam;
	}
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getSoLuongSP() {
		return soLuongSP;
	}
	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}
	public String getLoaiCaLam() {
		return loaiCaLam;
	}
	public void setLoaiCaLam(String loaiCaLam) {
		this.loaiCaLam = loaiCaLam;
	}
	public boolean isNgayCN() {
		return ngayCN;
	}
	public void setNgayCN(boolean ngayCN) {
		this.ngayCN = ngayCN;
	}
	
	public CaLam(String maCaLam, String maCongNhan, String maSanPham, int soLuongSP, String loaiCaLam, boolean ngayCN,
			Date ngayLam, String maNguoiTao, Date ngayTao) {
		super();
		this.maCaLam = maCaLam;
		this.maCongNhan = maCongNhan;
		this.maSanPham = maSanPham;
		this.soLuongSP = soLuongSP;
		this.loaiCaLam = loaiCaLam;
		this.ngayCN = ngayCN;
		this.ngayLam = ngayLam;
		this.maNguoiTao = maNguoiTao;
		this.ngayTao = ngayTao;
	}
	
	public CaLam(String maCaLam) {
		super();
		this.maCaLam = maCaLam;
	}
	
	public CaLam() {
		super();
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "CaLam [maCaLam=" + maCaLam + ", maCongNhan=" + maCongNhan + ", maSanPham=" + maSanPham + ", soLuongSP="
				+ soLuongSP + ", loaiCaLam=" + loaiCaLam + ", ngayCN=" + ngayCN + ", ngayLam=" + ngayLam
				+ ", maNguoiTao=" + maNguoiTao + ", ngayTao=" + ngayTao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCaLam == null) ? 0 : maCaLam.hashCode());
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
		CaLam other = (CaLam) obj;
		if (maCaLam == null) {
			if (other.maCaLam != null)
				return false;
		} else if (!maCaLam.equals(other.maCaLam))
			return false;
		return true;
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
	
	

}
