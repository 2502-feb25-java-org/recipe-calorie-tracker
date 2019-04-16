package com.revature.controllers;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
import com.revature.models.Calorie;
import com.revature.models.Ingredient;
import com.revature.models.MealHistory;
import com.revature.models.User;
import com.revature.service.CalorieService;
import com.revature.service.IngredientService;
import com.revature.service.MealService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	
	@Autowired
	IngredientService iService;
	
	@Autowired
	CalorieService cService;
	
	@Autowired
	MealService mService;
	
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
	
	@RequestMapping(value="/3", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MealHistory>> getHistory(@RequestBody User user){
	
		System.out.println(user);
		
		return new ResponseEntity<List<MealHistory>>(mService.getAllByUser(user.getId()), HttpStatus.OK);
	}
	
	
	
	//received query terms, send back list of meals with info
	@RequestMapping(value="/2", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MealHistory> addMeals(@RequestBody MealHistory meal){
		System.out.println("HERE");
		System.out.println(meal);
		if(meal.getDate()==null) {
			Date tempdate= new Date();
			meal.setDate(tempdate);
		}
		//meal = mService.addMeal(meal);
		return new ResponseEntity<MealHistory>(mService.addMeal(meal), HttpStatus.OK);
		
		
	}
	
	
	
	@RequestMapping(value="/1", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCals(@RequestBody Ingredient ingredient) throws JsonParseException, JsonMappingException, IOException {
		//ResponseEntity<List<Calorie>>
	System.out.println("HERE");
	ObjectMapper objectMapper = new ObjectMapper();//                                                                  RETURN NUMBER
	URL searchUrl= new URL("https://api.nal.usda.gov/ndb/search/?format=json&q="+ URLEncoder.encode(ingredient.getIngredientName(), "UTF-8")+"&sort=r&max=10&ds=Standard%20Reference&offset=0&api_key=DEMO_KEY");
	System.out.println(searchUrl);
	Object object = objectMapper.readValue(searchUrl, Object.class);
	String temp1 = objectMapper.writeValueAsString(object);
	JSONObject root1 = new JSONObject(temp1);
	JSONObject group1 = root1.getJSONObject("list");
	JSONArray group2 = group1.getJSONArray("item");
	List<Calorie> ndbSearch = new ArrayList<Calorie>();
	for (int i = 0; i < group2.length(); i++) {
		JSONObject iterator = group2.getJSONObject(i);
		//String tempndb = iterator.getString("ndbno");
		Calorie tempCal = new Calorie(iterator.getString("name"), iterator.getString("ndbno"));
		ndbSearch.add(tempCal);
	}
	String output = "";
	for (int i = 0; i < ndbSearch.size(); i++) {
		output+="ndbno="+ndbSearch.get(i).getNdbno()+"&";
	}
	System.out.println(ndbSearch);
	URL url = new URL("https://api.nal.usda.gov/ndb/V2/reports?"+output+"&type=f&format=json&api_key=DEMO_KEY");
	System.out.println(url);
	Object obj = objectMapper.readValue(url, Object.class);
	String temp = objectMapper.writeValueAsString(obj);
	JSONObject root = new JSONObject(temp);
	JSONArray items = root.getJSONArray("foods");
	for (int i = 0; i < items.length(); i++) {
		JSONObject subitems = items.getJSONObject(i);
		JSONObject subitems2 = subitems.getJSONObject("food");
		JSONArray subitems3 = subitems2.getJSONArray("nutrients");
		JSONObject subitems4 = subitems3.getJSONObject(1);
		int tempy = subitems4.getInt("value");
		ndbSearch.get(i).setCalories(tempy);
	}
	System.out.println(ndbSearch);
	

	return new ResponseEntity<Object>( ndbSearch, HttpStatus.OK);
	}

}
