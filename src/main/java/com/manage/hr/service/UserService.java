package com.manage.hr.service;

import com.manage.hr.entity.User;
import com.manage.hr.util.PageSurport;


import java.util.List;

public interface UserService {
    int addUser(User user);
   PageSurport<User> findAllUser(User user, int pageIndex, int pageSize);

    int updateUser(User user);
    User findUserByID(  int userId);
    int login(String userCode,String password,User user);

}
