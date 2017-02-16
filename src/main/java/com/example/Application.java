package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

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
}
