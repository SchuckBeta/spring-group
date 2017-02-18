package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class OrderACommandLineRunner implements CommandLineRunner{

	/**
	 * 实现CommandLineRunner接口
	 * 应用启动外启动
	 */
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作--@Order(value=2)<<<<<<<<<<<<<");
	}
}