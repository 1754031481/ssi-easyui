package com.jk.model;

import java.io.Serializable;

public class Resources implements Serializable{

	private static final long serialVersionUID = -5947458608885813599L;
	private Integer id;
	private Integer parmentid;
	private String text;
	private String url;
	private String iconCls;
	private String resoType;
	private String resoTest;
	private String resoGoal;
	private String seq;
	private String state="open";
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getResoType() {
		return resoType;
	}
	public void setResoType(String resoType) {
		this.resoType = resoType;
	}
	public String getResoTest() {
		return resoTest;
	}
	public void setResoTest(String resoTest) {
		this.resoTest = resoTest;
	}
	public String getResoGoal() {
		return resoGoal;
	}
	public void setResoGoal(String resoGoal) {
		this.resoGoal = resoGoal;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Resources [id=" + id + ", parmentid=" + parmentid + ", text=" + text + ", url=" + url + ", iconCls="
				+ iconCls + ", resoType=" + resoType + ", resoTest=" + resoTest + ", resoGoal=" + resoGoal + ", seq="
				+ seq + ", state=" + state + "]";
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
		Resources other = (Resources) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
