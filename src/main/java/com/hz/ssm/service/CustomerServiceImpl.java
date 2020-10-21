package com.hz.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hz.ssm.dao.CustomerMapper;
import com.hz.ssm.pojo.Customer;
import com.hz.ssm.pojo.CustomerExample;
import com.hz.ssm.pojo.CustomerExample.Criteria;
import com.hz.ssm.utils.PageBean;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public PageBean<Customer> findCustomerInfoByPage(Integer indexpage) {
		//默认首页
		if (indexpage == null) {
			indexpage = 1;
		}
		
		//pagehelper分页初始化
		PageHelper.startPage(indexpage, 5);
		
		//获得当前页的数据
		CustomerExample example = new CustomerExample();
		Criteria criteria =  example.createCriteria();
		List<Customer>  customerList =  customerMapper.selectByExample(example);
		//把数据封装到pageInfo中
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(customerList);
		//封装到自动包装类中
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setIndexpage(indexpage);
		pageBean.setPageSize(pageInfo.getPageSize());
		pageBean.setCountRows(pageInfo.getTotal());
		
		//封装显示的数据
		pageBean.setDataList(customerList);
		
		return pageBean;
	}

	@Override
	public int addCustomerInfo(Customer customer) {
		
		return customerMapper.insertSelective(customer);
	}

	@Override
	public int delCustById(Long custId) {
	
		return customerMapper.deleteByPrimaryKey(custId);
	}
	
	
	
	
	
}
