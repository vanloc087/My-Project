package entity;

public class SanPham {
	private String maSP;
	private String tenSP;
	private int soLuongSP;
	private double donGiaSP;
	private LoaiSanPham loaiSP;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuongSP() {
		return soLuongSP;
	}
	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}
	public double getDonGiaSP() {
		return donGiaSP;
	}
	public void setDonGiaSP(double donGiaSP) {
		this.donGiaSP = donGiaSP;
	}
	public LoaiSanPham getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(LoaiSanPham loaiSP) {
		this.loaiSP = loaiSP;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
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
		SanPham other = (SanPham) obj;
		if (maSP == null) {
			if (other.maSP != null)
				return false;
		} else if (!maSP.equals(other.maSP))
			return false;
		return true;
	}
	public SanPham(String maSP, String tenSP, int soLuongSP, double donGiaSP, LoaiSanPham loaiSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuongSP = soLuongSP;
		this.donGiaSP = donGiaSP;
		this.loaiSP = loaiSP;
	}
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", soLuongSP=" + soLuongSP + ", donGiaSP=" + donGiaSP
				+ ", loaiSP=" + loaiSP + "]";
	}
	
}
