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
import com.template.app.entity.ComentarioEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;

@Stateless
@Local
public class ComentarioRepository {

	@PersistenceContext(unitName = "blog-persistence-unit")
	private EntityManager entityManager;

	private EntityManager getEntityManager()
	{
		return entityManager;
	}	

	public List<ComentarioEntity> retrieveAll() {
		try {
			System.out.println("repository");
			String namedQuery = "ComentarioEntity.retrieveAll";
			
			Query query = getEntityManager().createNamedQuery(namedQuery);

			List<ComentarioEntity> list = (List<ComentarioEntity>)query.getResultList( );
			return list;

		} catch (AppException e) {
			System.out.println("erro 1"+e);
			throw e;
		} catch (Exception e) {
			System.out.println("erro 2"+e);
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	public ComentarioEntity get(Long id) {
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery q = cb.createQuery(AutorEntity.class);
			Root o = q.from(AutorEntity.class);
			o.fetch("comentarios", JoinType.LEFT);
			q.select(o);
			q.where(cb.equal(o.get("id"), id));

			ComentarioEntity c = (ComentarioEntity)getEntityManager().createQuery(q).getSingleResult();	

			return c;

		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

	public ComentarioEntity persist(ComentarioEntity comentarioEntity) {
		try {
			getEntityManager().persist(comentarioEntity);
			return comentarioEntity;
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}		
	}

	public void delete(ComentarioEntity comentarioEntity) {
		try {
			getEntityManager().remove(comentarioEntity);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}		
	}	

}
