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
        if (e instanceof MsgException) {
            MsgException me = (MsgException) e;
            result.setCode(me.getCode());
            result.setMsg(me.getMessage());
        } else {
            String unknownCode = "9999";
            result.setCode(unknownCode);
            result.setMsg(e.getMessage());
        }
        String debugName = "debug";
        String debug = req.getParameter(debugName);
        if ("true".equals(debug)) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            result.setMsg(sw.toString());
        }
        ControllerUtil.jsonp(result, req, resp);
    }
}