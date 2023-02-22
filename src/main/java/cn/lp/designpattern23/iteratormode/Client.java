package cn.lp.designpattern23.iteratormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.iteratormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:25
 * @Description: TODO
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        StudentAggregate studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("3","3"));
        studentAggregate.addStudent(new Student("1","1"));
        studentAggregate.addStudent(new Student("2","2"));
        StudentIterator studentIterator = studentAggregate.getStudentIterator();
        Student next = studentIterator.next();
        Student next1 = studentIterator.next();
        Student next2 = studentIterator.next();
        System.out.println(next);
        System.out.println(next1);
        System.out.println(next2);

    }
}
