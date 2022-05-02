package entity;

import java.util.Date;

public class HopDong {

	private String maHD;
	private Date ngayTao;
	private Date ngayHetHan;
	private NhanVienHanhChinh NhanVien;
	private KhachHang KhachHang ;
	private SanPham SanPham ;
	private ChiTietHopDong chiTietHD;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public NhanVienHanhChinh getMaNV() {
		return NhanVien;
	}
	public void setMaNV(NhanVienHanhChinh maNV) {
		this.NhanVien = maNV;
	}
	public KhachHang getMaKH() {
		return KhachHang;
	}
	public void setMaKH(KhachHang maKH) {
		this.KhachHang = maKH;
	}
	public SanPham getMaSP() {
		return SanPham;
	}
	public void setMaSP(SanPham maSP) {
		this.SanPham = maSP;
	}
	public ChiTietHopDong getChiTietHD() {
		return chiTietHD;
	}
	public void setChiTietHD(ChiTietHopDong chiTietHD) {
		this.chiTietHD = chiTietHD;
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
		HopDong other = (HopDong) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	public HopDong(String maHD, Date ngayTao, Date ngayHetHan, NhanVienHanhChinh maNV, KhachHang maKH, SanPham maSP) {
		super();
		this.maHD = maHD;
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
		this.NhanVien = maNV;
		this.KhachHang = maKH;
		this.SanPham = maSP;
	}
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDong(String maHD, Date ngayTao, Date ngayHetHan, NhanVienHanhChinh maNV, KhachHang maKH, SanPham maSP,
			ChiTietHopDong chiTietHD) {
		super();
		this.maHD = maHD;
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
		this.NhanVien = maNV;
		this.KhachHang = maKH;
		this.SanPham = maSP;
		this.chiTietHD = chiTietHD;
	}
	public HopDong(String maHD) {
		super();
		this.maHD = maHD;
	}
	@Override
	public String toString() {
		return "HopDong [maHD=" + maHD + ", ngayTao=" + ngayTao + ", ngayHetHan=" + ngayHetHan + ", maNV=" + NhanVien
				+ ", maKH=" + KhachHang + ", maSP=" + SanPham + ", chiTietHD=" + chiTietHD + "]";
	}
	
}
