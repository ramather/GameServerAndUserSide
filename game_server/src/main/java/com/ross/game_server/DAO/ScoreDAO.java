package com.ross.game_server.DAO;

import com.ross.game_server.DTO.ScoreDTO;

import java.util.List;

public interface ScoreDAO {
    public void create(ScoreDTO newScore);
    public List<Score> listScores();
}
