package cn.lp.caffine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.caffine
 * @Author: lp
 * @CreateTime: 2024-07-22  18:05
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@Slf4j
public class CaffineExample {

    private final LoadingCache<String, String> cache;

    public CaffineExample() {
        this.cache = Caffeine.newBuilder()
            .refreshAfterWrite(1, TimeUnit.MINUTES) // 配置自动刷新，1分钟刷新一次
            .build(key -> loadDataFromSource(key)); // 使用加载器加载数据
    }



    public String getValue(String key) {
        String s = cache.get(key);
        System.out.println("S:"+s);
        return s;
    }

    private String loadDataFromSource(String key) {
// 从数据源加载数据的逻辑
// 这里只是一个示例，实际应用中可能是从数据库、外部服务等获取数据
        System.out.println("Loading data for key: " + key);
        return "Value for " + key;
    }
}