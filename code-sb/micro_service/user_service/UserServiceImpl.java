package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //fake user list

    List<User> users = new ArrayList<>();
    {
        users.add(new User(1311L, "Durgesh Tiwari", "23525625"));
        users.add(new User(1312L, "Ankit Tiwari", "99999"));
        users.add(new User(1314L, "Ravi Tiwari", "888"));
    }

    @Override
    public User getUser(Long id) {

        return users.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
