package com.example.livro;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/livraria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class LivroAppResource {
  
	@Inject
	private LivroBean livroBean;
  
	@Inject
	private JsonWebToken token;
	
	@Inject
	@Claim("custom-value")
	private String customValue;
	   
	@GET
    public String status() {
        return "successo";
    }	

    @Inject
    @Claim("roles")
    private List<String> roles;
    
    
    @POST
    @Path("/livros")
    @RolesAllowed("gerente")
    public void addLivro(Livro livro) {
        livroBean.add(livro);
    }

    @DELETE
    @Path("/livros/{id}")
    @RolesAllowed("gerente")
    public void deleteLivro(@PathParam("id") int id) {
        livroBean.delete(id);
    }

    @PUT
    @Path("/livros")
    @RolesAllowed("gerente")
    public void updateLivro(Livro livro) {
        livroBean.update(livro);
    }

    @GET
    @Path("/livros/{id}")
    @RolesAllowed("cliente")
    public Livro getLivro(@PathParam("id") int id) {
        return livroBean.get(id);
    }

    @GET
    @Path("/livros")
    @RolesAllowed("cliente")
    public List<Livro> getLivros() {
    	System.out.println("token user = " + token.getSubject());    	
    	System.out.println("custom value = " + customValue);
        return livroBean.getAll();
    }
 
}