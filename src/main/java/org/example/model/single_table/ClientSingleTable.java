package org.example.model.single_table;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "client" )
public class ClientSingleTable extends UserSingleTable{
    private Integer weight;
    private Integer height;


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


    public ClientSingleTable() {
    }

    public ClientSingleTable(long userId, String name, String surname, String login, String password, Integer weight, Integer height) {
        super(userId, name, surname, login, password);
        this.weight = weight;
        this.height = height;
    }
}
