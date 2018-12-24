package com.ethan.cstm.domain;

import java.util.List;

public class PageBean<T> {
	private int pageCode;
//	private int totalPages;
	private int totalRecord;
	private int pageSize;
	private List<T> beanList; //当前页记录的数据
	
	private String url;
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getTotalPages() {
		int totalPages = totalRecord / pageSize;
		return totalRecord % pageSize == 0 ? totalPages : totalPages + 1;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanList == null) ? 0 : beanList.hashCode());
		result = prime * result + pageCode;
		result = prime * result + pageSize;
		result = prime * result + totalRecord;
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
		PageBean other = (PageBean) obj;
		if (beanList == null) {
			if (other.beanList != null)
				return false;
		} else if (!beanList.equals(other.beanList))
			return false;
		if (pageCode != other.pageCode)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (totalRecord != other.totalRecord)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageBean [pageCode=" + pageCode + ", totalRecord=" + totalRecord
				+ ", pageSize=" + pageSize + ", beanList=" + beanList + "]";
	}
	
	
}
