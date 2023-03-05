package com.crud.cards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.cards.models.Cards;
import com.crud.cards.models.ServiceResponse;
import com.crud.cards.services.ICardService;

@RestController
@RequestMapping("/api/v1/card")
@CrossOrigin("*")
public class CardController {
	
	@Autowired
	private ICardService iCardService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cards>> list(){
		var result = iCardService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ServiceResponse> save(@RequestBody Cards card){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCardService.save(card);
		if(result == 1) {
			serviceResponse.setMessage("Item saved with success :D");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ServiceResponse> update(@RequestBody Cards card){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCardService.update(card);
		if(result == 1) {
			serviceResponse.setMessage("Item updated with success :D");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCardService.deleteByid(id);
		if(result == 1) {
			serviceResponse.setMessage("Item deleted with success :D");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
