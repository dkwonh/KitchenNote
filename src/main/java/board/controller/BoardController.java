package board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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


@Controller
public class BoardController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@Autowired
	CustomRecipeInfoService service;

	@Autowired
	UploadService uploadService;

	@RequestMapping(value = "jsp/home.do", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("dto", service.selectAll());
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

}
