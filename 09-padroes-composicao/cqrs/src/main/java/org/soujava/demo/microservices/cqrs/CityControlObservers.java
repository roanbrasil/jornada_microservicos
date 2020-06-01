package org.soujava.demo.microservices.cqrs;

import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.mapping.document.DocumentQueryMapper;
import jakarta.nosql.mapping.document.DocumentTemplate;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.time.Year;

@ApplicationScoped
public class CityControlObservers {

    @Inject
    @ConfigProperty(name = "document")
    private DocumentTemplate template;

    @Inject
    private DocumentQueryMapper mapper;

    public void fire(@ObservesAsync Born born) {
        final Person person = born.get();
        final String city = person.getCity();
        final Year year = Year.of(person.getBirthday().getYear());
        final DocumentQuery query = getQuery(city, year);
        final CityControl cityControl = template.<CityControl>singleResult(query)
                .orElseGet(() -> template.insert(new CityControl(city, year)));

        cityControl.increment();
        template.update(cityControl);
    }

    public void fire(@ObservesAsync PassAway passAway) {
        final Person person = passAway.get();
        final String city = person.getCity();
        final Year year = Year.of(person.getBirthday().getYear());

        final DocumentQuery query = getQuery(city, year);
        final CityControl cityControl = template.<CityControl>singleResult(query)
                .orElseThrow(() -> new IllegalArgumentException("There is not population in this city"));
        cityControl.decrement();
        template.update(cityControl);
    }

    private DocumentQuery getQuery(String city, Year year) {
        return mapper.selectFrom(CityControl.class).where("city")
                .eq(city).and("year").eq(year).build();
    }

}
