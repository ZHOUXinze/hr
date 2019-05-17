package com.manage.hr.dao;

import com.manage.hr.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int addUser(User user);
    List<User> findAllUser();

    int updateUser(User user);
   User findUserByID( @Param("userId") int userId);
}
