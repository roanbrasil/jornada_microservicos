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
public class LiveYearObservers {

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
        final LiveYear liveYear = template.<LiveYear>singleResult(query)
                .orElseGet(() -> template.insert(new LiveYear(city, year)));

        liveYear.increment();
        template.update(liveYear);
    }

    private DocumentQuery getQuery(String city, Year year) {
        return mapper.selectFrom(LiveYear.class).where("city")
                .eq(city).and("year").eq(year).build();
    }

}
