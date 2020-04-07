package KitchenNote;

public class Ingredient {
	private int RECIPE_ID;
	private String IRDNT_CPCTY;
	private String IRDNT_NM;
	private int ing_id;

	
	
	public Ingredient() {
		super();
	}
	public int getIng_id() {
		return ing_id;
	}
	public void setIng_id(int ing_id) {
		this.ing_id = ing_id;
	}
	public int getRECIPE_ID() {
		return RECIPE_ID;
	}
	public void setRECIPE_ID(int rECIPE_ID) {
		RECIPE_ID = rECIPE_ID;
	}
	public String getIRDNT_CPCTY() {
		return IRDNT_CPCTY;
	}
	public void setIRDNT_CPCTY(String iRDNT_CPCTY) {
		IRDNT_CPCTY = iRDNT_CPCTY;
	}
	public String getIRDNT_NM() {
		return IRDNT_NM;
	}
	public void setIRDNT_NM(String iRDNT_NM) {
		IRDNT_NM = iRDNT_NM;
	}
	@Override
	public String toString() {
		return "Ingredient [RECIPE_ID=" + RECIPE_ID + ", IRDNT_CPCTY=" + IRDNT_CPCTY + ", IRDNT_NM=" + IRDNT_NM +","+ ing_id+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IRDNT_NM == null) ? 0 : IRDNT_NM.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (IRDNT_NM == null) {
			if (other.IRDNT_NM != null)
				return false;
		} else if (!IRDNT_NM.equals(other.IRDNT_NM))
			return false;
		return true;
	}
	public Ingredient(int rECIPE_ID, String iRDNT_CPCTY, String iRDNT_NM) {
		super();
		RECIPE_ID = rECIPE_ID;
		IRDNT_CPCTY = iRDNT_CPCTY;
		IRDNT_NM = iRDNT_NM;
	}
	
	
	
	
}
