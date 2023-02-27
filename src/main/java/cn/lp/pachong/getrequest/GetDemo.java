package cn.lp.pachong.getrequest;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.pachong.getrequest
 * @Author: lp
 * @CreateTime: 2023-02-21  16:26
 * @Description: TODO
 * @Version: 1.0
 */
public class GetDemo {
    public static void main(String[] args) throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 声明访问地址
        HttpGet httpGet = new HttpGet("https://www.autohome.com.cn/bestauto/");

        CloseableHttpResponse response = null;
        try {
            // 发起请求
            response = httpClient.execute(httpGet);

            // 判断状态码是否是200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content.length());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 释放连接
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpClient.close();
            }
        }
    }
    /**
     * @description:有参数的get请求
     * @author: lp
     * @date: 2023/2/21 16:30
     * @param: []
     * @return: void
     **/
    public void testHaveParamsRequest() throws IOException, URISyntaxException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 声明访问地址
        // https://www.baidu.com/s?wd=汽车之家
        URI uri = new URIBuilder("https://www.baidu.com/s").setParameter("wd", "汽车之家").build();

        // 创建HttpGet请求对象
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            // 发起请求
            response = httpClient.execute(httpGet);

            // 判断状态码是否是200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content.length());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 释放连接
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpClient.close();
            }
        }
    }
}
