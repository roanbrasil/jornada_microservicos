package org.soujava.demo.microservices.cqrs;

import jakarta.nosql.mapping.document.DocumentQueryMapper;
import jakarta.nosql.mapping.document.DocumentTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Year;
import java.util.Optional;

@ApplicationScoped
@Path("birthdays")
@Produces(MediaType.APPLICATION_JSON)
public class ControlResource {

    @Inject
    @ConfigProperty(name = "document")
    private DocumentTemplate template;

    @Inject
    private DocumentQueryMapper mapper;

    @Path("{city}/{year}")
    @GET
    public LiveYear getLives(@PathParam("city") String city, @PathParam("year") int year) {

        final Optional<LiveYear> singleResult = mapper.selectFrom(LiveYear.class).where("city")
                .eq(city).and("year").eq(Year.of(year)).getSingleResult(template);
        return singleResult.orElseGet(() -> new LiveYear(city, Year.of(year)));
    }

    @Path("current/{city}/{year}")
    @GET
    public CityControl getControl(@PathParam("city") String city, @PathParam("year") int year) {
        final Optional<CityControl> singleResult = mapper.selectFrom(CityControl.class)
                .where("city").eq(city)
                .and("year").eq(Year.of(year)).getSingleResult(template);
        return singleResult.orElseGet(() -> new CityControl(city, Year.of(year)));
    }
}
