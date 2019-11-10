package com.template.app.service.repository;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.template.app.entity.AutorEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;

@Stateless
@Local
public class AutorRepository {
	
	@PersistenceContext(unitName = "blog-persistence-unit")
	private EntityManager entityManager;

	private EntityManager getEntityManager()
	{
		return entityManager;
	}	
	
	public List<AutorEntity> retrieveAll() {
		try {
			System.out.println("repository");
			String namedQuery = "AutorEntity.retrieveAll";
			
			Query query = getEntityManager().createNamedQuery(namedQuery);

			List<AutorEntity> list = (List<AutorEntity>)query.getResultList( );
			return list;

		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	public AutorEntity get(Long id) {
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery q = cb.createQuery(AutorEntity.class);
			Root o = q.from(AutorEntity.class);
			o.fetch("listPostagemEntity", JoinType.LEFT);
			q.select(o);
			q.where(cb.equal(o.get("id"), id));

			AutorEntity a = (AutorEntity)getEntityManager().createQuery(q).getSingleResult();	

			return a;

		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public AutorEntity persist(AutorEntity autorEntity) {
		try {
			getEntityManager().persist(autorEntity);
			return autorEntity;
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}		
	}

	public void delete(AutorEntity autorEntity) {
		try {
			getEntityManager().remove(autorEntity);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
		
	}	
}
