package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TeamDao;
import com.example.entity.Team;

@RestController
@RequestMapping("/dataJpa/")
public class DataJpaController {
	@Autowired
	TeamDao teamDao;

	@RequestMapping("/teams")
	public List<Team> findAllTeam() {
		return teamDao.findAll();
	}
	
	@RequestMapping("/teams/{name}")
	public Team findTeamByName(@PathVariable String name) {
		return teamDao.findByName(name);
	}
}
