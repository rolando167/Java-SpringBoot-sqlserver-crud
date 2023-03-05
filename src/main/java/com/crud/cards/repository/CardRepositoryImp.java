package com.crud.cards.repository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.cards.models.Cards;

@Repository
public class CardRepositoryImp implements ICardRepository{
	
	/*
	 * Crud en Java spring boot con SQL Server y Angular 2/6
	 * */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Cards> findAll() {
		String SQL = "Select * from spring.cards where status = 1";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cards.class));
	}

	@Override
	public int save(Cards card) {
		String SQL = "INSERT INTO spring.cards VALUES (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, new Object[] {
				card.getName(), 
				card.getNumber(),
				card.getType(),
				card.getCvv(), 
				card.getStatus(),
				card.getCreated_by(),
				LocalDateTime.now(), 
				LocalDateTime.now()
				});
	}

	@Override
	public int update(Cards card) {
		String SQL = "UPDATE spring.cards SET name=?, number=?, type=?, cvv=? , updated_at=? WHERE id_card = ?";
		return jdbcTemplate.update(SQL, new Object[] {
				card.getName(), 
				card.getNumber(),
				card.getType(),
				card.getCvv(),
				LocalDateTime.now(),
				card.getId_card()
				});
	}

	@Override
	public int deleteByid(int id) {
		String SQL = "UPDATE spring.cards SET status = 0, updated_at=? WHERE id_card = ?";
		return jdbcTemplate.update(SQL, new Object[] {LocalDateTime.now(), id});
	}
 
}
