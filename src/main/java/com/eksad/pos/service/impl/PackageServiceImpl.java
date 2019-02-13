package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.PackageDao;
import com.eksad.pos.model.PackageModel;
import com.eksad.pos.service.PackageService;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {
	@Autowired
	private PackageDao dao;
	
	@Override
	public List<PackageModel> getList() {
		return this.dao.getList();
	}

	@Override
	public PackageModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(PackageModel model) {
		this.dao.insert(model);
	}

	@Override
	public void update(PackageModel model) {
		this.dao.update(model);
	}

	@Override
	public void delete(PackageModel model) {
		this.dao.delete(model);
	}

	@Override
	public List<PackageModel> search(String key) {
		return this.dao.search(key);
	}
}
