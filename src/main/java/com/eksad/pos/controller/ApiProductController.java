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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.pos.model.PackageModel;
import com.eksad.pos.service.PackageService;

@Controller
public class ApiProductController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PackageService service;
	
	@RequestMapping(value="/product/index")
	public String index(Model model){
		List<PackageModel> list = this.service.getList();
		model.addAttribute("list",list);
		return "/product/index";
	}
	
	@RequestMapping(value="/api/product/", method=RequestMethod.GET)
	public ResponseEntity<List<PackageModel>> list(){
		ResponseEntity<List<PackageModel>> result = null;
		try {
			List<PackageModel> list = this.service.getList();
			result = new ResponseEntity<List<PackageModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<PackageModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/product/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<PackageModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<PackageModel>> result = null;
		try {
			List<PackageModel> list = this.service.search(cari);
			result = new ResponseEntity<List<PackageModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<PackageModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<PackageModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<PackageModel> result = null;
		try {
			PackageModel cat = this.service.getById(vId);
			result = new ResponseEntity<PackageModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<PackageModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/", method=RequestMethod.POST)
	public ResponseEntity<PackageModel> postInsert(@RequestBody PackageModel item){
		ResponseEntity<PackageModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<PackageModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PackageModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/", method=RequestMethod.PUT)
	public ResponseEntity<PackageModel> putUpdate(@RequestBody PackageModel item){
		ResponseEntity<PackageModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<PackageModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PackageModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<PackageModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<PackageModel> result = null;
		try {
			PackageModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<PackageModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<PackageModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<PackageModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
