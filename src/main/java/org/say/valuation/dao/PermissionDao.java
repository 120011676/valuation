package org.say.valuation.dao;

import org.say.valuation.entity.Permission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by say on 01/12/2016.
 */
@Repository
public interface PermissionDao extends PagingAndSortingRepository<Permission, String>, JpaSpecificationExecutor {

    List<Permission> findByStatusTrue();
}
