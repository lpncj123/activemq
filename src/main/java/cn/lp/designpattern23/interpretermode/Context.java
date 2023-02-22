package cn.lp.designpattern23.interpretermode;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.interpretermode
 * @Author: lp
 * @CreateTime: 2023-02-21  15:02
 * @Description: TODO
 * @Version: 1.0
 */
public class Context {
    private Map<Variable, Integer> map = new HashMap<Variable, Integer>();

    public void assign(Variable var, Integer value) {
        map.put(var, value);
    }

    public int getValue(Variable var) {
        Integer value = map.get(var);
        return value;
    }
}
