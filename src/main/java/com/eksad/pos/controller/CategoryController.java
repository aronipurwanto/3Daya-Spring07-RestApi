package com.eksad.pos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.pos.model.CategoryModel;
import com.eksad.pos.service.CategoryService;

@Controller
public class CategoryController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value="/category")
	public String index(){
		return "/category/index";
	}
	
	@RequestMapping(value="/category/create")
	public String create(){
		return "/category/create";
	}
	
	@RequestMapping(value="/category/edit")
	public String edit(){
		return "/category/edit";
	}
	
	@RequestMapping(value="/category/delete")
	public String delete(){
		return "/category/delete";
	}
	
	@RequestMapping(value="/category/detail")
	public String detail(){
		return "/category/detail";
	}
}
