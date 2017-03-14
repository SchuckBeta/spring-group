package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication 等价于下面3个注解: Configuration ComponentScan
 * EnableAutoConfiguration .
 */
@SpringBootApplication
public final class Application {
	/**
	 * 隐藏构造器.
	 */
	private Application() {
		super();
	}

	/**
	 * 启动方法.
	 *
	 * @param args
	 *            参数
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
