package com.template.app.rest.postagem;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.template.app.entity.AutorEntity;
import com.template.app.entity.PostagemEntity;
import com.template.app.exception.AppException;
import com.template.app.service.PostagemService;

@Path("/postagem")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class PostagemRest {
	
	@Inject
	private PostagemService postagemService;	
	
	@GET
	@Path("/all")
	public List<PostagemEntity> getAllEmployees() throws AppException{				
		List<PostagemEntity> listPostagens = postagemService.retrieveAll();
		return listPostagens;
	}	
	
	@GET
	@Path("/{id}")
	public PostagemEntity get( @PathParam("id") Long entityId) throws AppException {
		PostagemEntity p =  postagemService.get(entityId);
		return p;
	}
	
	@POST
	@Path("/create")
	public PostagemEntity create(PostagemEntity postagemEntity) throws AppException{
		return postagemService.create(postagemEntity);
	}
	@DELETE
	@Path("/delete")
	public void delete(PostagemEntity postagemEntity) throws AppException{
		postagemService.delete(postagemEntity);
	}


}
