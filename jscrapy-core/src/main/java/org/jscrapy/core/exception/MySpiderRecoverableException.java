package org.jscrapy.core.exception;

/**
 * Created by cxu on 2015/6/22.
 */
public class MySpiderRecoverableException extends MySpiderException {
    public MySpiderRecoverableException(MySpiderExceptionCode errorCode) {
        super(errorCode);
    }
}
