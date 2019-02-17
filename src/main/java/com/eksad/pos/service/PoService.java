package com.eksad.pos.service;

import java.util.List;

import com.eksad.pos.model.PoModel;
import com.eksad.pos.model.PoPojo;

public interface PoService {
	public List<PoModel> getList();
	public List<PoModel> search(String key);
	public PoModel getById(Integer id);
	public void insert(PoPojo model);
	public void update(PoPojo model);
	public void delete(PoModel model);
}
