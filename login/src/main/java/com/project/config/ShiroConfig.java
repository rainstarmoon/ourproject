package com.project.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ShiroConfig {


	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
		
		filters.put("authc", new CustomFormAuthenticationFilter());
		
		
		
		shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/main");  
        shiroFilterFactoryBean.setSuccessUrl("/main3");
        
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>(); 
        filterChainDefinitionMap.put("/static/**", "anon");
        
        filterChainDefinitionMap.put("/test", "anon");
        filterChainDefinitionMap.put("/main", "anon");
        filterChainDefinitionMap.put("/main2", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
        filterChainDefinitionMap.put("/**", "authc");  
        shiroFilterFactoryBean  
                .setFilterChainDefinitionMap(filterChainDefinitionMap);  
		return shiroFilterFactoryBean;
	}
	
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(mongodbRealm());
		return securityManager;
	}
	
	@Bean
	public MongodbRealm mongodbRealm(){
		MongodbRealm mongodbRealm = new MongodbRealm();
		return mongodbRealm;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	
}
