package org.say.valuation.bean.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.say.valuation.entity.Permission;
import org.say.valuation.entity.Role;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

/**
 * Created by say on 29/11/2016.
 */
public class CustomRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomRealm.class);

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) super.getAvailablePrincipal(principals);
        User user = this.userService.findByUsername(username);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Role> roles = user.getRoles();
            if (roles != null && roles.size() > 0) {
                info.setRoles(new HashSet<>());
                for (Role r : user.getRoles()) {
                    info.addRole(r.getName());
                    List<Permission> permissions = r.getPermissions();
                    if (permissions != null && permissions.size() > 0) {
                        for (Permission p : permissions) {
                            info.addStringPermission(p.getPermission());
                        }
                    }
                }
            }
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken) token;
//        ReflectionToStringBuilder.reflectionToString(token, ToStringStyle.MULTI_LINE_STYLE);
        User user = this.userService.findByUsername(upt.getUsername());
        LOGGER.info("user:{}", user);
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        }
        return null;
    }
}
