package com.crud.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.crud.cards.models.Cards;

@SpringBootApplication
public class MsCardsApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(MsCardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql  = "SELECT  * FROM spring.CARDS";
		List<Cards>  cards = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cards.class));
		cards.forEach(System.out :: println);
	}

}
