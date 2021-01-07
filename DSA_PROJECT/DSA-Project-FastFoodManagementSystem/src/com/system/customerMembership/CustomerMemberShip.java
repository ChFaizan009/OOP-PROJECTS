package com.system.customerMembership;

public class CustomerMemberShip {
	private int memberShipID;
	private Integer memberShipCode;
	private String memberShipName;
	private String memberShipStartDate;
	private String memberShipEndDate;
	private MemberShipType memberShipType;
	private boolean isActive;
	
	public CustomerMemberShip() {}
	
	public CustomerMemberShip(int memberShipID, String memberShipName, Integer memberShipCode, String memberShipStartDate,
			String memberShipEndDate, MemberShipType memberShipType, boolean isActive) {
		super();
		this.memberShipID = memberShipID;
		this.memberShipName = memberShipName;
		this.memberShipCode = memberShipCode;
		this.memberShipStartDate = memberShipStartDate;
		this.memberShipEndDate = memberShipEndDate;
		this.memberShipType = memberShipType;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "[ Customer Member Ship Code:" + memberShipCode
				+ ", Custome Name:" + memberShipName 
				+ ", Member Ship Type=" + memberShipType
				+ ", Member Ship Start Date:" + memberShipStartDate
				+ ", Member Ship End Date:" + memberShipEndDate 
				+ ", Is Account Active?: "+( isActive==true ? "Account is Active" : "Account Not Active")+"]";
	}

	public int getMemberShipID() {
		return memberShipID;
	}

	public void setMemberShipID(int memberShipID) {
		this.memberShipID = memberShipID;
	}

	public String getMemberShipName() {
		return memberShipName;
	}

	public void setMemberShipName(String memberShipName) {
		this.memberShipName = memberShipName;
	}

	public Integer getMemberShipCode() {
		return memberShipCode;
	}

	public void setMemberShipCode(Integer memberShipCode) {
		this.memberShipCode = memberShipCode;
	}

	public String getMemberShipStartDate() {
		return memberShipStartDate;
	}

	public void setMemberShipStartDate(String memberShipStartDate) {
		this.memberShipStartDate = memberShipStartDate;
	}

	public String getMemberShipEndDate() {
		return memberShipEndDate;
	}

	public void setMemberShipEndDate(String memberShipEndDate) {
		this.memberShipEndDate = memberShipEndDate;
	}

	public MemberShipType getMemberShipType() {
		return memberShipType;
	}

	public void setMemberShipType(MemberShipType memberShipType) {
		this.memberShipType = memberShipType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
