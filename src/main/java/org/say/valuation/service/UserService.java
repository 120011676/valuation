package org.say.valuation.service;

import org.say.valuation.entity.User;

import java.util.List;

/**
 * Created by say on 18/11/2016.
 */
public interface UserService {
    List<User> list();

    String save(User user);
}
