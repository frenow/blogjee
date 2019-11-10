package com.template.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="COMENTARIO")
@SequenceGenerator(name = "COMENTARIO_ID_GENERATOR", sequenceName = "SE_COMENTARIO", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="ComentarioEntity.retrieveAll", query="Select distinct c from ComentarioEntity c order by c.data desc")
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
	
	@Column
	private Date data;
	
    @ManyToOne (targetEntity = PostagemEntity.class)  
    @JoinColumn(name="POSTAGEM_ID", referencedColumnName="ID")
    @XmlTransient
	private PostagemEntity postagemEntity;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	public ComentarioEntity(Long id, String comentario, Date data) {
		this.id = id;
		this.comentario = comentario;
		this.data = data;
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
