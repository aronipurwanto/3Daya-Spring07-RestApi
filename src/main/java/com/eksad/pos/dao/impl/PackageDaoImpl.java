package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.PackageDao;
import com.eksad.pos.model.PackageModel;

@Repository
public class PackageDaoImpl implements PackageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PackageModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select jt from PackageModel jt order by jt.code";
		Query query = session.createQuery(hql);
		List<PackageModel> result = query.getResultList();
		return result;
	}

	@Override
	public PackageModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select jt from PackageModel jt where jt.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PackageModel result = (PackageModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(PackageModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(PackageModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PackageModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<PackageModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from PackageModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

}
