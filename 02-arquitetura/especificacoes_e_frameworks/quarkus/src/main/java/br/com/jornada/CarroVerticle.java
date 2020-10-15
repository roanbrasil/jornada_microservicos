package br.com.jornada;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

@ApplicationScoped
public class CarroVerticle {

    public void init(@Observes Router router) {
        router.get("/carros").handler(this::buscarCarros);
        router.route("/carros*").handler(BodyHandler.create());
        router.post("/carros").handler(this::adicionarCarro);
        router.put("/carros/:id").handler(this::atualizarCarro);
        router.delete("/carros/:id").handler(this::apagarCarro);
    }

    private void adicionarCarro(RoutingContext routingContext) {
        AdicionarCarro adicionarCarro = Json.decodeValue(routingContext.getBodyAsString(),
            AdicionarCarro.class);
        System.out.println("CarroVerticle.adicionarCarro() "+adicionarCarro);
    }
    
    private void buscarCarros(RoutingContext routingContext) {
        System.out.println("CarroVerticle.buscarCarros()");
    }

    private void atualizarCarro(RoutingContext routingContext) {
        final String id = routingContext.request().getParam("id");
        AtualizarCarro atualizarCarro = Json.decodeValue(routingContext.getBodyAsString(),
        AtualizarCarro.class);
        System.out.println("CarroVerticle.atualizarCarro() " + id);
        System.out.println("CarroVerticle.atualizarCarro()" + atualizarCarro);
    }

    private void apagarCarro(RoutingContext routingContext) {
        final String id = routingContext.request().getParam("id");
        System.out.println("enclosing_type.enclosing_method() " + id);
    }
}