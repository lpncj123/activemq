package cn.lp.pachong.postrequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.pachong.postrequest
 * @Author: lp
 * @CreateTime: 2023-02-21  16:36
 * @Description: TODO
 * @Version: 1.0
 */
public class GetDemo {
    public static void main(String[] args) throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 声明访问地址
        HttpPost httpPost = new HttpPost("https://www.oschina.net");

        // 设置User-Agent属性，解决开源中国限制的问题
        httpPost.setHeader("User-Agent", "");

        CloseableHttpResponse response = null;
        try {
            // 发起请求
            response = httpClient.execute(httpPost);

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
     * @description: 带参数的post请求
     * @author: lp
     * @date: 2023/2/21 16:47
     * @param: []
     * @return: void
     **/
    public void testHaveParamsPost() throws IOException {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 声明访问地址
        HttpPost httpPost = new HttpPost("https://www.oschina.net");

        // 设置User-Agent属性，解决开源中国限制的问题
        httpPost.setHeader("User-Agent", "");

        // 设置请求参数 https://www.oschina.net/search?scope=project&q=HttpClient
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("scope", "project"));
        params.add(new BasicNameValuePair("q", "HttpClient"));

        // 创建form表单实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");

        // 设置表单到httpPost中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 发起请求
            response = httpClient.execute(httpPost);

            // 判断状态码是否是200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
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
