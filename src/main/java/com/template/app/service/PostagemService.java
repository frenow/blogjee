package com.template.app.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.PostagemEntity;
import com.template.app.service.repository.PostagemRepository;

@Stateless
@Local
public class PostagemService {
	
	@Inject
	private PostagemRepository postagemRepository;

	public List<PostagemEntity> retrieveAll() {			
		System.out.println("service");
		List<PostagemEntity> postagemEntity = postagemRepository.retrieveAll();
		
		return postagemEntity;	
	}
	
	public PostagemEntity get(Long id) {
		System.out.println("service");
		PostagemEntity p = postagemRepository.get(id);
		return p;
	}	
	
	public PostagemEntity create(PostagemEntity postagemEntity) {
		return postagemRepository.persist(postagemEntity);
		
	}
	public void delete(PostagemEntity postagemEntity) {
		postagemRepository.delete(postagemEntity);		
	}

}