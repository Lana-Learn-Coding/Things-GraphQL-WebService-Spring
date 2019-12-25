package lana.thingwebservice;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lana.thingwebservice.attribute.Attribute;
import lana.thingwebservice.attribute.AttributeRepo;
import lana.thingwebservice.thing.Thing;
import lana.thingwebservice.thing.ThingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private ThingRepo thingRepo;
    private AttributeRepo attributeRepo;

    @Autowired
    public Query(ThingRepo thingRepo, AttributeRepo attributeRepo) {
        this.thingRepo = thingRepo;
        this.attributeRepo = attributeRepo;
    }

    public Iterable<Thing> getThings() {
        return thingRepo.findAll();
    }

    public Iterable<Attribute> getAttributes() {
        return attributeRepo.findAll();
    }
}

