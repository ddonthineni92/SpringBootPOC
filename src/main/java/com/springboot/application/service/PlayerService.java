package com.springboot.application.service;

import java.util.List;

import com.springboot.application.domain.Player;

public interface PlayerService {
	//POST Operation
	Player addPlayer(Player player);
	//GET Operation
	Player getPlayerById(int id);
	//GET Operation
	List<Player> getAllPlayers();
	//PUT Operation
	Player updatePlayer(int id, Player player);
	//DELETE Operation
	String deletePlayerById(int id);	

}
