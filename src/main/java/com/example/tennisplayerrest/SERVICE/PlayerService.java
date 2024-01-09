package com.example.tennisplayerrest.SERVICE;

import com.example.tennisplayerrest.ENTITY.Player;
import com.example.tennisplayerrest.REPOSITORY.PlayerRepository;
import jakarta.transaction.Transactional;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
    public Player patch(int id, Map<String, Object> playerPatch){
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            playerPatch.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
            }
        else{
              throw new RuntimeException("Player not found");
        }
        return  playerRepository.save(player.get());
    }
    @Transactional
    public void updateTitles(int id, int titles){
       Optional<Player> player = playerRepository.findById(id);
      if(player.isEmpty()){
           throw new RuntimeException("Player title can cot be updated");
        }
        playerRepository.updateTitles(id,titles);
   }

    public void deletePlayer(int id){
        Optional<Player> teamPlayer = playerRepository.findById(id);
        if(teamPlayer.isEmpty())
            throw new RuntimeException("Player with the id not found");
        playerRepository.delete(teamPlayer.get());
    }
}
