package entity;

public class TaiKhoan {
	private String maTK;
	private String maNguoiDung;
	private String matKhau;
	
	
	public TaiKhoan(String maTK) {
		super();
		this.maTK = maTK;
	}
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String maTK, String maNguoiDung, String matKhau) {
		super();
		this.maTK = maTK;
		this.maNguoiDung = maNguoiDung;
		this.matKhau = matKhau;
	}
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTK == null) ? 0 : maTK.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maTK == null) {
			if (other.maTK != null)
				return false;
		} else if (!maTK.equals(other.maTK))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", maNguoiDung=" + maNguoiDung + ", matKhau=" + matKhau + "]";
	}
	
	
}
