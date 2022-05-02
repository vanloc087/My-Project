package entity;


public class LinhKien {
	private String maLinhKien;
	private String tenLinhKien;
	private LoaiLinhKien maLoaiLK;
	private int soLuong;
	private double donGia;
	private NhaCungCap maNCC;
	
	
	
	public LinhKien(String maLinhKien) {
		super();
		this.maLinhKien = maLinhKien;
	}
	public LinhKien() {
		super();
	}
	
	public LinhKien(String maLinhKien, String tenLinhKien, LoaiLinhKien maLoaiLK, int soLuong, double donGia,
			NhaCungCap maNCC) {
		super();
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.maLoaiLK = maLoaiLK;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maNCC = maNCC;
	}
	
	public String getMaLinhKien() {
		return maLinhKien;
	}
	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}
	public String getTenLinhKien() {
		return tenLinhKien;
	}
	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public LoaiLinhKien getMaLoaiLK() {
		return maLoaiLK;
	}
	public void setMaLoaiLK(LoaiLinhKien maLoaiLK) {
		this.maLoaiLK = maLoaiLK;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public NhaCungCap getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLinhKien == null) ? 0 : maLinhKien.hashCode());
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
		LinhKien other = (LinhKien) obj;
		if (maLinhKien == null) {
			if (other.maLinhKien != null)
				return false;
		} else if (!maLinhKien.equals(other.maLinhKien))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LinhKien [maLinhKien=" + maLinhKien + ", tenLinhKien=" + tenLinhKien + ", maLoaiLK=" + maLoaiLK
				+ ", soLuong=" + soLuong + ", donGia=" + donGia + ", maNCC=" + maNCC + "]";
	}
	
	
}
