package board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import KitchenNote.Dto;
import KitchenNote.Ingredient;
import KitchenNote.Recipe_Info;
import KitchenNote.Recipe_Pro;
import board.dto.CustomRecipeInfo;

public class CustomRecipeInfoDao extends SqlSessionDaoSupport{
	
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
