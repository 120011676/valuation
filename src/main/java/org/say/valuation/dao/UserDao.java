package org.say.valuation.dao;

import org.say.valuation.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by say on 18/11/2016.
 */
@Repository
public interface UserDao extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor {
    User findByUsername(String username);
}
