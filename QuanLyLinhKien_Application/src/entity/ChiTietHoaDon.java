package entity;

public class ChiTietHoaDon {
	private HoaDon maHoadon;
	private LinhKien maLinhKien;
	private double giaBan;
	private int soluong;
	
	
	public ChiTietHoaDon(HoaDon maHoadon) {
		super();
		this.maHoadon = maHoadon;
	}
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HoaDon maHoadon, LinhKien maLK, double giaBan, int soluong) {
		super();
		this.maHoadon = maHoadon;
		this.maLinhKien = maLK;
		this.giaBan = giaBan;
		this.soluong = soluong;
	}
	
	public HoaDon getMaHoadon() {
		return maHoadon;
	}
	public void setMaHoadon(HoaDon maHoadon) {
		this.maHoadon = maHoadon;
	}
	public LinhKien getMaLinhKien() {
		return maLinhKien;
	}
	public void setMaLinhKien(LinhKien maLinhKien) {
		this.maLinhKien = maLinhKien;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoadon == null) ? 0 : maHoadon.hashCode());
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
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		if (maHoadon == null) {
			if (other.maHoadon != null)
				return false;
		} else if (!maHoadon.equals(other.maHoadon))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoadon=" + maHoadon + ", maLinhKien=" + maLinhKien + ", giaBan=" + giaBan
				+ ", soluong=" + soluong + "]";
	}
	
	
}
