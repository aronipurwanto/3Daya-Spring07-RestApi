package com.eksad.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@RequestMapping(value="/product")
	public String index(){
		return "/product/index";
	}
	
	@RequestMapping(value="/product/create")
	public String create(){
		return "/product/create";
	}
	
	@RequestMapping(value="/product/edit")
	public String edit(){
		return "/product/edit";
	}
	
	@RequestMapping(value="/product/delete")
	public String delete(){
		return "/product/delete";
	}
	
	@RequestMapping(value="/product/detail")
	public String detail(){
		return "/product/detail";
	}
}
