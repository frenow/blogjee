package com.template.app.service.repository;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.template.app.entity.PostagemEntity;
import com.template.app.exception.AppException;
import com.template.app.messages.AppBeanMessages;

@Stateless
@Local
public class PostagemRepository {

	@PersistenceContext(unitName = "blog-persistence-unit")
	private EntityManager entityManager;

	private EntityManager getEntityManager()
	{
		return entityManager;
	}	
	
	public List<PostagemEntity> retrieveAll() {
		try {
			System.out.println("repository");
			String namedQuery = "PostagemEntity.retrieveAll";
			
			Query query = getEntityManager().createNamedQuery(namedQuery);

			List<PostagemEntity> list = (List<PostagemEntity>)query.getResultList( );
			return list;

		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}	

	public PostagemEntity get(Long id) {
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery q = cb.createQuery(PostagemEntity.class);
			Root o = q.from(PostagemEntity.class);
			//o.fetch("postagem", JoinType.LEFT);
			q.select(o);
			q.where(cb.equal(o.get("id"), id));
			PostagemEntity p = (PostagemEntity)getEntityManager().createQuery(q).getSingleResult();	
			return p;

		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
	
	public PostagemEntity persist(PostagemEntity postagemEntity) {
		try {
			getEntityManager().persist(postagemEntity);
			return postagemEntity;
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}		
	}

	public void delete(PostagemEntity postagemEntity) {
		try {
			getEntityManager().remove(postagemEntity);
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}		
	}

}
