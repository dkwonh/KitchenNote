package board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import KitchenNote.Category;
import KitchenNote.Dto;
import KitchenNote.Ingredient;
import KitchenNote.JsonToDB;
import KitchenNote.NangbuDto;
import KitchenNote.Recipe_Info;
import KitchenNote.Recipe_Pro;
import KitchenNote.Selenium;
import board.dto.CategoryDto;
import board.dto.CustomRecipeInfo;

@Controller
public class BoardController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@Autowired
	CustomRecipeInfoService service;

	@Autowired
	UploadService uploadService;

	JsonToDB json;
	Selenium sel;

	// 메인화면
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String list(Model model) {

		
		  List<CustomRecipeInfo> list = service.selectAll(); List<Category>
		  categoryList = service.loadCategory(); List<NangbuDto> nangbuList =
		  service.getNangbuIngre(1); Map<Integer,String> nangbuCategory =
		  service.getNangCategory();
		  
		  model.addAttribute("nangbuList",nangbuList);
		  model.addAttribute("nangbuCategory",nangbuCategory);
		  
		  model.addAttribute("dto", list);
		  model.addAttribute("category1",categoryList.subList(0, 8));
		  model.addAttribute("category2",categoryList.subList(8, 16));
		  model.addAttribute("category3",categoryList.subList(16, 26));
		  model.addAttribute("category4",categoryList.subList(26, 36));
		 
		

		return "home/list";
	}

	// 냉부 첫화면
	@RequestMapping(value = "nangbu.do", method = RequestMethod.GET)
	public String nangbu(Model model) {
		List<NangbuDto> list = service.getNangbuIngre(1);
		Map<Integer, String> category = service.getNangCategory();
		model.addAttribute("category", category);
		model.addAttribute("dto", list);
		return "home/nangbu";
	}

	// 냉부 재료로 검색 화면
	@RequestMapping(value = "nangbu.do", method = RequestMethod.POST)
	public String nangbuSearch(@RequestParam("ingredients[]") int ingredients[], Model model) {
		List<CustomRecipeInfo> list = service.searchIngredient(ingredients);
		model.addAttribute("dto", list);
		return "home/searchList";
	}

	// 냉부 재료 리스트 출력 GSON
	@RequestMapping(value = "category.do", method = RequestMethod.GET)
	public void loadCategory(@RequestParam("ing_category") int ing_category, HttpServletResponse response)
			throws IOException {
		List<NangbuDto> list = service.getNangbuIngre(ing_category);
		Gson json = new Gson();
		response.setContentType("text/thml;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print(json.toJson(list));
	}

	// 레시피 검색 결과화면
	@RequestMapping(value = "home.do", method = RequestMethod.POST)
	public String search(String search, Model model) {
		List<CustomRecipeInfo> list = service.searchName(search);
		model.addAttribute("dto", list);
		return "home/searchList";
	}

	// 관리자 페이지
	@RequestMapping(value = "admin.do", method = RequestMethod.GET)
	public String adminMain() {
		return "admin/adminMain";
	}

	// 카테고리 리스트 출력 **안씀**
	@RequestMapping(value = "loadCategory.do", method = RequestMethod.GET)
	public void loadCategory(HttpServletResponse response) throws IOException {
		List<Category> list = service.loadCategory();
		Gson json = new Gson();
		response.setContentType("text/thml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJson(list));
	}

	// 카테고리로 검색 화면
	@RequestMapping(value = "searchCategory.do", method = RequestMethod.GET)
	public String searchCategory(CategoryDto category, Model model) throws IOException {
		List<Integer> integer = new ArrayList<>();
		int[] cate = { category.getCategory1(), category.getCategory2(), category.getCategory3(),
				category.getCategory4() };
		for (int i : cate) {
			if (i > 0) {
				integer.add(i);
			}
		}
		int[] c = new int[integer.size()];

		for (int j = 0; j < integer.size(); j++) {
			c[j] = integer.get(j);
		}

		List<CustomRecipeInfo> list = service.searchCategory(c);
		model.addAttribute("dto", list);
		return "home/searchList";
	}

	/*
	 * @RequestMapping(value = "jsp/write.do", method = RequestMethod.GET) public
	 * String writeForm() { return "jsp/write"; }
	 * 
	 * @RequestMapping(value = "jsp/write.do", method = RequestMethod.POST) public
	 * String insert(@RequestParam("image") MultipartFile image, Model model,
	 * BoardDto dto, HttpServletRequest request) throws IOException {
	 * dto.setReg_date(new Timestamp(System.currentTimeMillis()));
	 * dto.setIp(request.getRemoteAddr());
	 * dto.setRecipe_image_name(image.getOriginalFilename()); String path =
	 * context.getServletContext().getRealPath("/images");
	 * dto.setRecipe_image_path(uploadService.save(path, image)); int i =
	 * service.insert(dto); model.addAttribute(dto); if (i > 0) { return
	 * "jsp/insert"; } else { return "jsp/error"; } }
	 * 
	 * @RequestMapping(value = "jsp/listItem.do", method = RequestMethod.GET) public
	 * String listItem(Model model, int num) { model.addAttribute("dto",
	 * service.selectAll()); return "jsp/listItem"; }
	 * 
	 * @RequestMapping(value = "jsp/update.do", method = RequestMethod.GET) public
	 * String updateForm(Model model, int num) { model.addAttribute("dto",
	 * service.selectAll()); return "jsp/updateForm"; }
	 * 
	 * @RequestMapping(value = "jsp/update.do", method = RequestMethod.POST) public
	 * String update(@RequestParam("image") MultipartFile image, Model model,
	 * BoardDto dto) throws IOException {
	 * dto.setRecipe_image_name(image.getOriginalFilename()); String path =
	 * context.getServletContext().getRealPath("/images"); String fileName =
	 * service.selectOne(dto.getNum()).getRecipe_image_name();
	 * 
	 * dto.setRecipe_image_path(uploadService.save(path, image)); int i =
	 * service.update(dto); File file = new File(path,fileName); file.delete(); if
	 * (i > 0) { return "jsp/update"; } else { return "jsp/error"; } }
	 * 
	 * @RequestMapping(value = "jsp/delete.do", method = RequestMethod.POST) public
	 * String deleteForm(int num, String passwd) { Map<String, Object> map = new
	 * HashMap<>(); map.put("num", num); map.put("passwd", passwd); String fileName
	 * = service.selectOne(num).getRecipe_image_name(); File file = new
	 * File(context.getServletContext().getRealPath("/images"),fileName);
	 * file.delete();
	 * 
	 * int i = service.delete(map); if (i > 0) { return "jsp/delete"; } else {
	 * return "jsp/error"; } }
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

	/*
	 * 재료 테이블 삽입 코드 sel = new Selenium(); Set<Dto> set = sel.crawl(); for(Dto dto :
	 * set) { service.insertIngre(dto); }
	 */

	/*
	 * 카테고리 삽입 코드 sel = new Selenium(); List<Category> cate = sel.getCategory();
	 * for(Category c : cate) { service.insertCategory(c); }
	 */

	/*
	 * 기본레시피 삽입 코드 jtd = new JsonToDB(); List<Recipe_Info> list = jtd.recipe_in();
	 * for(Recipe_Info info : list) { service.insert(info); }
	 */

	/*
	 * 레시피 재료 삽입 코드 json = new JsonToDB(); List<Ingredient> list; List<Ingredient>
	 * m_list = new ArrayList<>(); list = json.ingredient(); Set<Dto> misc = new
	 * HashSet<>(); int dummy = 0; int id = 4418; for(Ingredient ing : list) {
	 * List<Integer> i_list = service.ingId(ing.getIRDNT_NM()); if(i_list.isEmpty())
	 * { Dto dto = new Dto(20, "기타", id , ing.getIRDNT_NM()); Ingredient dient = new
	 * Ingredient(); dient.setRECIPE_ID(ing.getRECIPE_ID());
	 * dient.setIRDNT_CPCTY(ing.getIRDNT_CPCTY()); dient.setIng_id(id);
	 * m_list.add(dient); misc.add(dto); id++; } else {
	 * ing.setIng_id(i_list.get(0)); service.ingInsert(ing);
	 * System.out.println(ing); } }
	 * 
	 * for(Dto dto : misc) { service.insertIngre(dto); System.out.println(dto); }
	 * 
	 * for(Ingredient in : m_list) { service.ingInsert(in); System.out.println(in);
	 * }
	 */

	/*
	 * 레시피 과정 삽입 코드 json = new JsonToDB(); List<Recipe_Pro> list = new
	 * ArrayList<>(); list = json.recipe_pro();
	 * 
	 * for(Recipe_Pro pro : list) { //System.out.println(pro);
	 * if(pro.getSTRE_STEP_IMAGE_URL()==null) {
	 * pro.setSTRE_STEP_IMAGE_URL("default.jsp"); }
	 * 
	 * List<Recipe_Info> recipe = service.selectRecipe(pro.getRECIPE_ID());
	 * if(recipe.isEmpty()) continue; System.out.println(pro.getRECIPE_ID());
	 * service.insertPro(pro); }
	 */

}
