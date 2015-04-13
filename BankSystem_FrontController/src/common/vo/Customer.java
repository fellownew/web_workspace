package common.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	private String id,password,name;
	private ArrayList<Account> account;
	private int creditRating; //신용등급
	private String job;
	private int age;
	private boolean sex;
	private String phoneNumber,address;
	public Customer(String id, String password, String name,ArrayList<Account> account, int creditRating, String job, int age,
			boolean sex, String phoneNumber, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.account = account;
		this.creditRating = creditRating;
		this.job = job;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public Customer(String id, String password, String name, int creditRating, String job, int age,boolean sex, String phoneNumber, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.creditRating = creditRating;
		this.job = job;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public Customer(String id, String password, String name, String job,
			int age, boolean sex, String phoneNumber, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.job = job;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public Customer(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Account> getAccount() {
		return account;
	}
	public void setAccount(ArrayList<Account> account) {
		this.account = account;
	}
	public int getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + creditRating;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + (sex ? 1231 : 1237);
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
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (creditRating != other.creditRating)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", password=" + password + ", name="+ name + ", account=" + account + ", creditRating="
				+ creditRating + ", job=" + job + ", age=" + age + ", sex="+ sex + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ "]";
	}

}
