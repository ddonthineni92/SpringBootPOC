package com.springboot.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.Exception.PlayerNotFoundException;
import com.springboot.application.domain.Player;
import com.springboot.application.repository.PlayerRepo;


//Service Layer
@Service
public class PlayerServiceImpl implements PlayerService{
	
	public static final String PLAYER_WITH_ID_IS_NOT_FOUND = "Player with id %s is not found";
	
	@Autowired
	public PlayerRepo playerRepo;

	@Override
	public Player addPlayer(Player player) {
		return playerRepo.save(player);		
	}

	@Override
	public Player getPlayerById(int id) {
		Optional<Player> opt = playerRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
	  throw new PlayerNotFoundException(String.format(PLAYER_WITH_ID_IS_NOT_FOUND,id));
	}

	@Override
	public List<Player> getAllPlayers() {
		 List<Player> players = new ArrayList<>();
         playerRepo.findAll().forEach(players::add);
		return players;
	}

	@Override
	public Player updatePlayer(int id, Player player) {
		
		Optional<Player> opt = playerRepo.findById(id);
		if(opt.isPresent()){
			Player updatePlayer = opt.get();
			updatePlayer.setName(player.getName());
			updatePlayer.setEmail(player.getEmail());
			updatePlayer.setRole(player.getRole());
			updatePlayer.setCountry(player.getCountry());
		return playerRepo.save(updatePlayer);
		}
		throw new PlayerNotFoundException(String.format(PLAYER_WITH_ID_IS_NOT_FOUND,id));
	}

	@Override
	public String deletePlayerById(int id) {
		Optional<Player> opt = playerRepo.findById(id);
	    if (opt.isPresent()) {
	      playerRepo.deleteById(id);
	      return "Successfully Deleted";
	    }
	    throw new PlayerNotFoundException(String.format(PLAYER_WITH_ID_IS_NOT_FOUND,id));
	}

}
