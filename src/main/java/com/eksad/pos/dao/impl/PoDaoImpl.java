package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.PoDao;
import com.eksad.pos.model.PoModel;

@Repository
public class PoDaoImpl implements PoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PoModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select jt from PoModel jt order by jt.code";
		Query query = session.createQuery(hql);
		List<PoModel> result = query.getResultList();
		return result;
	}

	@Override
	public PoModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select jt from PoModel jt where jt.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PoModel result = (PoModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(PoModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(PoModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PoModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<PoModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from PoModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

}
