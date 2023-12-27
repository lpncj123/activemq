package cn.lp.utils;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 接口请求示例为：http://open.api.tianyancha.com/services/open/ic/verify/2.0?code=91110000802100433B&name=北京百度网讯科技有限公司&legalPersonName=梁志祥
 */
public class HttpUtils {
    private static CloseableHttpClient httpClient = null;

    private HttpUtils() {
    }

    private static CloseableHttpClient getInstance() {
        if (httpClient == null) {
            synchronized (HttpUtils.class) {
                if (httpClient == null) {
                    List<Header> headers = new ArrayList<>();
                    headers.add(new BasicHeader("Authorization", "1d4fc0fb-b8b0-4966-9c00-8e76e31be11c"));
                    RequestConfig requestConfig = RequestConfig.custom()
                            // 设置连接超时时间
                            .setConnectTimeout(2000)
                            // 设置响应超时时间
                            .setSocketTimeout(2000)
                            .build();
                    //创建httpClient链接
                    httpClient = HttpClients.custom()
                            .setDefaultHeaders(headers)
                            .setDefaultRequestConfig(requestConfig)
                            .build();
                }
            }
        }
        return httpClient;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        // token可以从 数据中心 -> 我的接口 中获取
        StringBuilder url = new StringBuilder("http://open.api.tianyancha.com/services/open");
        url.append("/ic/verify/2.0");
        url.append("?code=" + "91110000802100433B");
        url.append("&name=" + "北京百度网讯科技有限公司");
        url.append("&legalPersonName=" + "梁志祥");
        System.out.println(executeGet(String.valueOf(url)));

    }

    /**
     * http get请求
     *
     * @param url   接口url
     * @return 返回接口数据
     */
    public static String executeGet(String url) {
        String result = null;
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            HttpGet get = new HttpGet(url);
            closeableHttpResponse = getInstance().execute(get);
            HttpEntity entity = closeableHttpResponse.getEntity();
            result = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (closeableHttpResponse != null) {
                    closeableHttpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
