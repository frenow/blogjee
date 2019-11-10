package com.template.app.rest.autor;

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
import com.template.app.service.AutorService;
import com.template.app.service.PostagemService;

@Path("/autor")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AutorRest {

	@Inject
	private AutorService autorService;
		
	@GET
	@Path("/all")
	public List<AutorEntity> getAllAutores() throws AppException{
				
		List<AutorEntity> listAutores = autorService.retrieveAll();
		return listAutores;
	}
	
	@POST
	@Path("/create")
	public AutorEntity create(AutorEntity autorEntity) throws AppException{
		return autorService.create(autorEntity);
	}
	@DELETE
	@Path("/delete")
	public void delete(AutorEntity autorEntity) throws AppException{
		autorService.delete(autorEntity);
	}
	
	@GET
	@Path("/{id}")
	public AutorEntity get( @PathParam("id") Long entityId) throws AppException {
		AutorEntity a =  autorService.get(entityId);
		return a;
	}	

}
