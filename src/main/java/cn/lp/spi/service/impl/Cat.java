package cn.lp.spi.service.impl;

import cn.lp.spi.service.IShout;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.spi.service.impl
 * @Author: lp
 * @CreateTime: 2024-03-21  11:30
 * @Description: TODO
 * @Version: 1.0
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("Cat IShout");
    }
}
