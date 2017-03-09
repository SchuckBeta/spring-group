package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.prop.PropComponent;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private static final Log log = LogFactory.getLog(ApplicationTests.class);

	@Autowired
	private PropComponent propComponent;

	@Before
	public void loads() {
		System.out.println("---------------junit @Before start");
	}
	
	@Test
	public void contextLoads() {
		System.out.println("---------------junit start");
	}

	@Test
	public void test1() throws Exception {
		Assert.assertEquals("程序猿DD", propComponent.getName());
		Assert.assertEquals("Spring Boot教程", propComponent.getTitle());
		Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》", propComponent.getDesc());

		log.info("随机数测试输出：");
		log.info("随机字符串 : " + propComponent.getValue());
		log.info("随机int : " + propComponent.getNumber());
		log.info("随机long : " + propComponent.getBignumber());
		log.info("随机10以下 : " + propComponent.getTest1());
		log.info("随机10-20 : " + propComponent.getTest2());

	}
}
