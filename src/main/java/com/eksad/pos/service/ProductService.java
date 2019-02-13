package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.ProductModel;

public interface ProductService {
	public List<ProductModel> getList();
	public List<ProductModel> search(String key);
	public ProductModel getById(Integer id);
	public void insert(ProductModel model);
	public void update(ProductModel model);
	public void delete(ProductModel model);
}
