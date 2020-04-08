package board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import KitchenNote.Dto;
import KitchenNote.Ingredient;
import KitchenNote.NangbuDto;
import KitchenNote.Recipe_Info;
import KitchenNote.Recipe_Pro;
import board.dto.CustomRecipeInfo;

public class CustomRecipeInfoDao extends SqlSessionDaoSupport{
	
	//재료로 찾기 체크박스 사용예정
	public List<CustomRecipeInfo> searchIngredient(int[] ingredients){
		return getSqlSession().selectList("board.searchIngredient",ingredients);
		
	}
	//이름으로 찾기 like 사용
	public List<CustomRecipeInfo> searchName(String recipe_Name){
		return getSqlSession().selectList("board.searchName",recipe_Name);
		
	}
	//냉부 재료목록 가져오기
	public List<NangbuDto> getNangbuIngre(int ing_category){
		return getSqlSession().selectList("board.getNangbuIngre",ing_category);
	}
	//냉부 카테고리 가져오기
	public Map<Integer,String> getNangbuCategory(){
		return getSqlSession().selectMap("board.getNangbuCategory", "ing_category");
	}
	
	public List<CustomRecipeInfo> selectAll(){
		return getSqlSession().selectList("board.selectAll");
	}
	
	public int ingInsert(Ingredient ing) {
		return getSqlSession().insert("board.ingreinsert",ing);
	}
	
	public List<Integer> ingId(String name) {
		return getSqlSession().selectList("board.ingreid",name);
	}
	
	public int insertPro(Recipe_Pro pro) {
		return getSqlSession().insert("board.insertPro",pro);
	}
	
	public List<Recipe_Info> selectRecipe(int info){
		return getSqlSession().selectList("board.searchRecipe",info);
	}
	
	/*
	 * public int insert(Recipe_Info info) { return
	 * getSqlSession().insert("board.insert",info); }
	 */
	  public int insertIngre(Dto dto) { return
	  getSqlSession().insert("board.insertIngre", dto); }
	 
	
	
	/*재료 테이블 인서트 코드
	 * public int insertIngre(Dto dto) { return
	 * getSqlSession().insert("board.insertIngre", dto); }
	 */
}
