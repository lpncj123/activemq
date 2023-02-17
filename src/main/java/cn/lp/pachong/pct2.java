package cn.lp.pachong;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class pct2 {
    public static void main(String[] args) throws IOException {
        // ============================= 【HttpClient】 ====================================
        // 创建httpclient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpget实例
        HttpGet httpget = new HttpGet("https://www.czcb.com.cn/czcb/khfw/whpj/index.html");

        // 模拟浏览器 ✔
        httpget.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");

        // 使用代理 IP ✔
//        HttpHost proxy = new HttpHost("118.114.77.47", 8080);
//        RequestConfig config = RequestConfig.custom().setProxy(proxy)
//                //设置连接超时 ✔
//                .setConnectTimeout(10000) // 设置连接超时时间 10秒钟
//                .setSocketTimeout(10000) // 设置读取超时时间10秒钟
//                .build();
//
//        httpget.setConfig(config);

        // 执行get请求
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        // 获取返回实体
        String content = EntityUtils.toString(entity, "utf-8");

        // ============================= 【Jsoup】 ====================================
        //获取响应类型、内容
        System.out.println("Status:"+response.getStatusLine().getStatusCode());
        System.out.println("Content-Type:"+entity.getContentType().getValue());
        System.out.println(content);
//        // 解析网页 得到文档对象
//        Document doc = Jsoup.parse(content);
//        Elements elements = doc.getElementsByTag("a"); // 获取tag是a的所有DOM元素，数组
//
//        for (int i = 3; i < 17; ++i) {
//            Element element = elements.get(i); // 获取第i个元素
//            String title = element.text(); // 返回元素的文本
//            System.out.println("<a>：" + title);
//        }

        response.close(); // response关闭
        httpclient.close(); // httpClient关闭

    }
}
