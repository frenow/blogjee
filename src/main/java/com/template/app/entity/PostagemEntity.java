package com.template.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="POSTAGEM")
@SequenceGenerator(name = "POSTAGEM_ID_GENERATOR", sequenceName = "SE_POSTAGEM", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="PostagemEntity.retrieveAll", query="Select distinct p from PostagemEntity p")
}) 

public class PostagemEntity implements IEntity<Long> {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTAGEM_ID_GENERATOR")	
	private Long id;
	
	@NotNull 
	@Size(min=2, max = 800)
	@Column
	private String postagem;

	public PostagemEntity() {
	}

	public PostagemEntity(Long id, String postagem) {
		super();
		this.id = id;
		this.postagem = postagem;
	}

	public String getPostagem() {
		return postagem;
	}

	public void setPostagem(String postagem) {
		this.postagem = postagem;
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
