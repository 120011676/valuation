package org.say.valuation.service.impl;

import org.say.valuation.dao.PermissionDao;
import org.say.valuation.entity.Permission;
import org.say.valuation.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by say on 01/12/2016.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findByStatusTrue() {
        return this.permissionDao.findByStatusTrue();
    }
}
