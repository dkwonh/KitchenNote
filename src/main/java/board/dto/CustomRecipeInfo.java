package board.dto;

//커스텀 레시피 기본정보 
public class CustomRecipeInfo {

 // 레시피아이디 
private int recipe_Id;

 // 배너이미지 
 private String image;

 // 동영상URL 
 private String media_Url;
 private String member_Id;


 // 조회수 
 private int readcount;

 // 스크랩 
 private int scrap;

 // 레시피가격 
 private int price;

 // 임시저장 
 private Boolean temp;

 // 레시피 이름 
 private String recipe_Name;
 private String recipe_Exp;
 
 //필요시간
 private String duration;
 
 private String nickname;


 public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getDuration() {
	return duration;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public String getImage() {
     return image;
 }

 public void setImage(String image) {
     this.image = image;
 }



 public int getReadcount() {
     return readcount;
 }

 public void setReadcount(int readcount) {
     this.readcount = readcount;
 }

 public int getScrap() {
     return scrap;
 }

 public void setScrap(int scrap) {
     this.scrap = scrap;
 }


 public int getPrice() {
     return price;
 }

 public void setPrice(int price) {
     this.price = price;
 }

 public Boolean getTemp() {
     return temp;
 }

 public void setTemp(Boolean temp) {
     this.temp = temp;
 }

public int getRecipe_Id() {
	return recipe_Id;
}

public void setRecipe_Id(int recipe_Id) {
	this.recipe_Id = recipe_Id;
}

public String getMedia_Url() {
	return media_Url;
}

public void setMedia_Url(String media_Url) {
	this.media_Url = media_Url;
}

public String getMember_Id() {
	return member_Id;
}

public void setMember_Id(String member_Id) {
	this.member_Id = member_Id;
}


public String getRecipe_Name() {
	return recipe_Name;
}

public void setRecipe_Name(String recipe_Name) {
	this.recipe_Name = recipe_Name;
}

public String getRecipe_Exp() {
	return recipe_Exp;
}

public void setRecipe_Exp(String recipe_Exp) {
	this.recipe_Exp = recipe_Exp;
}




}