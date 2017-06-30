package com.jk.model;

import java.io.Serializable;

/** 
 * <zjb>项目名称：ssi-renrenwang    
 * 类名称：Tree    
 * 类描述：    树的model
 * @version </pre>    
 */
public class Tree implements Serializable{
	private static final long serialVersionUID = 3302784771083257053L;
	
	 	private Integer menuId;
	    private String menuTitle;
	    private String menuUrl;
	    private String menuIcon;
	    private Integer parentId;
		public Integer getMenuId() {
			return menuId;
		}
		public void setMenuId(Integer menuId) {
			this.menuId = menuId;
		}
		public String getMenuTitle() {
			return menuTitle;
		}
		public void setMenuTitle(String menuTitle) {
			this.menuTitle = menuTitle;
		}
		public String getMenuUrl() {
			return menuUrl;
		}
		public void setMenuUrl(String menuUrl) {
			this.menuUrl = menuUrl;
		}
		public String getMenuIcon() {
			return menuIcon;
		}
		public void setMenuIcon(String menuIcon) {
			this.menuIcon = menuIcon;
		}
		public Integer getParentId() {
			return parentId;
		}
		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}
		@Override
		public String toString() {
			return "Tree [menuId=" + menuId + ", menuTitle=" + menuTitle + ", menuUrl=" + menuUrl + ", menuIcon="
					+ menuIcon + ", parentId=" + parentId + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
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
			Tree other = (Tree) obj;
			if (menuId == null) {
				if (other.menuId != null)
					return false;
			} else if (!menuId.equals(other.menuId))
				return false;
			return true;
		}
	    
	    
	
	
}
