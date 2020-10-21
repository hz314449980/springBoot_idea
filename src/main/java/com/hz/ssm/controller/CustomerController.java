package com.hz.ssm.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hz.ssm.pojo.Customer;
import com.hz.ssm.service.CustomerService;
import com.hz.ssm.utils.PageBean;
import com.hz.ssm.utils.StringUtils;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 查询并分页显示
	 * @param indexpage
	 * @return
	 */
	@RequestMapping("/findCustomerInfoByPage")
	public PageBean<Customer>  findCustomerInfoByPage(Integer indexpage){
		PageBean<Customer> pageBean = customerService.findCustomerInfoByPage(indexpage);
		
		
		return pageBean;
	}
	/**
	 * 添加客户信息
	 * @param customer
	 * @return
	 */
	@PostMapping("/addCustomerInfo")//注意这个MultipartFile对应的变量名称必须和表单中的name属性值一致
	public ModelAndView addCustomerInfo(MultipartFile picFile,Customer customer){
		
		
		
		ModelAndView mvAndView = new ModelAndView();
		//获取文件名
		String picName = picFile.getOriginalFilename();
		
		
		if (org.apache.commons.lang3.StringUtils.isNotBlank(picName)) {
			//给文件重命名
			String newPicName = StringUtils.subStringName(picName);
			
			File file = new File("D:\\image\\"+newPicName);
			
			customer.setPicFilepath(newPicName);
			
			try {
				picFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
		
		
		int rows = customerService.addCustomerInfo(customer);
		
		mvAndView.setViewName("redirect:/showCustomer.jsp");
		
		return mvAndView;
		
	}
	@RequestMapping("/delCustById")
	public ModelAndView delCustById(Long custId){
		ModelAndView mvAndView = new ModelAndView();
		
		int rows = customerService.delCustById(custId);
		
		mvAndView.setViewName("redirect:/showCustomer.jsp");
		
		return mvAndView;
	}
	
	
}
