package cn.lp.spi.service;

import java.util.ServiceLoader;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.spi.service
 * @Author: lp
 * @CreateTime: 2024-03-21  11:38
 * @Description: TODO
 * @Version: 1.0
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            System.out.println(s.toString());
            s.shout();
        }
    }
}
