package com.revature.controllers;
import org.json.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ingredient;
import com.revature.service.CalorieService;
import com.revature.service.IngredientService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	
	@Autowired
	IngredientService iService;
	
	@Autowired
	CalorieService cService;
	
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
	public ResponseEntity<Object> test(@RequestBody Ingredient item) throws JsonParseException, JsonMappingException, IOException {
	System.out.println("HERE");
	ObjectMapper objectMapper = new ObjectMapper();
	
	URL url = new URL("https://api.nal.usda.gov/ndb/V2/reports?ndbno="+ item.getNdbno() +"&type=f&format=json&api_key=DEMO_KEY");
	System.out.println(url);
	Object obj = objectMapper.readValue(url, Object.class);
	String temp = objectMapper.writeValueAsString(obj);
	JSONObject root = new JSONObject(temp);
	JSONArray items = root.getJSONArray("foods");
	//for multiple items, foreach loop in foods => do the rest of this
//	for (int i = 0; i < items.length(); i++) {
//		
//	}
	//make list of subitems and subs after
	JSONObject subitems = items.getJSONObject(0);
	JSONObject subitems2 = subitems.getJSONObject("food");
	JSONArray subitems3 = subitems2.getJSONArray("nutrients");
	JSONObject subitems4 = subitems3.getJSONObject(1);
	int tempy = subitems4.getInt("value");
	//JSONObject subitems2 = new JSONObject(subitems);
	//System.out.println(items);
	System.out.println(tempy);
	//System.out.println(obj.toString());
	//JSONArray jobj = obj.getJSONArray("foods");
	//System.out.println(jobj.toString());
	//System.out.println(obj.toString());
	//ArrayList<Object> test =  (ArrayList<Object>) obj.get("foods");
	//Object test2 = test.get(0);
	//int test = obj	
	
	
	
	//System.out.println(items);
		return new ResponseEntity<Object>(obj, HttpStatus.I_AM_A_TEAPOT);
	}

}
