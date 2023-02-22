package cn.lp.designpattern23.iteratormode;

import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.iteratormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:20
 * @Description: TODO
 * @Version: 1.0
 */
public class StudentIteratorImpl implements StudentIterator {
    private List<Student> list;
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position);
        position++;
        return currentStudent;
    }
}
