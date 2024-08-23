package cn.lp;

import cn.lp.caffine.CaffineExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-07-22  17:41
 * @Description: TODO
 * @Version: 1.0
 */
public class CaffineTest extends TestJunit{
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CaffineExample caffineExample;
    @Test
    public void testCacheManager() {
        Cache cache = cacheManager.getCache("caffeineCache");
        String key = "testKey";
        String value = "testValue";

        // 将数据放入缓存
        cache.put(key, value);
        String cachedValue = cache.get(getKey(key), String.class);
        System.out.println(cachedValue);
    }
    private String getKey(String key) {
        // 如果缓存键需要处理，比如拼接前缀等，可以在这里处理
        return key;
    }


    @Test
    public void testCaffeineExample() throws InterruptedException {
        String key = "testKey1";
        String key1 = "testKey2";
        String value = caffineExample.getValue(key);
        System.out.println("value:"+value);
        String value1 = caffineExample.getValue(key1);
        System.out.println("value1:"+value1);
        Thread.sleep(5000);
    }

}
