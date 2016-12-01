package org.say.valuation.bean.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.say.valuation.bean.jsonp.Result;
import org.say.valuation.util.ControllerUtil;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by say on 01/12/2016.
 */
public class JsonpPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = getSubject(request, response);
        Result result;
        result = new Result();
        result.setStatus(false);
        if (subject.getPrincipal() == null) {
            result.setCode("0001");
            result.setMsg("未登录");
        } else {
            result.setCode("0002");
            result.setMsg("没有权限");
        }
        ControllerUtil.jsonp(result, request, response);
        return false;
    }
}
