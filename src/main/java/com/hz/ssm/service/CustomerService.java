package com.hz.ssm.service;

import com.hz.ssm.pojo.Customer;
import com.hz.ssm.utils.PageBean;

public interface CustomerService {
	
	/**
	 * 查询custoemr信息并分页显示
	 * @param indexpage
	 * @return
	 */
	public PageBean<Customer> findCustomerInfoByPage(Integer indexpage);

	/**
	 * 添加客户信息
	 * @param customer
	 * @return
	 */
	public int addCustomerInfo(Customer customer);

	/**
	 * 根据主键id的删除方法
	 * @param custId
	 * @return
	 */
	public int delCustById(Long custId);

}
