package board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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

import KitchenNote.Dto;
import KitchenNote.Ingredient;
import KitchenNote.JsonToDB;
import KitchenNote.Recipe_Info;
import KitchenNote.Recipe_Pro;
import KitchenNote.Selenium;


@Controller
public class BoardController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@Autowired
	CustomRecipeInfoService service;

	@Autowired
	UploadService uploadService;
	
	JsonToDB json;

	@RequestMapping(value = "jsp/home.do", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("dto", service.selectAll());
		
		json = new JsonToDB();
		List<Recipe_Pro> list = new ArrayList<>();
		list = json.recipe_pro();
		
		for(Recipe_Pro pro : list) {
			//System.out.println(pro);
			if(pro.getSTRE_STEP_IMAGE_URL()==null) {
				pro.setSTRE_STEP_IMAGE_URL("default.jsp");
			}
			
			List<Recipe_Info> recipe = service.selectRecipe(pro.getRECIPE_ID());
			if(recipe.isEmpty())
				continue;
			System.out.println(pro.getRECIPE_ID());
			service.insertPro(pro);
		}
		
		return "home/list";
	}
	
	@RequestMapping(value = "jsp/home.do", method = RequestMethod.POST)
	public String search(String search, Model model) {
		model.addAttribute("dto", search);
		return "home/searchList";
	}
	
	@RequestMapping(value="jsp/admin.do", method=RequestMethod.GET)
	public String adminMain() {
		return "admin/adminMain";
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
	
	/*재료 테이블 삽입 코드
	 sel = new Selenium();
		Set<Dto> set = sel.crawl();
		for(Dto dto : set) { service.insertIngre(dto); }
		*/
	
	/*기본레시피 삽입 코드
	 * jtd = new JsonToDB(); List<Recipe_Info> list = jtd.recipe_in();
	 * for(Recipe_Info info : list) { service.insert(info); }
	 */
	
	/* 레시피 재료 삽입 코드
	 * json = new JsonToDB(); List<Ingredient> list; List<Ingredient> m_list = new
	 * ArrayList<>(); list = json.ingredient(); Set<Dto> misc = new HashSet<>(); int
	 * dummy = 0; int id = 4418; for(Ingredient ing : list) { List<Integer> i_list =
	 * service.ingId(ing.getIRDNT_NM()); if(i_list.isEmpty()) { Dto dto = new
	 * Dto(20, "기타", id , ing.getIRDNT_NM()); Ingredient dient = new Ingredient();
	 * dient.setRECIPE_ID(ing.getRECIPE_ID());
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
	
	/*레시피 과정 삽입 코드
	 * json = new JsonToDB(); List<Recipe_Pro> list = new ArrayList<>(); list =
	 * json.recipe_pro();
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
