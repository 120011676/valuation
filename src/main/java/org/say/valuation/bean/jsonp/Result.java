package org.say.valuation.bean.jsonp;

import lombok.Data;

/**
 * Created by say on 01/12/2016.
 */
@Data
public class Result {
    private boolean status;
    private String code;
    private String msg;
    private Object data;
}
