package com.system.customer;

public class Customer {

	private Integer customerEntryNumber;
	private String customerName;
	private Integer customerBill;
	private String customerFoodItemIds;
	private String customerFoodPurchaseTime;
	private String customerFoodItemNames;
	private Integer customerMemberShipCode;
	private Integer orderId;

	public Customer(Integer customerEntryNumber, String customerName, Integer customerBill, String customerFoodItemIds,
			String customerFoodPurchaseTime, String customerFoodItemNames, Integer customerMemberShip,
			Integer orderId) {
		this.customerEntryNumber = customerEntryNumber;
		this.customerName = customerName;
		this.customerBill = customerBill;
		this.customerFoodItemIds = customerFoodItemIds;
		this.customerFoodPurchaseTime = customerFoodPurchaseTime;
		this.customerFoodItemNames = customerFoodItemNames;
		this.customerMemberShipCode = customerMemberShip;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Customer [Entry Number:" + customerEntryNumber + ", Name:" + customerName
				+ ", Bill:" + customerBill + ", Food Item Ids:[" + customerFoodItemIds
				+ "], Food Purchase Time:" + customerFoodPurchaseTime + ", Food Item Names:["
				+ customerFoodItemNames + "], Member Ship Code:" + customerMemberShipCode + ", Order Id:" + orderId + "]";
	}



	public String toStringCustomer() {
		return "Customer[Entry Number:" + customerEntryNumber + ", Name:" + customerName
				+ ", Bill:" + customerBill 	+ ", Food Purchase Time=" + customerFoodPurchaseTime + 
				", customerFoodItemNames="+ customerFoodItemNames + "]";
	}

	public Customer() {}
	
	public String getCustomerFoodItemNames() {
		return customerFoodItemNames;
	}

	public void setCustomerFoodItemNames(String customerFoodItemNames) {
		this.customerFoodItemNames = customerFoodItemNames;
	}

	public Integer getCustomerEntryNumber() {
		return customerEntryNumber;
	}

	public void setCustomerEntryNumber(Integer customerEntryNumber) {
		this.customerEntryNumber = customerEntryNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerBill() {
		return customerBill;
	}

	public void setCustomerBill(Integer customerBill) {
		this.customerBill = customerBill;
	}

	public String getCustomerFoodItemIds() {
		return customerFoodItemIds;
	}

	public void setCustomerFoodItemIds(String customerFoodItemIds) {
		this.customerFoodItemIds = customerFoodItemIds;
	}

	public String getCustomerFoodPurchaseTime() {
		return customerFoodPurchaseTime;
	}

	public void setCustomerFoodPurchaseTime(String customerFoodPurchaseTime) {
		this.customerFoodPurchaseTime = customerFoodPurchaseTime;
	}

	public Integer getCustomerMemberShip() {
		return customerMemberShipCode;
	}

	public void setCustomerMemberShip(Integer customerMemberShip) {
		this.customerMemberShipCode = customerMemberShip;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}