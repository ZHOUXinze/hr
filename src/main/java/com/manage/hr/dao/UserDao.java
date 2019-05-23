package com.manage.hr.dao;

import com.manage.hr.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int addUser(User user);
    List<User> findAllUser(@Param("user")User user,@Param("from")int from,
                           @Param("pageSize") int pageSize                      );
   int findAlluserCount(@Param("user")User user);
    int updateUser(User user);
   User findUserByID( @Param("userId") int userId);
   User userLogin(@Param("userCode") String userCode);
   int delUserById( int userId);
}
