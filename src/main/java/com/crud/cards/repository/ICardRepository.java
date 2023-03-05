package com.crud.cards.repository;
import java.util.List;
import com.crud.cards.models.Cards;

public interface ICardRepository {
	public List<Cards> findAll();
	public int save(Cards card);
	public int update(Cards card);
	public int deleteByid(int id);
}
