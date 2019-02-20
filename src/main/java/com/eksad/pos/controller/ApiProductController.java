package com.eksad.pos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.pos.model.ProductModel;
import com.eksad.pos.service.ProductService;

@RestController
public class ApiProductController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private ProductService service;
	
	@GetMapping(value="/api/product/all")
	public List<ProductModel> getAll(){
		return this.service.getList();
	}
	
	@RequestMapping(value="/api/product/", method=RequestMethod.GET)
	public ResponseEntity<List<ProductModel>> list(){
		ResponseEntity<List<ProductModel>> result = null;
		try {
			List<ProductModel> list = this.service.getList();
			result = new ResponseEntity<List<ProductModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<ProductModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/product/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<ProductModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<ProductModel>> result = null;
		try {
			List<ProductModel> list = this.service.search(cari);
			result = new ResponseEntity<List<ProductModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<ProductModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<ProductModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<ProductModel> result = null;
		try {
			ProductModel cat = this.service.getById(vId);
			result = new ResponseEntity<ProductModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<ProductModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/", method=RequestMethod.POST)
	public ResponseEntity<ProductModel> postInsert(@RequestBody ProductModel item){
		ResponseEntity<ProductModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<ProductModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<ProductModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/", method=RequestMethod.PUT)
	public ResponseEntity<ProductModel> putUpdate(@RequestBody ProductModel item){
		ResponseEntity<ProductModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<ProductModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<ProductModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/product/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<ProductModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<ProductModel> result = null;
		try {
			ProductModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<ProductModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<ProductModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<ProductModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
