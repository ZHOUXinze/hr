package com.manage.hr.service.impl;

import com.manage.hr.dao.UserDao;
import com.manage.hr.entity.User;
import com.manage.hr.service.UserService;
import com.manage.hr.util.PageSurport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public int login(String userCode, String password, User user) {
        int rel=-1;
        User users=userDao.userLogin(userCode);
if(users!=null){
    if(users.getPassword().equals(password)){
        user.setId(users.getId());
        user.setUserName(users.getUserName());
        user.setUserRole(users.getUserRole());
        user.setUserCode(users.getUserCode());
        user.setDepId(users.getDepId());
        user.setDepName(users.getDepName());
        user.setDataName(users.getDataName());
        user.setPhoneNumber(users.getPhoneNumber());
        user.setPassword(users.getPassword());
        rel=1;
    }else{
        rel=0;
    }
}

        return rel;
    }

    @Override
    public int delUserById(int userId) {
        return userDao.delUserById(userId);
    }

    @Override
    public String findUserByCode(String userCode) {
        return findUserByCode(userCode);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public PageSurport<User> findAllUser(User user, int pageIndex, int pageSize) {
        PageSurport<User> pageSurport=new PageSurport<>();
        int from=(pageIndex-1)*pageSize;
        pageSurport.setDataList(userDao.findAllUser(user,from,pageSize));
       pageSurport.setTotalCount(userDao.findAlluserCount(user));
        return pageSurport;
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User findUserByID(int userId) {
        return userDao.findUserByID(userId);
    }
    @Override
    public int upd(int userId, String password) {
        return userDao.updUser(userId,password);
    }


}
