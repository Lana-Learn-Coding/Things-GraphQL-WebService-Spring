package lana.thingwebservice.thing;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private ThingRepo thingRepo;

    public Iterable<Thing> getAllThings() {
        return thingRepo.findAll();
    }

    public Optional<Thing> getThing(Integer id) {
        return thingRepo.findById(id);
    }
}

