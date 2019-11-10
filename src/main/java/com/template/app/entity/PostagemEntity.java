package com.template.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import javax.xml.bind.annotation.XmlTransient;

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
	
    @ManyToOne (targetEntity = AutorEntity.class)  
    @JoinColumn(name="AUTOR_ID", referencedColumnName="ID")
    @XmlTransient
	private AutorEntity autorEntity;
    
	@OneToMany (targetEntity = ComentarioEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="postagemEntity")
    private List<ComentarioEntity> listComentarioEntity; 
    
	public PostagemEntity(Long id, String postagem, AutorEntity autorEntity,
			List<ComentarioEntity> listComentarioEntity) {
		this.id = id;
		this.postagem = postagem;
		this.autorEntity = autorEntity;
		this.listComentarioEntity = listComentarioEntity;
	}

	public List<ComentarioEntity> getListComentarioEntity() {
		return listComentarioEntity;
	}

	public void setListComentarioEntity(List<ComentarioEntity> listComentarioEntity) {
		this.listComentarioEntity = listComentarioEntity;
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}

	public void setAutorEntity(AutorEntity autorEntity) {
		this.autorEntity = autorEntity;
	}

	public PostagemEntity() {
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
