package KitchenNote;

import java.sql.Time;

public class Recipe_Info {
	private int RECIPE_ID;
	private String RECIPE_NM_KO;
	private String SUMRY;
	private String COOKING_TIME;
	private String IMG_URL;
	private String member_id="admin123@gmail.com";
	public int getRECIPE_ID() {
		return RECIPE_ID;
	}
	public void setRECIPE_ID(int rECIPE_ID) {
		RECIPE_ID = rECIPE_ID;
	}
	public String getRECIPE_NM_KO() {
		return RECIPE_NM_KO;
	}
	public void setRECIPE_NM_KO(String rECIPE_NM_KO) {
		RECIPE_NM_KO = rECIPE_NM_KO;
	}
	public String getSUMRY() {
		return SUMRY;
	}
	public void setSUMRY(String sUMRY) {
		SUMRY = sUMRY;
	}

	public String getIMG_URL() {
		return IMG_URL;
	}
	public void setIMG_URL(String iMG_URL) {
		IMG_URL = iMG_URL;
	}
	public String getCOOKING_TIME() {
		return COOKING_TIME;
	}
	public void setCOOKING_TIME(String cOOKING_TIME) {
		COOKING_TIME = cOOKING_TIME;
	}
	@Override
	public String toString() {
		return "Recipe_Info [RECIPE_ID=" + RECIPE_ID + ", RECIPE_NM_KO=" + RECIPE_NM_KO + ", SUMRY=" + SUMRY
				+ ", COOKING_TIME=" + COOKING_TIME + ", IMG_URL=" + IMG_URL + "]";
	}
	
	
	
}
