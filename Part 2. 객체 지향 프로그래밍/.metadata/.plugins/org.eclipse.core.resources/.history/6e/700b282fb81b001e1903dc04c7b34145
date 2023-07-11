package ch04;

public class VIPCustomer extends Customer {
	
	private String agentId;
	double saleRatio;
	
	public VIPCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		bonusRatio = 0.05;
		saleRatio = 0.1;
		customerGrade = "VIP";
	}

	public String getAgentId() {
		return agentId;
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		price -= (int)(price * saleRatio);
		return super.calcPrice(price);
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

}
