package cn.lp.designpattern23.interpretermode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.interpretermode
 * @Author: lp
 * @CreateTime: 2023-02-21  15:01
 * @Description: TODO
 * @Version: 1.0
 */
public class Variable extends AbstractExpression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context ctx) {
        return ctx.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
