package com.crud.cards.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.cards.models.Cards;
import com.crud.cards.repository.ICardRepository;

@Service
public class CardService implements ICardService {
	
	@Autowired
	private ICardRepository iCardRepository;

	@Override
	public List<Cards> findAll() {
		List<Cards> list = null;
		try {
			list = iCardRepository.findAll();
		} catch (Exception e) {
			throw e;
		} 
		return list;
	}

	@Override
	public int save(Cards card) {
		int row = 0;
		try {
			row = iCardRepository.save(card);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int update(Cards card) {
		int row = 0;
		try {
			row = iCardRepository.update(card);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int deleteByid(int id) {
		int row = 0;
		try {
			row = iCardRepository.deleteByid(id);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

}
