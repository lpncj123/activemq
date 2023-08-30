package cn.lp.effective;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.effective
 * @Author: lp
 * @CreateTime: 2023-08-23  17:25
 * @Description: TODO
 * @Version: 1.0
 */
//遇到多个构造器参数要选择构建器 eg：有一个20个属性的对象，有很多不同参数个数的构造方法
/*
    重叠构造器模式可行，但是有需要参数的时候，就变得很不容易理解，然后采用了setters的构建方式，变得更加直观。
    但是，由于构造过程被分到了调用方法中，JavaBean有可能处于不一致的状态。然后建造模式就出来了。
 **/

public class Demo02 {
    private final int age;
    private final String name;
    private final int sex;
    private final String className;

    public static class Builder {
        private int age;
        private String name;
        private int sex;
        private final String className;

        public Builder(String className) {
            this.className = className;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(int sex) {
            this.sex = sex;
            return this;
        }
        public Demo02 build() {
            return new Demo02(this);
        }

    }
    public Demo02(Builder builder){
        age = builder.age;
        name = builder.name;
        sex = builder.sex;
        className = builder.className;

    }

    @Override
    public String toString() {
        return "Demo02{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", sex=" + sex +
            ", className='" + className + '\'' +
            '}';
    }

    public static void main(String[] args) {
        Demo02 demo02 = new Builder("111").name("666").build();
        System.out.println(demo02.toString());
    }
}
