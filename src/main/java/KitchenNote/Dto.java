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
	@Override
	public String toString() {
		return "Dto [ing_category=" + ing_category + ", category_name=" + category_name + ", ing_id=" + ing_id
				+ ", ing_name=" + ing_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category_name == null) ? 0 : category_name.hashCode());
		result = prime * result + ing_category;
		result = prime * result + ((ing_name == null) ? 0 : ing_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dto other = (Dto) obj;
		if (category_name == null) {
			if (other.category_name != null)
				return false;
		} else if (!category_name.equals(other.category_name))
			return false;
		if (ing_category != other.ing_category)
			return false;
		if (ing_name == null) {
			if (other.ing_name != null)
				return false;
		} else if (!ing_name.equals(other.ing_name))
			return false;
		return true;
	}
	
	
	
	
	
	
}
