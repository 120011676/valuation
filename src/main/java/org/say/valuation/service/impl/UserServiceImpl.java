package org.say.valuation.service.impl;

import org.say.valuation.dao.UserDao;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by say on 18/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Page<User> find(int page, int size, User user) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "status", "createDate");
        return this.userDao.findAll((root, query, cb) -> {
            if (user != null) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasText(user.getUsername())) {
                    predicates.add(cb.like(root.get("username"), "%" + user.getUsername() + "%"));
                }
                if (StringUtils.hasText(user.getName())) {
                    predicates.add(cb.like(root.get("name"), "%" + user.getName() + "%"));
                }
                if (user.getStatus() != null) {
                    predicates.add(cb.equal(root.get("status"), user.getStatus()));
                }
                if (predicates.size() > 0) {
                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            }
            return null;
        }, pageable);
    }

    @Override
    public User save(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

    @Override
    public long count() {
        return this.userDao.count();
    }
}
