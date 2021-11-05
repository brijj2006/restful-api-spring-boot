package com.web.services.restfulapispringboot.filterResponse;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("testUserFilter")
public class TestUser {

    private String firstName;
    private String lastName;

    /*@JsonIgnore*/  /*this field will be ignored in the response once jsonIgnore annotation is enabled*/
    private String password;

    public TestUser(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

}
