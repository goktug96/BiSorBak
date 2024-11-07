package com.packet.bisorbak.service;

import com.packet.bisorbak.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(long id);
    public void deleteUserById(long id);
    public void saveUser(User user);
}
