package br.com.jornada;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/carros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarroResource {

    @POST
    public void adicionarCarro(AdicionarCarro adicionarCarro) {
        
    }

    @GET
    public List<Carro> buscarCarros() {
        return null;
    }

    @PUT
    @Path("{id}")
    public void atualizarCarro(@PathParam("id")Integer id, AtualizarCarro atualizarCarro) {

    }

    @DELETE
    @Path("{id}")
    public void apagarCarro(@PathParam("id")Integer id) {
        
    }
}