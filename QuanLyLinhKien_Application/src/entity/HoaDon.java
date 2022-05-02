package entity;

import java.util.Date;

public class HoaDon {
	    private String maHoaDon;
	    private Date ngayTao;
	    private KhachHang maKhachHang;
	    private NhanVien maNhanVien;
	    private String noiNhan;
	    private double tongtien;
			
	    
	    
		public HoaDon() {
			super();
		}
		public HoaDon(String maHoaDon) {
			super();
			this.maHoaDon = maHoaDon;
		}
		public HoaDon(String maHoaDon, Date ngayTao, KhachHang maKhachHang, NhanVien maNhanVien, String noiNhan, double tongtien) {
			super();
			this.maHoaDon = maHoaDon;
			this.ngayTao = ngayTao;
			this.maKhachHang = maKhachHang;
			this.maNhanVien = maNhanVien;
			this.noiNhan = noiNhan;
			this.tongtien = tongtien;
		}
		public String getMaHoaDon() {
			return maHoaDon;
		}
		public void setMaHoaDon(String maHoaDon) {
			this.maHoaDon = maHoaDon;
		}
		public Date getNgayTao() {
			return ngayTao;
		}
		public void setNgayTao(Date ngayTao) {
			this.ngayTao = ngayTao;
		}
		public KhachHang getMaKhachHang() {
			return maKhachHang;
		}
		public void setMaKhachHang(KhachHang maKhachHang) {
			this.maKhachHang = maKhachHang;
		}
		public NhanVien getMaNhanVien() {
			return maNhanVien;
		}
		public void setMaNhanVien(NhanVien maNhanVien) {
			this.maNhanVien = maNhanVien;
		}
		public String getNoiNhan() {
			return noiNhan;
		}
		public void setNoiNhan(String noiNhan) {
			this.noiNhan = noiNhan;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
			HoaDon other = (HoaDon) obj;
			if (maHoaDon == null) {
				if (other.maHoaDon != null)
					return false;
			} else if (!maHoaDon.equals(other.maHoaDon))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "HoaDon [maHoaDon=" + maHoaDon + ", ngayTao=" + ngayTao + ", maKhachHang=" + maKhachHang
					+ ", maNhanVien=" + maNhanVien + ", noiNhan=" + noiNhan + "]";
		}
		public double getTongtien() {
			return tongtien;
		}
		public void setTongtien(double tongtien) {
			this.tongtien = tongtien;
		}
		
}
