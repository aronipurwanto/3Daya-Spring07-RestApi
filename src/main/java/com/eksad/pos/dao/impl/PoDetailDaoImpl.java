package com.eksad.pos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eksad.pos.dao.PoDetailDao;
import com.eksad.pos.model.PoDetailModel;

@Repository
public class PoDetailDaoImpl implements PoDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PoDetailModel> getList() {
		Session session = sessionFactory.getCurrentSession();
		// HQl => Hibernate Query language
		// Hibernate => ORM ( Object Relation Mapping )
		String hql = "select jt from PoDetailModel jt order by jt.code";
		Query query = session.createQuery(hql);
		List<PoDetailModel> result = query.getResultList();
		return result;
	}

	@Override
	public PoDetailModel getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select jt from PoDetailModel jt where jt.id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		PoDetailModel result = (PoDetailModel)query.getSingleResult();
		return result;
	}

	@Override
	public void insert(PoDetailModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);	
	}

	@Override
	public void update(PoDetailModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PoDetailModel model) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

	@Override
	public List<PoDetailModel> search(String key) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select x from PoDetailModel x where x.name like :keySearch order by x.code";
		Query query = session.createQuery(hql);
		query.setParameter("keySearch", "%"+key+"%");		
		return query.getResultList();
	}

	@Override
	public void delete(Integer poId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from PoDetailModel where poId=:poId";
		Query query = session.createQuery(hql);
		query.setParameter("poId", poId);
		int result = query.executeUpdate();
	}

}
