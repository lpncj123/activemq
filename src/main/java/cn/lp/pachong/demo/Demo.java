package cn.lp.pachong.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.pachong.demo
 * @Author: lp
 * @CreateTime: 2023-02-21  16:23
 * @Description: TODO
 * @Version: 1.0
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 声明访问地址
        HttpGet httpGet = new HttpGet("https://www.autohome.com.cn/bestauto/");

        // 发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 判断状态码是否是200
        if (response.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            String content = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(content);
        }
    }
}
