package com.hz.ssm.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.hz.ssm.utils.StringToDateConverter;

@Configuration//如果在springBoot中的某个类被@Configuration  就可以把它理解为spring或者springMvc的核心配置文件
public class WebConfigBeans {
	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	/**
	 *
	 */
	@PostConstruct
	public void initEditableValidation(){
	ConfigurableWebBindingInitializer  initializer	=(ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
		if (initializer.getConversionService() !=null) {
		GenericConversionService genericConversionService =	(GenericConversionService) initializer.getConversionService();
		genericConversionService.addConverter(new StringToDateConverter());
		}
	}

}
