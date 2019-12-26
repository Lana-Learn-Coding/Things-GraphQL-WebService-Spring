package lana.thingwebservice;

import lana.thingwebservice.attribute.Attribute;
import lana.thingwebservice.attribute.AttributeRepo;
import lana.thingwebservice.thing.Thing;
import lana.thingwebservice.thing.ThingRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThingWebServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertData(ThingRepo thingRepo, AttributeRepo attributeRepo) {
        return (args) -> {
            Attribute water = attributeRepo.save(new Attribute("Water", "Some lulquid"));
            Attribute fire = attributeRepo.save(new Attribute("File", "Ops, I meant Fire"));
            attributeRepo.save(new Attribute("Paleoproterozoic Air", "Oxygen not included"));

            thingRepo.save(new Thing("Sea water", water));
            thingRepo.save(new Thing("River water", water));
            thingRepo.save(new Thing("Drinking water", water));
            thingRepo.save(new Thing("Sea fire", fire));
        };
    }
}
