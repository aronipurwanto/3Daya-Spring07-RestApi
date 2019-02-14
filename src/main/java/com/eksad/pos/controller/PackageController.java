package com.eksad.pos.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PackageController {
	
	@RequestMapping(value="/package")
	public String index(){
		return "/package/index";
	}
	
	@RequestMapping(value="/package/create")
	public String create(){
		return "/package/create";
	}
	
	@RequestMapping(value="/package/edit")
	public String edit(){
		return "/package/edit";
	}
	
	@RequestMapping(value="/package/delete")
	public String delete(){
		return "/package/delete";
	}
	
	@RequestMapping(value="/package/detail")
	public String detail(){
		return "/package/detail";
	}
}
