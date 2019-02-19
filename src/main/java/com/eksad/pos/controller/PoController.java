package com.eksad.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PoController {
	
	@RequestMapping(value="/po")
	public String index(){
		return "/po/index";
	}
	
	@RequestMapping(value="/new-po")
	public String create(){
		return "/po/create";
	}
	
	@RequestMapping(value="/po/form-product")
	public String formProduct(){
		return "/po/_formProduct";
	}
	
	@RequestMapping(value="/po/edit")
	public String edit(){
		return "/po/edit";
	}
	
	@RequestMapping(value="/po/delete")
	public String delete(){
		return "/po/delete";
	}
	
	@RequestMapping(value="/po/detail")
	public String detail(){
		return "/po/detail";
	}
}
