package com.eksad.pos.dao;

import java.util.List;

import com.eksad.pos.model.ProductModel;

public interface ProductDao {
	public List<ProductModel> getList();
	public List<ProductModel> search(String key);
	public ProductModel getById(Integer id);
	public void insert(ProductModel model);
	public void update(ProductModel model);
	public void delete(ProductModel model);
}
