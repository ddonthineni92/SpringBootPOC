package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.application.domain.Player;

//Persistence Layer
@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer>{
	
}


