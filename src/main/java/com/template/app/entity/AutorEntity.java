package com.template.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="AUTOR")
@SequenceGenerator(name = "AUTOR_ID_GENERATOR", sequenceName = "SE_AUTOR", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="AutorEntity.retrieveAll", query="Select distinct a from AutorEntity a")
}) 

public class AutorEntity implements IEntity<Long> {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTOR_ID_GENERATOR")	
	private Long id;
	
	@NotNull 
	@Size(min=2, max = 40)
	@Column
	private String name;
	
	@OneToMany (targetEntity = PostagemEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="autorEntity")
	private List<PostagemEntity> listPostagemEntity;
	

	public AutorEntity(Long id, String name, List<PostagemEntity> listPostagemEntity) {
		this.id = id;
		this.name = name;
		this.listPostagemEntity = listPostagemEntity;
	}

	public List<PostagemEntity> getListPostagemEntity() {
		return listPostagemEntity;
	}

	public void setListPostagemEntity(List<PostagemEntity> listPostagemEntity) {
		this.listPostagemEntity = listPostagemEntity;
	}

	public AutorEntity() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

}
