package org.example;

public class User {

    private int id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String login;

    public User(int id, String firstName, String lastName, Integer age, String login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }
}
