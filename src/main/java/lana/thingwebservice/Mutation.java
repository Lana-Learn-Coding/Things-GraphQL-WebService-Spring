package lana.thingwebservice;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lana.thingwebservice.attribute.Attribute;
import lana.thingwebservice.attribute.AttributeRepo;
import lana.thingwebservice.thing.Thing;
import lana.thingwebservice.thing.ThingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private ThingRepo thingRepo;
    private AttributeRepo attributeRepo;

    @Autowired
    public Mutation(ThingRepo thingRepo, AttributeRepo attributeRepo) {
        this.thingRepo = thingRepo;
        this.attributeRepo = attributeRepo;
    }

    public Thing createThing(Thing thing) {
        return thingRepo.save(thing);
    }

    public Attribute createAttribute(Attribute attribute) {
        return attributeRepo.save(attribute);
    }
}
