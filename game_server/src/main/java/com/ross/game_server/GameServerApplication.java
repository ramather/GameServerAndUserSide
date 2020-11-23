package com.ross.game_server;

import com.ross.game_server.DAO.JdbcScoreDAO;
import com.ross.game_server.DAO.Score;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GameServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameServerApplication.class, args);
		BasicDataSource gameDataSource = new BasicDataSource();
		gameDataSource.setUrl("jdbc:postgresql://localhost:5432/game");
		gameDataSource.setUsername("postgres");
		gameDataSource.setPassword("postgres1");


	}

}
