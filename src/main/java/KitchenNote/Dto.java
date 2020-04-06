package KitchenNote;

public class Dto {
	public int ing_category;
	public String category_name;
	public int ing_id;
	public String ing_name;
	public int getIng_category() {
		return ing_category;
	}
	public void setIng_category(int ing_category) {
		this.ing_category = ing_category;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getIng_id() {
		return ing_id;
	}
	public void setIng_id(int ing_id) {
		this.ing_id = ing_id;
	}
	public String getIng_name() {
		return ing_name;
	}
	public void setIng_name(String ing_name) {
		this.ing_name = ing_name;
	}
	public Dto(int ing_category, String category_name, int ing_id, String ing_name) {
		super();
		this.ing_category = ing_category;
		this.category_name = category_name;
		this.ing_id = ing_id;
		this.ing_name = ing_name;
	}
	
	
}
