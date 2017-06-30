package com.jk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Mechanism implements Serializable{

	private static final long serialVersionUID = 6712921019086345556L;
	
	private Integer id;
	private Integer parmentid;
	private String address;
	private String code;
	private String iconCls;
	private String name;
	private String seq;
	private Date createdatetime; 
	private Date updatetime;
	private String state="open";
	private Set<Mechanism> children=new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParmentid() {
		return parmentid;
	}
	public void setParmentid(Integer parmentid) {
		this.parmentid = parmentid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<Mechanism> getChildren() {
		return children;
	}
	public void setChildren(Set<Mechanism> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Mechanism [id=" + id + ", parmentid=" + parmentid + ", address=" + address + ", code=" + code
				+ ", iconCls=" + iconCls + ", name=" + name + ", seq=" + seq + ", createdatetime=" + createdatetime
				+ ", updatetime=" + updatetime + ", state=" + state + ", children=" + children + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Mechanism other = (Mechanism) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
