package com.hz.ssm.utils;

import java.util.List;
/**
 * 封装分页参数的工具类
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T> {
	
	private Integer indexpage;  //当前页   2
	
	private Integer pageSize;  //每页大小 5
	
	private Integer  beginRows;  //起始行
	
	private Long countRows;  //总记录数  select count(1) from  当前表
	
	private Integer totalPage;  //总页码
	
	private List<T>  dataList;  //保存每页的数据

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public Integer getIndexpage() {
		return indexpage;
	}

	public void setIndexpage(Integer indexpage) {
		this.indexpage = indexpage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	//自动获取起始行
	public Integer getBeginRows() {
		
		
		return (getIndexpage() -1)*getPageSize();
	}


	public Long getCountRows() {
		return countRows;
	}

	public void setCountRows(Long countRows) {
		this.countRows = countRows;
	}

	//自动获取总页码
	public Integer getTotalPage() {
		
		
		return (int) ((getCountRows()%getPageSize()==0)?getCountRows()/getPageSize():getCountRows()/getPageSize()+1);
	}

	
	
	
}
