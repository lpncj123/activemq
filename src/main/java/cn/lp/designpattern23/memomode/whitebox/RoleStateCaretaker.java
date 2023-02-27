package cn.lp.designpattern23.memomode.whitebox;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.memomode
 * @Author: lp
 * @CreateTime: 2023-02-21  14:12
 * @Description: 角色状态管理者类
 * @Version: 1.0
 */
public class RoleStateCaretaker {
    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}
