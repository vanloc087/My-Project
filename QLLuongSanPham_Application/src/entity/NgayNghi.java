package entity;

import java.sql.Date;

public class NgayNghi {
	private String maNgayNghi;
	private String maNhanVien;
	private Date ngayNghi;
	private Date ngayHetNghi;
	private boolean troCap;
	private String lyDo;
	private String maNguoiTao;
	private Date ngayTao;
	
	
	public Date getNgayHetNghi() {
		return ngayHetNghi;
	}
	public void setNgayHetNghi(Date ngayHetNghi) {
		this.ngayHetNghi = ngayHetNghi;
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
	public String getMaNgayNghi() {
		return maNgayNghi;
	}
	public void setMaNgayNghi(String maNgayNghi) {
		this.maNgayNghi = maNgayNghi;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public Date getNgayNghi() {
		return ngayNghi;
	}
	public void setNgayNghi(Date ngayNghi) {
		this.ngayNghi = ngayNghi;
	}
	public boolean isTroCap() {
		return troCap;
	}
	public void setTroCap(boolean troCap) {
		this.troCap = troCap;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
	public NgayNghi(String maNgayNghi, String maNhanVien, Date ngayNghi, Date ngayHetNghi, boolean troCap, String lyDo,
			String maNguoiTao, Date ngayTao) {
		super();
		this.maNgayNghi = maNgayNghi;
		this.maNhanVien = maNhanVien;
		this.ngayNghi = ngayNghi;
		this.ngayHetNghi = ngayHetNghi;
		this.troCap = troCap;
		this.lyDo = lyDo;
		this.maNguoiTao = maNguoiTao;
		this.ngayTao = ngayTao;
	}
	public NgayNghi(String maNgayNghi) {
		super();
		this.maNgayNghi = maNgayNghi;
	}
	public NgayNghi() {
		super();
	}
	
	@Override
	public String toString() {
		return "NgayNghi [maNgayNghi=" + maNgayNghi + ", maNhanVien=" + maNhanVien + ", ngayNghi=" + ngayNghi
				+ ", ngayHetNghi=" + ngayHetNghi + ", troCap=" + troCap + ", lyDo=" + lyDo + ", maNguoiTao="
				+ maNguoiTao + ", ngayTao=" + ngayTao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNgayNghi == null) ? 0 : maNgayNghi.hashCode());
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
		NgayNghi other = (NgayNghi) obj;
		if (maNgayNghi == null) {
			if (other.maNgayNghi != null)
				return false;
		} else if (!maNgayNghi.equals(other.maNgayNghi))
			return false;
		return true;
	}
	

}
