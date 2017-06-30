package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <zjb>项目名称：ssi-renrenwang    
 * 类名称：Role    
 * 类描述：角色表    
 * 创建人：赵俊彪   
 * 创建时间：2017年5月24日 下午8:56:18    
 * 修改人：	赵俊彪     
 * 修改时间：2017年5月24日 下午8:56:18    
 * 修改备注：       
 * @version </pre>
 */
public class Role implements Serializable{

	private static final long serialVersionUID = -1855018930148480290L;
	
	private Integer id;
	private Date createdatetime;
	private Date updatedatetime;
	private String name;
	private String description;
	private String iconCls;
	private Integer seq;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", createdatetime=" + createdatetime + ", updatedatetime=" + updatedatetime
				+ ", name=" + name + ", description=" + description + ", iconCls=" + iconCls + ", seq=" + seq + "]";
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	

}
