package cn.lp.designpattern23.interpretermode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.interpretermode
 * @Author: lp
 * @CreateTime: 2023-02-21  15:00
 * @Description: TODO
 * @Version: 1.0
 */
public class Plus extends AbstractExpression {
    private AbstractExpression left;
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}