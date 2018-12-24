package cn.ethan.model;

public class Customer {
	private Integer cid;
	private String custName;
	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer cid, String custName, String custLevel, String custSource, String custPhone,
			String custMobile) {
		super();
		this.cid = cid;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((custLevel == null) ? 0 : custLevel.hashCode());
		result = prime * result + ((custMobile == null) ? 0 : custMobile.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custPhone == null) ? 0 : custPhone.hashCode());
		result = prime * result + ((custSource == null) ? 0 : custSource.hashCode());
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
		Customer other = (Customer) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (custLevel == null) {
			if (other.custLevel != null)
				return false;
		} else if (!custLevel.equals(other.custLevel))
			return false;
		if (custMobile == null) {
			if (other.custMobile != null)
				return false;
		} else if (!custMobile.equals(other.custMobile))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custPhone == null) {
			if (other.custPhone != null)
				return false;
		} else if (!custPhone.equals(other.custPhone))
			return false;
		if (custSource == null) {
			if (other.custSource != null)
				return false;
		} else if (!custSource.equals(other.custSource))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", custName=" + custName + ", custLevel=" + custLevel + ", custSource="
				+ custSource + ", custPhone=" + custPhone + ", custMobile=" + custMobile + "]";
	}
	
	
}
