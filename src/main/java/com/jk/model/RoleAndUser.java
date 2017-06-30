package com.jk.model;

public class RoleAndUser {
	
	private Integer ruId;
	private Integer userId;
	private Integer roleId;
	public Integer getRuId() {
		return ruId;
	}
	public void setRuId(Integer ruId) {
		this.ruId = ruId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "RoleAndUser [ruId=" + ruId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ruId == null) ? 0 : ruId.hashCode());
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
		RoleAndUser other = (RoleAndUser) obj;
		if (ruId == null) {
			if (other.ruId != null)
				return false;
		} else if (!ruId.equals(other.ruId))
			return false;
		return true;
	}
	
	
	
}
