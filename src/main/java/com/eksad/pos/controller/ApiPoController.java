package com.eksad.pos.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.pos.model.PoModel;
import com.eksad.pos.service.PoService;

@Controller
public class ApiPoController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private PoService service;
	
	@RequestMapping(value="/api/po/", method=RequestMethod.GET)
	public ResponseEntity<List<PoModel>> list(){
		ResponseEntity<List<PoModel>> result = null;
		try {
			List<PoModel> list = this.service.getList();
			result = new ResponseEntity<List<PoModel>>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<List<PoModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return result;
	}
	
	@RequestMapping(value="/api/po/search/{katakunci}",method=RequestMethod.GET)
	public ResponseEntity<List<PoModel>> search(@PathVariable("katakunci") String cari){
		ResponseEntity<List<PoModel>> result = null;
		try {
			List<PoModel> list = this.service.search(cari);
			result = new ResponseEntity<List<PoModel>>(list,HttpStatus.OK);
		} catch (Exception err) {
			log.debug(err.getMessage(),err);
			result = new ResponseEntity<List<PoModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<PoModel> getById(@PathVariable("itemId") int vId){
		ResponseEntity<PoModel> result = null;
		try {
			PoModel cat = this.service.getById(vId);
			result = new ResponseEntity<PoModel>(cat,HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/", method=RequestMethod.POST)
	public ResponseEntity<PoModel> postInsert(@RequestBody PoModel item){
		ResponseEntity<PoModel> result = null;
		try {
			this.service.insert(item);
			result = new ResponseEntity<PoModel>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/", method=RequestMethod.PUT)
	public ResponseEntity<PoModel> putUpdate(@RequestBody PoModel item){
		ResponseEntity<PoModel> result = null;
		try {
			this.service.update(item);
			result = new ResponseEntity<PoModel>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.debug(e.getMessage(),e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/api/po/{itemId}", method=RequestMethod.DELETE)
	public ResponseEntity<PoModel> delApi(@PathVariable("itemId") Integer vid){
		ResponseEntity<PoModel> result = null;
		try {
			PoModel item = this.service.getById(vid);
			if(item != null){
				this.service.delete(item);
				result = new ResponseEntity<PoModel>(item,HttpStatus.ACCEPTED);
			}else {
				result = new ResponseEntity<PoModel>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.debug(e.getMessage(), e);
			result = new ResponseEntity<PoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
