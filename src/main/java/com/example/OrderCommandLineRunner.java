package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class OrderCommandLineRunner implements CommandLineRunner, ExitCodeGenerator, DisposableBean {

	/**
	 * 实现CommandLineRunner接口
	 * 应用启动外启动
	 */
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作--@Order(value=1)<<<<<<<<<<<<<");
	}

	/**
	 * 实现ExitCodeGenerator接口
	 * 自定义应用退出状态码
	 */
	@Override
	public int getExitCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 实现DisposableBean接口
	 * 销毁应用
	 * 等价于@PreDestroy
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}
}