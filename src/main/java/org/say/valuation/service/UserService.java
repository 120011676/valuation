package org.say.valuation.service;

import org.say.valuation.entity.User;
import org.springframework.data.domain.Page;

/**
 * Created by say on 18/11/2016.
 */
public interface UserService {
    Page<User> find(int page, int size, User user);

    User save(User user);

    User findByUsername(String username);

    long count();
}
