package com.asiainfo1.conf;

import org.redisson.Redisson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asiainfo1.prop.TempProperties;
import com.asiainfo1.template.ZzwTemplate;

/**
 * 模拟spb的自动装配
 *
 * @author zhangzhiwang
 * @date Jun 30, 2020 3:10:17 PM
 */
@Configuration
@EnableConfigurationProperties({TempProperties.class})// 该注解的作用是将标注了@ConfigurationProperties注解的类的对象当作bean放入到ioc容器中
public class ZzwAutoConfiguration {// 一般自动配置类的类名都以AutoConfiguration结尾，使人一目了然
	@Bean
	@ConditionalOnClass({Redisson.class})
	public ZzwTemplate zzwTemplate(TempProperties tempProperties) {// spring在实例化ZzwTemplate对象的时候要注入tempProperties，而tempProperties对象必须是事先已存在IOC容器里的bean才能被注入，
																	// 那么如何让标注了@ConfigurationProperties注解的类的对象成为容器中的bean呢？答案就是使用@EnableConfigurationProperties注解
		return new ZzwTemplate(tempProperties.getUserName());
	}
}