package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.dao.TeamDao;
import com.example.entity.Player;
import com.example.entity.Team;

/**
 * @SpringBootApplication 等价于下面3个注解:
 * 	@Configuration
 * 	@ComponentScan
 * 	@EnableAutoConfiguration
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 使用war包运行时实现该方法
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	
	@Autowired 
	TeamDao teamDao;
	
	@PostConstruct
	public void init() {
		List<Team> teams = new ArrayList<Team>();
		for (int i = 0; i < 5; i++) {
			Team team = new Team();
			team.setName("Jason"+i);
			team.setAge(10+i);
			List<Player> players = new ArrayList<Player>();
			for (int j = 0; j < 5; j++) {
				Player player = new Player();
				player.setName("Jason s"+i+"-"+j);
				player.setAge(30+j);
				players.add(player);
			}
			team.setPlayers(players);
			teams.add(team);
		}
		
		teamDao.save(teams);
	}
	
	

	/**
	 * 启动初始化数据：
	 * 等价于 public class ApplicationInit implements CommandLineRunner类的实现
	 */
	@Bean
	public CommandLineRunner loadData(TeamDao dao) {
		return (args) -> {
			// save a couple of teams
			dao.save(new Team("Jack", 1));
			dao.save(new Team("Chloe", 12));
			dao.save(new Team("Kim", 221));
			dao.save(new Team("David", 13));
			dao.save(new Team("Michelle", 14));

			// fetch all teams
			log.info("teams found with findAll():");
			log.info("-------------------------------");
			for (Team team : dao.findAll()) {
				log.info(team.toString());
			}
			log.info("");

			// fetch an individual team by ID
			Team team = dao.findOne(1L);
			log.info("Team found with findOne(1L):");
			log.info("--------------------------------");
			log.info(dao.toString());
			log.info("");

			// fetch Teams by last name
			log.info("Team found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (Team bauer : dao.findByNameStartsWithIgnoreCase("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}
