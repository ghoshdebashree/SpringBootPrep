package com.example.tennisplayerrest.CONTROLLER;

import com.example.tennisplayerrest.ENTITY.Player;
import com.example.tennisplayerrest.SERVICE.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
     PlayerService playerService;

    @GetMapping("/welcome")
    private String welcome(){
        return "This is a welcome message from Player app !!";
    }
    @GetMapping("/allplayers")
    private List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/getPlayer/{id}")
    private Player getOnePlayer(@PathVariable int id){
        return playerService.getOnePlayer(id);
    }

    @PostMapping("/addPlayer")
    private Player addPlayer(@RequestBody Player p){
        p.setId(0);
        return playerService.addPlayer(p);
    }
    @PutMapping("/updatePlayer/{id}")
    private Player updatePlayer(@RequestBody Player p, @PathVariable int id){
        return playerService.updatePlayer(id,p);
    }
    @DeleteMapping("/deletePlayer/{id}")
    private void deletePlayer(@PathVariable int id){
        playerService.deletePlayer(id);
    }
}
