package org.say.valuation.bean.exception;

import org.say.valuation.bean.jsonp.Result;
import org.say.valuation.util.ControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by say on 21/11/2016.
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({Exception.class})
    public void defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        LOGGER.error(e.getMessage(), e);
        Result result = new Result();
        result.setStatus(false);
        String eStr = e.getMessage();
        if (eStr != null) {
            int index = eStr.indexOf(27);
            if (index > -1) {
                result.setCode(eStr.substring(0, index));
                result.setMsg(eStr.substring(index + 1));
            }
        } else {
            result.setCode("9999");
            result.setMsg("接口异常:" + e.getMessage());
        }
        if ("true".equals(req.getParameter("debug"))) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            result.setMsg("接口详细异常:" + sw);
        }
        ControllerUtil.jsonp(result, req, resp);
    }
}