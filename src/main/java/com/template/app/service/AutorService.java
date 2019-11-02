package com.template.app.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.template.app.entity.AutorEntity;
import com.template.app.service.repository.AutorRepository;

@Stateless
@Local
public class AutorService {
	
	@Inject
	private AutorRepository autorRepository;

	public List<AutorEntity> retrieveAll() {			
		System.out.println("service");
		List<AutorEntity> autorList = autorRepository.retrieveAll();		
		return autorList;
			
	}
	public AutorEntity get(Long id) {
		System.out.println("service");
		AutorEntity a = autorRepository.get(id);
		return a;
	}
	public AutorEntity create(AutorEntity autorEntity) {
		return autorRepository.persist(autorEntity);
		
	}
	public void delete(AutorEntity autorEntity) {
		autorRepository.delete(autorEntity);
		
	}	
}