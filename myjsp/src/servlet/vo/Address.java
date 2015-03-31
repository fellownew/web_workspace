package servlet.vo;

import java.io.Serializable;

public class Address implements Serializable{
	private String ID,zipcode,addressDetail;
	public Address(){}
	public Address(String iD, String zipcode, String addressDetail) {
		super();
		ID = iD;
		this.zipcode = zipcode;
		this.addressDetail = addressDetail;
	}
	//Attribute(Instatnce변수) 이름이 모두 대문자인 경우 : set/get + 변수명 그대로.
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result
				+ ((addressDetail == null) ? 0 : addressDetail.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Address other = (Address) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (addressDetail == null) {
			if (other.addressDetail != null)
				return false;
		} else if (!addressDetail.equals(other.addressDetail))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "식별번호=" + ID + ",  우편번호=" + zipcode+ ", 상세 주소=" + addressDetail;
	}
	
}
