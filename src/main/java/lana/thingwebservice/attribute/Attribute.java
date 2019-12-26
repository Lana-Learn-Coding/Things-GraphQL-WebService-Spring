package lana.thingwebservice.attribute;

import lana.thingwebservice.thing.Thing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    public Attribute(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @OneToMany(mappedBy = "attribute")
    private List<Thing> things;
}
