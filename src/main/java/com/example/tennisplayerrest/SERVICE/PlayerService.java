package com.example.tennisplayerrest.SERVICE;

import com.example.tennisplayerrest.ENTITY.Player;
import com.example.tennisplayerrest.REPOSITORY.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;


    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getOnePlayer(int id){
        Optional<Player> teamPlayer = playerRepository.findById(id);
        Player p = null;
        if(teamPlayer.isPresent()){
            p = teamPlayer.get();
        }
        else{
            throw new RuntimeException("Player with id" +id+ "not found");
        }
        return p;
    }
    public Player addPlayer(Player p){
        return playerRepository.save(p);
    }
    public Player updatePlayer(int id, Player p){
        Optional<Player> tempPlayer = playerRepository.findById(id);

        if(tempPlayer.isEmpty())
            throw new RuntimeException("Player with id {"+ id +"} not found");

        p.setId(id);
        return playerRepository.save(p);
    }

    public void deletePlayer(int id){
        Optional<Player> teamPlayer = playerRepository.findById(id);
        if(teamPlayer.isEmpty())
            throw new RuntimeException("Player with the id not found");
        playerRepository.delete(teamPlayer.get());
    }
}
