package cn.lp.designpattern23.interpretermode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.interpretermode
 * @Author: lp
 * @CreateTime: 2023-02-21  15:02
 * @Description: TODO
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");
        Variable e = new Variable("e");
        //Value v = new Value(1);

        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);
        context.assign(e, 5);

//        AbstractExpression expression = new Minus(new Plus(new Plus(new Plus(a, b), c), d), e);
        AbstractExpression expression1 = new Minus(a, e);
        System.out.println(expression1+"************"+expression1.interpret(context));
//        System.out.println(expression + "= " + expression.interpret(context));
    }
}
