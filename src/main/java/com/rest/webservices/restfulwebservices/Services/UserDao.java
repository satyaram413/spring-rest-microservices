package com.rest.webservices.restfulwebservices.Services;

import com.rest.webservices.restfulwebservices.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDao {
    private static List<User> users = new ArrayList<>();
    private static int userCounter = 3;

    static {
        users.add(new User(1, "Satya", new Date()));
        users.add(new User(2, "Pramod", new Date()));
        users.add(new User(3, "Krishna Sri", new Date()));


    }

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        if(user.getId()==null)
        {
            user.setId(++userCounter);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id)
    {
        for(User user: users)
        {
            if(user.getId()==id)
                return user;
        }
        return null;
    }
}

