package com.eksad.pos.dao;

import java.util.List;

import com.eksad.pos.model.PoDetailModel;

public interface PoDetailDao {
	public List<PoDetailModel> getList();
	public List<PoDetailModel> search(String key);
	public PoDetailModel getById(Integer id);
	public void insert(PoDetailModel model);
	public void update(PoDetailModel model);
	public void delete(PoDetailModel model);
	public void delete(Integer poId);
}
