package com.eksad.pos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.pos.model.CategoryModel;
import com.eksad.pos.service.CategoryService;

@Controller
public class CategoryController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value="/category/index")
	public String index(Model model){
		List<CategoryModel> list = this.service.getList();
		model.addAttribute("list",list);
		return "/category/index";
	}
	
	@RequestMapping(value="/api/category/list", method=RequestMethod.GET)
	public ResponseEntity<List<CategoryModel>> list(){
		ResponseEntity<List<CategoryModel>> result = null;
		try {
			List<CategoryModel> list = this.service.getList();
			result = new ResponseEntity<List<CategoryModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/category/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<CategoryModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<CategoryModel>> result = null;
		try {
			List<CategoryModel> list = this.service.search(cari);
			result = new ResponseEntity<List<CategoryModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/category/get/{catId}")
	public ResponseEntity<CategoryModel> getById(@PathVariable("catId") int vId){
		ResponseEntity<CategoryModel> result = null;
		try {
			CategoryModel cat = this.service.getById(vId);
			result = new ResponseEntity<CategoryModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
