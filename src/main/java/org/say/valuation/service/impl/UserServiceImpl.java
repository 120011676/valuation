package org.say.valuation.service.impl;

import org.say.valuation.dao.UserDao;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by say on 18/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> list() {
        return this.userDao.list();
    }

    @Override
    public String save(User user) {
        this.userDao.save(user).getId();
        return "m";
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
