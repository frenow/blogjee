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
@Table(name="COMENTARIO")
@SequenceGenerator(name = "COMENTARIO_ID_GENERATOR", sequenceName = "SE_COMENTARIO", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="ComentarioEntity.retrieveAll", query="Select distinct c from ComentarioEntity c")
}) 

public class ComentarioEntity implements IEntity<Long> {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMENTARIO_ID_GENERATOR")	
	private Long id;
	
	@NotNull 
	@Size(min=2, max = 200)
	@Column
	private String comentario;

	public ComentarioEntity(Long id, String comentario) {
		this.id = id;
		this.comentario = comentario;
	}

	public ComentarioEntity() {

	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
