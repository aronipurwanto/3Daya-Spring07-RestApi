package com.eksad.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eksad.pos.dao.PoDao;
import com.eksad.pos.dao.PoDetailDao;
import com.eksad.pos.model.PoDetailModel;
import com.eksad.pos.model.PoModel;
import com.eksad.pos.model.PoPojo;
import com.eksad.pos.service.PoService;

@Service
@Transactional
public class PoServiceImpl implements PoService {
	@Autowired
	private PoDao dao;

	@Autowired
	private PoDetailDao detailDao;

	@Override
	public List<PoModel> getList() {
		return this.dao.getList();
	}

	@Override
	public PoModel getById(Integer id) {
		return this.dao.getById(id);
	}

	@Override
	public void insert(PoPojo model) {
		PoModel po = model.getPo();
		this.dao.insert(po);
		if (model.getDetail() != null) {
			for (PoDetailModel detail : model.getDetail()) {
				detail.setPoId(po.getId());
				this.detailDao.insert(detail);
			}
		}
	}

	@Override
	public void update(PoPojo model) {
		PoModel po = model.getPo();	
		// update po
		this.dao.update(po);
		// delete po detail dahulu
		this.detailDao.delete(po.getId());
		// input ulang detail
		if (model.getDetail() != null) {
			for (PoDetailModel detail : model.getDetail()) {
				detail.setPoId(po.getId());
				this.detailDao.insert(detail);
			}
		}
	}

	@Override
	public void delete(PoModel model) {
		// delete po detail dahulu
		this.detailDao.delete(model.getId());
		// kemudian delete po
		this.dao.delete(model);
	}

	@Override
	public List<PoModel> search(String key) {
		return this.dao.search(key);
	}
}
