package com.itrjp.common.exception;

import com.itrjp.common.constant.CodeMsg;

/**
 * <p>
 * 自定义全局异常类
 */
public class GlobalException extends RuntimeException {

    private static final long servialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }
    public GlobalException(String msg) {
        super(msg);
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
