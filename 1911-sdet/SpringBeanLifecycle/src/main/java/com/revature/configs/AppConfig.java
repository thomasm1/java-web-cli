package com.revature.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.LifeBean;

@Configuration
public class AppConfig {

	@Bean
	public LifeBean getLifeBean() {
		return new LifeBean();
	}
}
