package org.say.valuation.bean.jsonp;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by say on 30/11/2016.
 */
@RestControllerAdvice("org.say.valuation")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public static final String CALLBACK = "callback";

    public JsonpAdvice() {
        super(CALLBACK);
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        Result result = new Result();
        result.setStatus(true);
        result.setCode("0000");
        result.setMsg("成功");
        result.setData(bodyContainer.getValue());
        bodyContainer.setValue(result);
        super.beforeBodyWriteInternal(bodyContainer, contentType, returnType, request, response);
    }
}
