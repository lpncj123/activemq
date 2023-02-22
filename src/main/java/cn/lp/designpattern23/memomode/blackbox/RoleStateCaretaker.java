package cn.lp.designpattern23.memomode.blackbox;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.memomode.blackbox
 * @Author: lp
 * @CreateTime: 2023-02-21  14:48
 * @Description: TODO
 * @Version: 1.0
 */
public class RoleStateCaretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
