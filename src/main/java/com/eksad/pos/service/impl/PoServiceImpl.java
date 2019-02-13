package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.PoDao;
import com.eksad.pos.model.PoModel;
import com.eksad.pos.service.PoService;

@Service
@Transactional
public class PoServiceImpl implements PoService {
	@Autowired
	private PoDao dao;
	
	@Override
	public List<PoModel> getList() {
		return this.dao.getList();
	}

	@Override
	public PoModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(PoModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(PoModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(PoModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<PoModel> search(String key) {
		return this.dao.search(key);
	}
}
