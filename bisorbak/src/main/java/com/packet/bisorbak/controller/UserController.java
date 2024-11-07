package com.packet.bisorbak.controller;

import com.packet.bisorbak.domain.User;
import com.packet.bisorbak.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public void saveUser(User user){
        userService.saveUser(user);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
    }
}
