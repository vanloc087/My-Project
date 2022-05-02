package entity;

public class LoaiLinhKien {
	private String maLoaiLK;
	private String tenLoaiLK;
	
	
	public LoaiLinhKien(String maLoaiLK) {
		super();
		this.maLoaiLK = maLoaiLK;
	}
	public LoaiLinhKien() {
		super();
	}
	public LoaiLinhKien(String maLoaiLK, String tenLoaiLK) {
		super();
		this.maLoaiLK = maLoaiLK;
		this.tenLoaiLK = tenLoaiLK;
	}
	public String getMaLoaiLK() {
		return maLoaiLK;
	}
	public void setMaLoaiLK(String maLoaiLK) {
		this.maLoaiLK = maLoaiLK;
	}
	public String getTenLoaiLK() {
		return tenLoaiLK;
	}
	public void setTenLoaiLK(String tenLoaiLK) {
		this.tenLoaiLK = tenLoaiLK;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiLK == null) ? 0 : maLoaiLK.hashCode());
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
		LoaiLinhKien other = (LoaiLinhKien) obj;
		if (maLoaiLK == null) {
			if (other.maLoaiLK != null)
				return false;
		} else if (!maLoaiLK.equals(other.maLoaiLK))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoaiLinhKien [maLoaiLK=" + maLoaiLK + ", tenLoaiLK=" + tenLoaiLK + "]";
	}
	
	
}
