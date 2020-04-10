package board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KitchenNote.Category;
import KitchenNote.Dto;
import KitchenNote.Ingredient;
import KitchenNote.NangbuDto;
import KitchenNote.Recipe_Info;
import KitchenNote.Recipe_Pro;
import board.dao.CustomRecipeInfoDao;
import board.dto.CustomRecipeInfo;

@Service
public class CustomRecipeInfoService {

	@Autowired
	CustomRecipeInfoDao customRecipeInfoDao;
	
	public List<CustomRecipeInfo> searchIngredient(int[] ingredients){
		return customRecipeInfoDao.searchIngredient(ingredients);
	}
	
	public List<CustomRecipeInfo> searchName(String recipe_Name){
		return customRecipeInfoDao.searchName(recipe_Name);
	}
	
	public List<NangbuDto> getNangbuIngre(int ing_category){
		return customRecipeInfoDao.getNangbuIngre(ing_category);
	}
	
	public Map<Integer,String> getNangCategory(){
		return customRecipeInfoDao.getNangbuCategory();
	}
	
	public List<CustomRecipeInfo> selectAll(){
		return customRecipeInfoDao.selectAll();
	}
	
	public int ingInsert(Ingredient ing) {
		return customRecipeInfoDao.ingInsert(ing);
	}
	
	public List<Integer> ingId(String name) {
		return customRecipeInfoDao.ingId(name);
	}
	
	public int insertPro(Recipe_Pro pro) {
		return customRecipeInfoDao.insertPro(pro);
	}
	
	public List<Recipe_Info> selectRecipe(int info){
		return customRecipeInfoDao.selectRecipe(info);
	}
	
	public void insertCategory(Category c) {
		customRecipeInfoDao.insertCategory(c);
	}
	
	public List<Category> loadCategory(){
		return customRecipeInfoDao.loadCategory();
	}
	
	public List<CustomRecipeInfo> searchCategory(int category[]){
		return customRecipeInfoDao.searchCategory(category);
	}
	
	
	  public int insert(Recipe_Info info) { return
	  customRecipeInfoDao.insert(info); }
	  
	  
	  public int insertIngre(Dto dto) { return
	  customRecipeInfoDao.insertIngre(dto); }
	 
	
	
	//재료 테이블 인서트 코드
	  public int in(Dto dto) { return
	  customRecipeInfoDao.in(dto); }
	 
}
