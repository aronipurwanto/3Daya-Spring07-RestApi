package com.eksad.pos.dao;

import java.util.List;

import com.eksad.pos.model.PackageModel;

public interface PackageDao {
	public List<PackageModel> getList();
	public List<PackageModel> search(String key);
	public PackageModel getById(Integer id);
	public void insert(PackageModel model);
	public void update(PackageModel model);
	public void delete(PackageModel model);
}
