package lana.thingwebservice.thing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lana.thingwebservice.attribute.Attribute;
import lana.thingwebservice.attribute.AttributeJsonDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Thing {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String generic;

    @JoinColumn
    @ManyToOne
    @JsonDeserialize(using = AttributeJsonDeserializer.class)
    private Attribute attribute;

    public Thing(String name, Attribute attribute) {
        this.name = name;
        this.attribute = attribute;
    }
}
