package cn.lp.exception;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.utils
 * @Author: lp
 * @CreateTime: 2023-02-23  14:07
 * @Description: TODO
 * @Version: 1.0
 */
public class BaseException extends RuntimeException {
    private int status = 200;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BaseException() {
    }

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
