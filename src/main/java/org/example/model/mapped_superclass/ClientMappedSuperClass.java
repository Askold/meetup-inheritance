package org.example.model.mapped_superclass;

import javax.persistence.*;

@Entity
@Table(name = "client_mapped_superclass")
public class ClientMappedSuperClass extends UserMappedSuperClass{
    private Integer weight;
    private Integer height;

    public ClientMappedSuperClass() {
    }

    public ClientMappedSuperClass(long userId, String name, String surname, String login, String password, Integer weight, Integer height) {
        super(userId, name, surname, login, password);
        this.weight = weight;
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


}
