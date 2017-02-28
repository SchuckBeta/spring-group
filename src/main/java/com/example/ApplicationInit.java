package com.example;

public class ApplicationInit {
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.example.dao.TeamDao;
//import com.example.entity.Team;
//
//@Component
//public class ApplicationInit implements CommandLineRunner {
//	private static final Logger log = LoggerFactory.getLogger(Application.class);
//	
//	@Autowired 
//	TeamDao dao;
//
//	@Override
//	public void run(String... arg0) throws Exception {
//		System.out.println("----------------------------------------------初始化加载数据");
//		dao.save(new Team("Jack", 1));
//		dao.save(new Team("Chloe", 12));
//		dao.save(new Team("Kim", 221));
//		dao.save(new Team("David", 13));
//		dao.save(new Team("Michelle", 14));
//
//		// fetch all customers
//		log.info("Customers found with findAll():");
//		log.info("-------------------------------");
//		for (Team customer : dao.findAll()) {
//			log.info(customer.toString());
//		}
//		log.info("");
//
//		// fetch an individual customer by ID
//		Team team = dao.findOne(1L);
//		log.info("Team found with findOne(1L):");
//		log.info("--------------------------------");
//		log.info(dao.toString());
//		log.info("");
//
//		// fetch Teams by last name
//		log.info("Team found with findByLastNameStartsWithIgnoreCase('Bauer'):");
//		log.info("--------------------------------------------");
//		for (Team bauer : dao.findByNameStartsWithIgnoreCase("Bauer")) {
//			log.info(bauer.toString());
//		}
//		log.info("");
//	}
}
