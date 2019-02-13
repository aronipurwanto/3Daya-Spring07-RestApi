package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.CategoryDao;
import com.eksad.pos.model.CategoryModel;
import com.eksad.pos.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao dao;
	
	@Override
	public List<CategoryModel> getList() {
		return this.dao.getList();
	}

	@Override
	public CategoryModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(CategoryModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(CategoryModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(CategoryModel model) {
		this.dao.delete(model);
	}
}
