package cn.lp.designpattern23.memomode.whitebox;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.memomode
 * @Author: lp
 * @CreateTime: 2023-02-21  14:11
 * @Description: 游戏状态存储类(备忘录类)
 * @Version: 1.0
 */
public class RoleStateMemento {
    private int vit;
    private int atk;
    private int def;

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
