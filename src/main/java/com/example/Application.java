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
		List<Player> players = new ArrayList<Player>();
		List<Player> players1 = new ArrayList<Player>();
		List<Player> players2 = new ArrayList<Player>();
		List<Player> players3 = new ArrayList<Player>();
		List<Player> players4 = new ArrayList<Player>();
		List<Player> players5 = new ArrayList<Player>();
		for (int j = 0; j < 5; j++) {
			Player player = new Player();
			player.setId(new Long(j));
			player.setName("Jason s-"+j);
			player.setAge(j);
			players.add(player);
			
			Player player1 = new Player();
			player1.setId(new Long(10+j));
			player1.setName("Jason s-"+(10+j));
			player1.setAge((10+j));
			players.add(player1);
			
			
			Player player2 = new Player();
			player1.setId(new Long(20+j));
			player2.setName("Jason s-"+(20+j));
			player2.setAge(20+j);
			players.add(player2);
			

			Player player3 = new Player();
			player1.setId(new Long(30+j));
			player3.setName("Jason s-"+(30+j));
			player3.setAge(30+j);
			players.add(player3);
			

			Player player4 = new Player();
			player1.setId(new Long(40+j));
			player4.setName("Jason s-"+(40+j));
			player4.setAge(40+j);
			players.add(player4);
			

			Player player5 = new Player();
			player1.setId(new Long(50+j));
			player5.setName("Jason s-"+(50+j));
			player5.setAge(50+j);
			players.add(player5);
		}
		
		List<Team> teams = new ArrayList<Team>();
		for (int i = 0; i < 6; i++) {
			Team team = new Team();
			team.setId(new Long(i));
			team.setName("Jason"+i);
			team.setAge(i);
			
//			if(i==0){
//				team.setName("Jason"+i);
//				team.setAge(i);
//				team.setPlayers(players);
//			}else if(i==1){
//				team.setName("Jason"+(10+i));
//				team.setAge(10+i);
//				team.setPlayers(players1);
//			}else if(i==2){
//				team.setName("Jason"+(20+i));
//				team.setAge(20+i);
//				team.setPlayers(players2);
//			}else if(i==3){
//				team.setName("Jason"+(30+i));
//				team.setAge(30+i);
//				team.setPlayers(players3);
//			}else if(i==4){
//				team.setName("Jason"+(40+i));
//				team.setAge(40+i);
//				team.setPlayers(players4);
//			}else{
//				team.setName("Jason"+(50+i));
//				team.setAge(50+i);
//				team.setPlayers(players5);
//			}
			teams.add(team);
		}
		
		teamDao.save(teams);
	}
}
