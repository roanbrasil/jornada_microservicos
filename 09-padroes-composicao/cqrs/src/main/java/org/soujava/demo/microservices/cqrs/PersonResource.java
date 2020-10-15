package org.soujava.demo.microservices.cqrs;

import jakarta.nosql.mapping.document.DocumentTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
@Path("people")
public class PersonResource {

    @Inject
    @ConfigProperty(name = "document")
    private DocumentTemplate template;

    @Inject
    private Event<Born> wasBornEvent;

    @Inject
    private Event<PassAway> passAwayEvent;

    @POST
    public Person insert(Person person) {

        if (person.isValid()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        final Optional<Person> entity = getPerson(person.getId());

        if (entity.isPresent()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        final Person wasBorn = template.insert(person);
        wasBornEvent.fireAsync(new Born(wasBorn));
        return wasBorn;
    }

    @DELETE
    @Path("{id}")
    public Person delete(@PathParam("id") String id) {
        final Person person = getPerson(id).orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
        template.delete(Person.class, id);
        passAwayEvent.fireAsync(new PassAway(person));
        return person;
    }

    private Optional<Person> getPerson(String id) {
        return template.find(Person.class, id);
    }
}
