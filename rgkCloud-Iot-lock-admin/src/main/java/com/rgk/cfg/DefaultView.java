package com.rgk.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 默认页
 *
 */
@Configuration
public class DefaultView implements WebMvcConfigurer  {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:home");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		WebMvcConfigurer.super.addViewControllers(registry);
	}
	
}
