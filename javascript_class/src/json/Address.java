package json;

import java.io.Serializable;

public class Address implements Serializable{
	private String zipcode;
	private String addressDetail;
	public Address(){}
	public Address(String zipcode, String addressDetail) {
		this.zipcode = zipcode;
		this.addressDetail = addressDetail;
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
		return "Address [zipcode=" + zipcode + ", addressDetail="
				+ addressDetail + "]";
	}
	
}
