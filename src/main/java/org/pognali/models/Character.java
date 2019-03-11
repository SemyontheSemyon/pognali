package org.pognali.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Character {

    @Id
    @GeneratedValue(generator = "character_generator")
    @SequenceGenerator(
            name = "character_generator",
            sequenceName = "character_sequence")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hello_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Hello hello;

    private Character(){}

    public Character(String name, Hello hello){
        this.name = name;
        this.hello = hello;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
