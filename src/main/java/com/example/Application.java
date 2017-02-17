package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 等价于下面3个注解:
 * 	@Configuration
 * 	@ComponentScan
 * 	@EnableAutoConfiguration
 * 
 * 默认的Banner, 默认情况下会显示INFO级别的日志信息，包括一些相关的启动详情，比如启动应用的用户等。
 */
@SpringBootApplication
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


/**
 * Banner接口实现 printBanner
 */
//@SpringBootApplication
//public class Application implements Banner{
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//	@Override
//	public void printBanner(Environment arg0, Class<?> arg1, PrintStream arg2) {
//		// TODO Auto-generated method stub
//		
//	}
//}


/**
 * 关闭默认的Banner，自定义Banner
 * @param args
 */
//@SpringBootApplication
//public class Application{
//	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(Application.class);
//		app.setBannerMode(Mode.OFF);//关闭默认的Banner
//		app.setBannerMode(Mode.LOG);
//		app.setBannerMode(Mode.CONSOLE);
//		app.run(args);
//	}
//}



///**
//* 链式调用
//* @param args
//*/
//@SpringBootApplication
//public class Application{
//	public static void main(String[] args) {
//		new SpringApplicationBuilder()
//		.setBannerMode(Mode.OFF)
//		.sources(Parent.class)
//		.child(Application.class)
//		.run(args);
//	}
//}