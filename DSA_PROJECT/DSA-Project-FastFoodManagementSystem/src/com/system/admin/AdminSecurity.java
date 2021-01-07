package com.system.admin;

public class AdminSecurity {
	
	private Integer adminId;
	private String adminUserName;
	private String adminPassWord;
	
	@Override
	public String toString() {
		return "AdminSecurity [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassWord="
				+ adminPassWord + "]";
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassWord() {
		return adminPassWord;
	}

	public void setAdminPassWord(String adminPassWord) {
		this.adminPassWord = adminPassWord;
	}
	
}
