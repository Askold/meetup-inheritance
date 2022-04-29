package org.example.model.joined_table;

import javax.persistence.*;

@Entity
@Table(name = "client_joined_table")
public class ClientJoinedTable extends UserJoinedTable{
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

    public ClientJoinedTable() {
    }

    public ClientJoinedTable(long userId, String name, String surname, String login, String password, Integer weight, Integer height) {
        super(userId, name, surname, login, password);
        this.weight = weight;
        this.height = height;
    }
}
