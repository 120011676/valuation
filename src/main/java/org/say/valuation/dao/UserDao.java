package org.say.valuation.dao;

import org.say.valuation.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by say on 18/11/2016.
 */
@Repository
public interface UserDao extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor {

    @Query("from User")
    List<User> list();

    User findByUsername(String username);
}
