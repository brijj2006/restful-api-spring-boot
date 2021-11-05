package com.web.services.restfulapispringboot.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "all details about the user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "name should be min 2 char")
    @ApiModelProperty(notes = "name should be min 2 char")
    private String name;

    @Past(message = "birth date must be in past")
    @ApiModelProperty(notes = "birth date must be in past")
    private Date dob;

    public User() {

    }

    public User(Integer id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                "}";
    }
}
