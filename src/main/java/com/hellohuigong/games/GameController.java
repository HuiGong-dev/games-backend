package com.hellohuigong.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<List<Game>>(gameService.allGames(), HttpStatus.OK);
    }

    @GetMapping("/{steamId}")
    public ResponseEntity<Optional<Game>> getSingleGame(@PathVariable Integer steamId) {
        return new ResponseEntity<Optional<Game>>(gameService.singleGame(steamId), HttpStatus.OK);
    }



}
