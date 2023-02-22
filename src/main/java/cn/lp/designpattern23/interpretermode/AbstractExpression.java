package cn.lp.designpattern23.interpretermode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.interpretermode
 * @Author: lp
 * @CreateTime: 2023-02-21  14:59
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class AbstractExpression {
    public abstract int interpret(Context context);
}
