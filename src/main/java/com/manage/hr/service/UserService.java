package com.manage.hr.service;

import com.manage.hr.entity.User;


import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> findAllUser();
    int updateUser(User user);
    User findUserByID(  int userId);
}
