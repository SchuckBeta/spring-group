package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * Spring	Boot使用一个非常特别的PropertySource次序来允许对值进行合理的覆盖，需要以下面的次序考虑属性：
 * 1.	命令行参数
 * 2.	来自于java:comp/env的JNDI属性
 * 3.	Java系统属性（System.getProperties()） 
 * 4.	操作系统环境变量 
 * 5.	只有在random.*里包含的属性会产生一个RandomValuePropertySource 
 * 6.	在打包的jar外的应用程序配置文件（application.properties，包含YAML和profile变量） 
 * 7.	在打包的jar内的应用程序配置文件（application.properties，包含YAML和profile变量）
 * 8.	在@Configuration类上的@PropertySource注解
 * 9.	默认属性（使用SpringApplication.setDefaultProperties指定）
 * --------------------------------------------------------------------------------
 * SpringApplication将从以下位置加载application.properties文件，并把它们添加到Spring	Environment中：
 * 1.	当前目录下的一个/config子目录 
 * 2.	当前目录 
 * 3.	一个classpath下的/config包 
 * 4.	classpath根路径（root）
 * 这个列表是按优先级排序的（列表中位置高的将覆盖位置低的）。注：你可以使用YAML（'.yml'）文件替代'.properties'
 */
@Component
@Order(value=4)
@ConfigurationProperties(prefix="my")
public class PropertyReplace implements CommandLineRunner{
	@Value("${test.sname}")
	private String name;

	@Value("${test.name}")
	private String testName;

	@Value("${my.secret}")
	private String mySecret;
	
	@Value("${my.number}")
	private String myNumber;
	
	@Value("${my.bignumber}")
	private String myBignumber;
	
	@Value("${my.number.less.than.ten}")
	private String myNumberLessThanTen;

	@Value("${my.number.in.range}")
	private String myNumberInRange;
	
	private List<String> servers = new ArrayList<String>();

	public List<String> getServers() {
		return this.servers;
	}

	/**
	 * 实现CommandLineRunner接口
	 * 应用启动外启动
	 */
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作--@Order(value=4)<<<<<<<<<<<<<");
		System.out.println(this.name+"-----------"+this.testName);

		
		
		System.out.println("mySecret-----------"+this.mySecret);
		System.out.println("myNumber-----------"+this.myNumber);
		System.out.println("myBignumber-----------"+this.myBignumber);
		System.out.println("myNumberLessThanTen-----------"+this.myNumberLessThanTen);
		System.out.println("myNumberInRange-----------"+this.myNumberInRange);
		
		System.out.println("this.servers-----------"+this.servers);
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作--@Order(value=4)<<<<<<<<<<<<<");
	}
	
}
