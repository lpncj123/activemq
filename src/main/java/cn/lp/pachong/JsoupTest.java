package cn.lp.pachong;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupTest {
    /**
     * @param url 访问路径
     * @return
     */
    public Document getDocument(String url) {
        try {
            //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


        public static void main(String[] args) throws IOException {
//        JsoupTest t = new JsoupTest();
//        Document doc = t.getDocument("https://www.czcb.com.cn/czcb/khfw/whpj/index.html");
//        System.out.println(doc);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://www.czcb.com.cn/czcb/khfw/whpj/index.html");
            CloseableHttpResponse response = httpClient.execute(httpGet);

//判断相应中的状态码是否为200，即是否正确返回相应:

            if (response.getStatusLine().getStatusCode() == 200) {

                //拿到响应体:

                HttpEntity httpEntity = response.getEntity();

                //解析响应体，”utf-8”为网页编码:

                String content = EntityUtils.toString(httpEntity, "utf-8");

                //最后把结果输出到控制台:

                System.out.println(content);


            }
        }
}
