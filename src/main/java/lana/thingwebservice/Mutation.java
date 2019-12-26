package lana.thingwebservice;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lana.thingwebservice.attribute.Attribute;
import lana.thingwebservice.attribute.AttributeRepo;
import lana.thingwebservice.thing.Thing;
import lana.thingwebservice.thing.ThingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public Boolean deleteThing(Integer thingId) {
        Optional<Thing> existed = thingRepo.findById(thingId);
        return existed.map((thing) -> {
            thingRepo.delete(thing);
            return true;
        }).orElse(false);
    }

    public Attribute createAttribute(Attribute attribute) {
        return attributeRepo.save(attribute);
    }

    public Boolean deleteAttribute(Integer attributeId) {
        Optional<Attribute> existed = attributeRepo.findById(attributeId);
        return existed.map((attribute) -> {
            attributeRepo.delete(attribute);
            return true;
        }).orElse(false);
    }
}
