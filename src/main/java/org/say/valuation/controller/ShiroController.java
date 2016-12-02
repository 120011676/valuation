package org.say.valuation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.say.valuation.bean.jsonp.JsonpAdvice;
import org.say.valuation.bean.jsonp.Result;
import org.say.valuation.util.ControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by say on 30/11/2016.
 */
@RestController
public class ShiroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);

    @RequestMapping("login")
    public String login(String username, String password, boolean rememberMe, HttpServletResponse response) throws JsonProcessingException {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password, rememberMe);
        Result result = new Result();
        try {
            subject.login(token);
            result.setStatus(true);
            result.setCode("0000");
            result.setMsg("登录成功");
            LOGGER.debug("对用户[" + username + "]进行登录验证..验证通过");
        } catch (UnknownAccountException e) {
            result.setCode("1001");
            result.setMsg("没有这个用户");
            LOGGER.debug("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
        } catch (IncorrectCredentialsException e) {
            result.setCode("1002");
            result.setMsg("密码不正确");
            LOGGER.debug("对用户{}进行登录验证..验证未通过,错误的凭证", username, e);
        } catch (DisabledAccountException e) {
            result.setCode("1003");
            result.setMsg("用户被禁用");
            LOGGER.debug("对用户[" + username + "]进行登录验证..验证未通过,用户被禁用");
        } catch (ExcessiveAttemptsException e) {
            result.setCode("1004");
            result.setMsg("重试密码过多");
            LOGGER.debug("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
        } catch (AuthenticationException e) {
            result.setCode("1005");
            result.setMsg("未知错误");
            LOGGER.debug("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
        }
        String callback = ControllerUtil.getRequest().getParameter(JsonpAdvice.CALLBACK);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        String contentType = "application/json";
        if (StringUtils.hasText(callback)) {
            contentType = "application/javascript";
            json = mapper.writeValueAsString(new JSONPObject(callback, result));
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType(contentType);
        return json;
    }

    @RequestMapping("logout")
    public String logout(HttpServletResponse response) throws JsonProcessingException {
        SecurityUtils.getSubject().logout();
        Result result = new Result();
        result.setStatus(true);
        result.setCode("0000");
        result.setMsg("退出成功");
        String callback = ControllerUtil.getRequest().getParameter(JsonpAdvice.CALLBACK);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        String contentType = "application/json";
        if (StringUtils.hasText(callback)) {
            contentType = "application/javascript";
            json = mapper.writeValueAsString(new JSONPObject(callback, result));
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType(contentType);
        return json;
    }
}
