package com.hellohuigong.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> allGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> singleGame(Integer steamId){
        return gameRepository.findGameBySteamId(steamId);
    }



}
