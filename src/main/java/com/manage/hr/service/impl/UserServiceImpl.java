package com.manage.hr.service.impl;

import com.manage.hr.dao.UserDao;
import com.manage.hr.entity.User;
import com.manage.hr.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User findUserByID(int userId) {
        return userDao.findUserByID(userId);
    }
}
