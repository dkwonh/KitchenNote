package KitchenNote;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import com.google.gson.stream.JsonReader;

public class JsonToDB {

	
	JsonReader reader;
	Gson gson;
	List<Recipe_Info> list;
	List<Ingredient> ing_list;
	
	public List<Recipe_Info> recipe_in(){
		try {
			reader = new JsonReader(new FileReader("C:\\Users\\Administrator\\Documents\\recipe_info.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gson = new Gson();
		Recipe_Info[] list = gson.fromJson(reader, Recipe_Info[].class);
		return Arrays.asList(list);
		
	
	}
	
	public List<Ingredient> ingredient(){
		try {
			reader = new JsonReader(new FileReader("C:\\Users\\Administrator\\Documents\\recipe_ing.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gson = new Gson();
		Ingredient[] list = gson.fromJson(reader, Ingredient[].class);
		return Arrays.asList(list);
	}
	
	public List<Recipe_Pro> recipe_pro(){
		try {
			reader = new JsonReader(new FileReader("C:\\Users\\Administrator\\Documents\\recipe_pro.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gson = new Gson();
		Recipe_Pro[] list = gson.fromJson(reader, Recipe_Pro[].class);
		return Arrays.asList(list);
	}
	
	
}
