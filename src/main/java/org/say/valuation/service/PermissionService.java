package org.say.valuation.service;

import org.say.valuation.entity.Permission;

import java.util.List;

/**
 * Created by say on 01/12/2016.
 */
public interface PermissionService {

    List<Permission> findByStatusTrue();
}
