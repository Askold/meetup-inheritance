package org.example.model.joined_table;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user_joined_table")
public class UserJoinedTable{
    @Id
    private long userId;
    private String name;
    private String surname;
    private String login;
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserJoinedTable() {
    }

    public UserJoinedTable(long userId, String name, String surname, String login, String password) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }
}
