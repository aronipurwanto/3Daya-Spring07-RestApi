package com.eksad.pos.dao;

import java.util.List;

import com.eksad.pos.model.SupplierModel;

public interface SupplierDao {
	public List<SupplierModel> getList();
	public List<SupplierModel> search(String key);
	public SupplierModel getById(Integer id);
	public void insert(SupplierModel model);
	public void update(SupplierModel model);
	public void delete(SupplierModel model);
}
