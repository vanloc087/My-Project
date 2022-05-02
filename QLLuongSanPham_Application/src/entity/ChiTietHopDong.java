package entity;

public class ChiTietHopDong {

	private HopDong maHD;
	private String tenHD;
	private int soLuongSP;
	private double giaTriHD;
	private boolean thanhToan;
	public HopDong getMaHD() {
		return maHD;
	}
	public void setMaHD(HopDong maHD) {
		this.maHD = maHD;
	}
	public String getTenHD() {
		return tenHD;
	}
	public void setTenHD(String tenHD) {
		this.tenHD = tenHD;
	}
	public int getSoLuongSP() {
		return soLuongSP;
	}
	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}
	public double getGiaTriHD() {
		return giaTriHD;
	}
	public void setGiaTriHD(double giaTriHD) {
		this.giaTriHD = giaTriHD;
	}
	public boolean isThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(boolean thanhToan) {
		this.thanhToan = thanhToan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
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
		ChiTietHopDong other = (ChiTietHopDong) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	public ChiTietHopDong(HopDong maHD, String tenHD, int soLuongSP, double giaTriHD, boolean thanhToan) {
		super();
		this.maHD = maHD;
		this.tenHD = tenHD;
		this.soLuongSP = soLuongSP;
		this.giaTriHD = giaTriHD;
		this.thanhToan = thanhToan;
	}
	public ChiTietHopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietHopDong(HopDong maHD) {
		super();
		this.maHD = maHD;
	}
	@Override
	public String toString() {
		return "Mã hợp đồng: " + maHD.getMaHD() + "\n  Tên hợp đồng: " + tenHD + "\n  Số lượng sản phẩm: " + soLuongSP + "\n  Giá trị hợp đồng: "
				+ (long)giaTriHD + "\n  Tình trạng thanh toán: " + (isThanhToan()?"Đã thanh toán":"Chưa thanh toán");
	}
	
	
}
