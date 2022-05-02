package entity;

import java.sql.Date;

public class TangCa {
	private String maTangCa;
	private String maNhanVien;
	private Date ngayTangCa;
	private int soGio;
	private String maNguoiTao;
	private Date ngayTao;
	public String getMaTangCa() {
		return maTangCa;
	}
	public void setMaTangCa(String maTangCa) {
		this.maTangCa = maTangCa;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public Date getNgayTangCa() {
		return ngayTangCa;
	}
	public void setNgayTangCa(Date ngayTangCa) {
		this.ngayTangCa = ngayTangCa;
	}
	public int getSoGio() {
		return soGio;
	}
	public void setSoGio(int soGio) {
		this.soGio = soGio;
	}
	
	public TangCa(String maTangCa, String maNhanVien, Date ngayTangCa, int soGio, String maNguoiTao, Date ngayTao) {
		super();
		this.maTangCa = maTangCa;
		this.maNhanVien = maNhanVien;
		this.ngayTangCa = ngayTangCa;
		this.soGio = soGio;
		this.maNguoiTao = maNguoiTao;
		this.ngayTao = ngayTao;
	}
	public TangCa(String maTangCa) {
		super();
		this.maTangCa = maTangCa;
	}
	public TangCa() {
		super();
	}
	
	@Override
	public String toString() {
		return "TangCa [maTangCa=" + maTangCa + ", maNhanVien=" + maNhanVien + ", ngayTangCa=" + ngayTangCa + ", soGio="
				+ soGio + ", maNguoiTao=" + maNguoiTao + ", ngayTao=" + ngayTao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTangCa == null) ? 0 : maTangCa.hashCode());
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
		TangCa other = (TangCa) obj;
		if (maTangCa == null) {
			if (other.maTangCa != null)
				return false;
		} else if (!maTangCa.equals(other.maTangCa))
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
