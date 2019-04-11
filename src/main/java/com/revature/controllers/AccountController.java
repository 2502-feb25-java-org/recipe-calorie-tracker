package com.revature.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Calorie;
import com.revature.models.Ingredient;
import com.revature.service.IngredientService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	IngredientService iService;
	
	
	//return all ingredients
	@RequestMapping(value="/ingredients", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredient>> getAll(){
		return new ResponseEntity<List<Ingredient>>(iService.getAllIngredients(), HttpStatus.CREATED);
	}
//	
//	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Calorie>> getCalories(List<Ingredient> items){
//		return new ResponseEntity<List<Calorie>>(iService)
//	}
	//returns general object, have an algorithm for parsing and will apply asap
	@RequestMapping(value="/1", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> test(@RequestBody Calorie nbdno) throws JsonParseException, JsonMappingException, IOException {
	System.out.println("HERE");
	ObjectMapper objectMapper = new ObjectMapper();
	
	URL url = new URL("https://api.nal.usda.gov/ndb/V2/reports?ndbno="+ nbdno.getNdbno() +"&type=f&format=json&api_key=DEMO_KEY");
	System.out.println(url);
	Object obj = objectMapper.readValue(url, Object.class);
	System.out.println(obj);
		return new ResponseEntity<Object>(obj, HttpStatus.I_AM_A_TEAPOT);
	}

}
