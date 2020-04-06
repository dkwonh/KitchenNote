package board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import board.dto.CustomRecipeInfo;

public class CustomRecipeInfoDao extends SqlSessionDaoSupport{
	
	public List<CustomRecipeInfo> selectAll(){
		return getSqlSession().selectList("board.selectAll");
	}
}
