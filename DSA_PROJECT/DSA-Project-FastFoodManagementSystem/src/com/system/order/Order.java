package com.system.order;

public class Order {

	private Integer orderId;
	private String orderStartTime;
	private String orderEndTime;
	private String orderDileveryTime;
	private Integer customerEntryNumber;
	private Integer customerMemberShipCode;
	
	public Order() {}
	
	public Order(Integer orderId, String orderStartTime, String orderEndTime, String orderDileveryTime, Integer customerEntryNumber,
			Integer customerMemberShipCode) {
		this.orderId = orderId;
		this.orderStartTime = orderStartTime;
		this.orderEndTime = orderEndTime;
		this.orderDileveryTime = orderDileveryTime;
		this.customerEntryNumber = customerEntryNumber;
		this.customerMemberShipCode = customerMemberShipCode;
	}

	@Override
	public String toString() {
		return "Order[Order Id:" + orderId + ", Start Time:" + orderStartTime + ", End Time:" + orderEndTime
				+ ", Dilevery Time:" + orderDileveryTime+ " Customer Entry Number:"+customerEntryNumber+"]";
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStartTime() {
		return orderStartTime;
	}
	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	public String getOrderEndTime() {
		return orderEndTime;
	}
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	public Integer getCustomerEntryNumber() {
		return customerEntryNumber;
	}
	public void setCustomerEntryNumber(Integer customerEntryNumber) {
		this.customerEntryNumber = customerEntryNumber;
	}
	public Integer getCustomerMemberShipCode() {
		return customerMemberShipCode;
	}
	public void setCustomerMemberShipCode(Integer customerMemberShipCode) {
		this.customerMemberShipCode = customerMemberShipCode;
	}
	public String getOrderDileveryTime() {
		return orderDileveryTime;
	}
	public void setOrderDileveryTime(String orderDileveryTime) {
		this.orderDileveryTime = orderDileveryTime;
	}
}
