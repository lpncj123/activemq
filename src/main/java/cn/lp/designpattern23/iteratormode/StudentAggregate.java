package cn.lp.designpattern23.iteratormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.iteratormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:21
 * @Description: 定义抽象容器类，包含添加元素，删除元素，获取迭代器对象的方法
 * @Version: 1.0
 */
public interface StudentAggregate {
    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getStudentIterator();
}
