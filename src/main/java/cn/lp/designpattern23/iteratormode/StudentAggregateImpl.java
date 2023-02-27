package cn.lp.designpattern23.iteratormode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.iteratormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:22
 * @Description: TODO
 * @Version: 1.0
 */
public class StudentAggregateImpl implements StudentAggregate{
    private List<Student> list = new ArrayList<Student>();  // 学生列表

    @Override
    public void addStudent(Student student) {
        this.list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
