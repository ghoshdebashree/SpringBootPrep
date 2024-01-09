package com.example.tennisplayerrest.REPOSITORY;

import com.example.tennisplayerrest.ENTITY.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
