package com.springboot.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application.domain.Player;
import com.springboot.application.service.PlayerService;

@RestController
@RequestMapping("api/player")
public class PlayerController {
    @Autowired
	public PlayerService playerService;
    
    @PostMapping("/addPlayer")
    public ResponseEntity<Player> addPlayerDetails(@RequestBody Player player) {    	
    	Player playerDetails = playerService.addPlayer(player);
		return new ResponseEntity<>(playerDetails, HttpStatus.CREATED); 	
     }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Player> getPlayerDetailsById(@PathVariable int id){
		return new ResponseEntity<>(playerService.getPlayerById(id), HttpStatus.OK);		   	
    }
	
    @GetMapping("/getPlayers")
    public ResponseEntity<List<Player>> getPlayersDetails(){
    	List<Player> players = playerService.getAllPlayers();
		return new ResponseEntity<>(players, HttpStatus.OK);		   	
    }
    
    @PutMapping("/updatePlayer/{id}")
    public ResponseEntity<Player> updatePlayerDetails(@PathVariable int id,@RequestBody Player player) {    	
    	Player playerDetails = playerService.updatePlayer(id, player);
		return new ResponseEntity<>(playerDetails, HttpStatus.CREATED); 	
     }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayerDetailsById(@PathVariable int id){
		return new ResponseEntity<>(playerService.deletePlayerById(id), HttpStatus.OK);		   	
    }
	

}
