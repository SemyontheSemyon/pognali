package org.pognali.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Hello {

    @Id
    @GeneratedValue(generator = "hello_generator")
    @SequenceGenerator(
            name = "hello_generator",
            sequenceName = "hello_sequence")
    private Long id;

    private String text;

    private Hello(){}

    public Hello(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
