package lana.thingwebservice.thing;

import lana.thingwebservice.attribute.Attribute;
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
    private Attribute attribute;
}
