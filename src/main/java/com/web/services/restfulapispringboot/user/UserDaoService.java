package com.web.services.restfulapispringboot.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "Sachin", new Date()));
        users.add(new User(2, "Lara", new Date()));
        users.add(new User(3, "Ponting", new Date()));
    }

    /*get the details of all users*/
    public List<User> findAll() {
        return users;
    }

    /*add a new user*/
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    /*find one user*/
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


}
