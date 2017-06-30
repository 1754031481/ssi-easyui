package com.jk.util;

import java.util.List;

public class Page {

	private int cpage = 1;
	
	private int pageSize = 3;
	
	private Long totalCount=0l;
	
	private int totalPage;
	
	private int start;
	
	private List list;
	
	private String total;
	
	private String rows;
	

	public  Page(Long totalCount,int cpage,int pageSize){
		
		if(totalCount>0){
			this.totalCount=totalCount;
			this.totalPage=(int) (this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize + 1);
//		if(this.totalCount%this.pageSize==0){
//			this.totalPage=this.totalCount/this.pageSize;
//		}else{
//			
//		}
		}
		
		if(cpage>0  && cpage<=this.totalPage){
			this.cpage=cpage;
		}
		if(pageSize>0){
			this.pageSize=pageSize;
		}
		this.start=(this.cpage - 1)*this.pageSize;
	}
	
	
	
	
	
	
	//================================================================================================
	
	
	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}






	public Page() {
		super();
	}






	public String getTotal() {
		return total;
	}






	public void setTotal(String total) {
		this.total = total;
	}






	public String getRows() {
		return rows;
	}






	public void setRows(String rows) {
		this.rows = rows;
	}
	
	
	
	
	
}
