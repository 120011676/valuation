package org.say.valuation.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.shiro.SecurityUtils;
import org.say.valuation.bean.jsonp.JsonpAdvice;
import org.say.valuation.bean.jsonp.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by say on 9/6/16.
 */
public class ControllerUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerUtil.class);

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes != null && requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        return null;
    }

    public static String getLoginUsername() {
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj != null && obj instanceof String) {
            return (String) obj;
        }
        return null;
    }


    public static String getClentIP() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    public static int getPageNum() {
        String pageNum = getRequest().getParameter("pageNum");
        if (StringUtils.isEmpty(pageNum)) {
            return 0;
        } else {
            return Integer.parseInt(pageNum);
        }
    }

    public static int getPageSize() {
        String pageSize = getRequest().getParameter("pageSize");
        if (StringUtils.isEmpty(pageSize)) {
            return 20;
        } else {
            return Integer.parseInt(pageSize);
        }
    }

    public static void jsonp(Result result, ServletRequest req, ServletResponse resp) {
        try (PrintWriter out = resp.getWriter()) {
            String callback = req.getParameter(JsonpAdvice.CALLBACK);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(result);
            String contentType = "application/json";
            if (org.apache.shiro.util.StringUtils.hasText(callback)) {
                contentType = "application/javascript";
                json = mapper.writeValueAsString(new JSONPObject(callback, result));
            }
            resp.setCharacterEncoding("utf-8");
            resp.setContentType(contentType);
            out.write(json);
            out.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
