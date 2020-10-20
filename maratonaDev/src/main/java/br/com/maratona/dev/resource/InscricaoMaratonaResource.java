package br.com.maratona.dev.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path(value = "/inscricao")
public class InscricaoMaratonaResource {

	@Inject
	IncriscaoHelper incriscaoHelper;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("lista/inscritos")
	public List<Pessoa> matricula() {
		incriscaoHelper.init();
		return incriscaoHelper.getPessoas();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find/inscrito/{id}")
	public Response matriculaPorId(@PathParam("id") String id){
		Pessoa objetoRetorno;
		
		try {
			objetoRetorno = incriscaoHelper.findPessoa(new Integer(id));
		}catch (NumberFormatException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro na solicitação!").build();
		}
		
		if(objetoRetorno != null) {
			return Response.status(Status.OK).entity(objetoRetorno).build();
		}else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cadastrar/inscrito/")
	public Response cadastrar(Pessoa pessoa){
		incriscaoHelper.init();
		pessoa.setMatricula(incriscaoHelper.getPessoas().size()+1);
		incriscaoHelper.pessoas.add(pessoa);
		return Response.status(Status.CREATED).entity("Inscrito com sucesso!").build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("alterar/inscrito/")
	public Response alterar(Pessoa pessoa){
		incriscaoHelper.init();
		Pessoa pessoaEdit = null;
		for (Pessoa indice: incriscaoHelper.pessoas) {
			if(indice.getMatricula().equals(pessoa.getMatricula())) {
				pessoaEdit = indice;			
			}
		}
		if(pessoaEdit != null) {
			pessoaEdit.setNome(pessoa.getNome());
			return Response.status(Status.OK).entity(pessoaEdit).build();
		}else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("remover/inscrito/{id}")
	public Response removerPorId(@PathParam("id") String id){
		incriscaoHelper.init();
		Pessoa remove = null;
		for (Pessoa indice:incriscaoHelper.pessoas) {
			if(indice.getMatricula().equals(new Integer(id))) {
				remove = indice;			
			}
		}
		if( incriscaoHelper.pessoas.remove(remove)) {
			return Response.status(Status.OK).entity("Removido com sucesso!").build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}	
}
