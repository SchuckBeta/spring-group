package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Team;

public interface TeamDao extends CrudRepository<Team, Long>{
	List<Team> findAll();

	Team findByName(String name);
	
	List<Team> findByNameStartsWithIgnoreCase(String name);
}
