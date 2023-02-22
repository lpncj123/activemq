package cn.lp.designpattern23.iteratormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.iteratormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:18
 * @Description: TODO
 * @Version: 1.0
 */
public interface StudentIterator {
    boolean hasNext();
    Student next();
}
