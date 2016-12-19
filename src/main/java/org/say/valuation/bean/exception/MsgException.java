package org.say.valuation.bean.exception;

/**
 * Created by say on 19/12/2016.
 */
public class MsgException extends RuntimeException {

    private String code;

    public MsgException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
