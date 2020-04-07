package KitchenNote;

public class Recipe_Pro {
	public String STRE_STEP_IMAGE_URL;
	public int COOKING_NO;
	public int RECIPE_ID;
	public String COOKING_DC;
	
	
	public String getSTRE_STEP_IMAGE_URL() {
		return STRE_STEP_IMAGE_URL;
	}
	public void setSTRE_STEP_IMAGE_URL(String sTRE_STEP_IMAGE_URL) {
		STRE_STEP_IMAGE_URL = sTRE_STEP_IMAGE_URL;
	}
	

	public int getCOOKING_NO() {
		return COOKING_NO;
	}
	public void setCOOKING_NO(int cOOKING_NO) {
		COOKING_NO = cOOKING_NO;
	}
	public int getRECIPE_ID() {
		return RECIPE_ID;
	}
	public void setRECIPE_ID(int rECIPE_ID) {
		RECIPE_ID = rECIPE_ID;
	}
	public String getCOOKING_DC() {
		return COOKING_DC;
	}
	public void setCOOKING_DC(String cOOKING_DC) {
		COOKING_DC = cOOKING_DC;
	}
	public Recipe_Pro(String sTRE_STEP_IMAGE_URL, int rN, int rECIPE_ID, String cOOKING_DC) {
		super();
		STRE_STEP_IMAGE_URL = sTRE_STEP_IMAGE_URL;
		COOKING_NO = rN;
		RECIPE_ID = rECIPE_ID;
		COOKING_DC = cOOKING_DC;
	}
	
	
}
