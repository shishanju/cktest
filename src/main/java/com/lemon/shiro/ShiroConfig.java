package com.lemon.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {
	

	
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/user/*", "anon");
		filterChainDefinitionMap.put("/user/logout", "authc");

		//过滤器定义从上向下顺序执行
		//authc:url都必须认证通过才可以访问；anon:url都可以匿名访问
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		//如果不设置会自动寻找web工程目录下的"/login"页面
		shiroFilterFactoryBean.setLoginUrl("/user/unauth");
		return shiroFilterFactoryBean;
	}

	//从新设置SecurityManager，通过自动以的MyRealm完成登陆校验
	@Bean
	public MyRealm myReal() {
		return new MyRealm();
	}

	@Bean
	public SecurityManager securityManager(MyRealm myReal) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		
        securityManager.setSessionManager(sessionManager());
		
		securityManager.setRealm(myReal);
		return securityManager;
	}

	@Bean
	public SessionManager sessionManager(){
		CustomSessionManager manager = new CustomSessionManager();
	    manager.setSessionDAO(new EnterpriseCacheSessionDAO());
		return manager;
	}



}
