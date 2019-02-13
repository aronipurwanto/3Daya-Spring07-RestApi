package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.PoModel;

public interface PoService {
	public List<PoModel> getList();
	public List<PoModel> search(String key);
	public PoModel getById(Integer id);
	public void insert(PoModel model);
	public void update(PoModel model);
	public void delete(PoModel model);
}
