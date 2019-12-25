package lana.thingwebservice.thing;

import org.springframework.data.repository.CrudRepository;

public interface ThingRepo extends CrudRepository<Thing, Integer> {
}
