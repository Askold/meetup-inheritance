package org.example.model.table_per_class;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client_table_per_class")
public class ClientTablePerClass extends UserTablePerClass{
    private Integer weight;
    @Basic
    private Integer height;

    public ClientTablePerClass() {
    }

    public ClientTablePerClass(long userId, String name, String surname, String login, String password, Integer weight, Integer height) {
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
