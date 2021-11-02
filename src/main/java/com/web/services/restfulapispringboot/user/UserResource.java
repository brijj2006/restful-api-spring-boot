package com.web.services.restfulapispringboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    /*get the list of all existing users*/
    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    /*get the details of a particular user*/
    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        return userDaoService.findOne(id);
    }


}
