package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.ProductDao;
import com.eksad.pos.model.ProductModel;
import com.eksad.pos.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	
	@Override
	public List<ProductModel> getList() {
		return this.dao.getList();
	}

	@Override
	public ProductModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(ProductModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(ProductModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(ProductModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<ProductModel> search(String key) {
		return this.dao.search(key);
	}
}
