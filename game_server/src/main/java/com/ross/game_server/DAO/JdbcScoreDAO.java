package com.ross.game_server.DAO;

import com.ross.game_server.DTO.ScoreDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcScoreDAO implements ScoreDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcScoreDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(ScoreDTO newScore) {
        String sql = "INSERT INTO  scores (name, score) VALUES (?,?);";
        jdbcTemplate.update(sql,  newScore.getName(), newScore.getScore());
    }

    @Override
    public List<Score> listScores() {
        List<Score> result = new ArrayList<>();
        String sql = "SELECT name, score FROM scores ORDER BY score DESC LIMIT 10;";
        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql);
        while (rowset.next()) {
            Score score = new Score();
            score.setName(rowset.getString("name"));
            score.setScore(rowset.getInt("score"));
            result.add(score);
        }
        return result;
    }
}
