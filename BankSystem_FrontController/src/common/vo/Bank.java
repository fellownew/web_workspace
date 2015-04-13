package common.vo;

import java.io.Serializable;

public class Bank implements Serializable{
	private long amount;

	public Bank(long amount) {
		//TODO DB�κ��� ���� �� �ҷ�����.
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "은행 잔고 : " + amount;
	}

	public long getAmount() {
		return amount;
	}

	public void reduceAmount(int money) {
		amount -=money;;
	}
	
	public void addAmount(int money){
		amount += money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
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
		Bank other = (Bank) obj;
		if (amount != other.amount)
			return false;
		return true;
	}
	
	
	
}
