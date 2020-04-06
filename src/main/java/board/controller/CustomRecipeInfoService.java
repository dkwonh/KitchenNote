package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dao.CustomRecipeInfoDao;
import board.dto.CustomRecipeInfo;

@Service
public class CustomRecipeInfoService {

	@Autowired
	CustomRecipeInfoDao customRecipeInfoDao;
	
	public List<CustomRecipeInfo> selectAll(){
		return customRecipeInfoDao.selectAll();
	}
}
