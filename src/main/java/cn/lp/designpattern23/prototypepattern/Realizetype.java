package cn.lp.designpattern23.prototypepattern;

public class Realizetype implements Cloneable{


    /**
     * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
     * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
     *
     * Object的默认实现的clone()方法是浅拷贝，它将原对象的所有成员变量值复制到新对象中，但是如果成员变量是引用类型的，那么只会复制这个引用的地址，新对象和原对象会共享这个引用指向的对象。
     * 因此，在默认情况下，clone()方法是浅克隆，如果需要实现深克隆，需要在具体类中重写clone()方法。
     * new好的对象给另一个引用，那么这两个引用指的是同一个对象，所以是浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}
