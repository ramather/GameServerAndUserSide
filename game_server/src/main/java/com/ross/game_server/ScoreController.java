package com.ross.game_server;

import com.ross.game_server.DAO.Score;
import com.ross.game_server.DAO.ScoreDAO;
import com.ross.game_server.DTO.ScoreDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    private final ScoreDAO scoreDAO;

    public ScoreController(ScoreDAO scoreDAO){
        this.scoreDAO = scoreDAO;
    }

    @RequestMapping(value = "/score", method = RequestMethod.GET)
    public List<Score> listScores(){
        return scoreDAO.listScores();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addScore(@RequestBody ScoreDTO scoreDTO){
        scoreDAO.create(scoreDTO);
    }


}
