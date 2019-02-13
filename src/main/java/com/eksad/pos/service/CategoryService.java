package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.CategoryModel;

public interface CategoryService {
	public List<CategoryModel> getList();
	public CategoryModel getById(Integer id);
	public void insert(CategoryModel model);
	public void update(CategoryModel model);
	public void delete(CategoryModel model);
}
