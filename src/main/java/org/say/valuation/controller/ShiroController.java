package org.say.valuation.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by say on 30/11/2016.
 */
@RestController
public class ShiroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);

    @RequestMapping("login")
    public JSONPObject login(String username, String password, boolean rememberMe, String callback) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            subject.login(token);
            LOGGER.info("对用户[" + username + "]进行登录验证..验证通过");
            return new JSONPObject(callback, "成功");
        } catch (UnknownAccountException e) {
            LOGGER.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
        } catch (IncorrectCredentialsException e) {
            LOGGER.info("对用户{}进行登录验证..验证未通过,错误的凭证", username, e);
        } catch (LockedAccountException e) {
            LOGGER.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
        } catch (ExcessiveAttemptsException e) {
            LOGGER.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
        } catch (AuthenticationException e) {
            LOGGER.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
        }
        return null;
    }

    @RequestMapping("logout")
    public JSONPObject logout(String callback) {
        SecurityUtils.getSubject().logout();
        return new JSONPObject(callback, "退出成功");
    }
}
