package com.web.services.restfulapispringboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        User user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("user does not exist : " + id);
        }
        return user;
    }

    /*create new user and return the URI location*/
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    /*delete a particular user*/
    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteUser(id);
        if (user == null) {
            throw new UserNotFoundException("user does not exist : " + id);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
