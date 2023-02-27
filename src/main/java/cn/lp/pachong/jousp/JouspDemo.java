package cn.lp.pachong.jousp;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.pachong.jousp
 * @Author: lp
 * @CreateTime: 2023-02-21  16:51
 * @Description: TODO
 * @Version: 1.0
 */
public class JouspDemo {
    /**
     * @description: Jsoup可以直接输入url，它会发起请求并获取数据，封装为Document对象
     * @author: lp
     * @date: 2023/2/21 17:00
     * @param: []
     * @return: void
     **/
    public static void testSimpler() throws IOException {

        // 使用jsoup解析url
        Document doc = Jsoup.parse(new URL("https://www.autohome.com.cn/bestauto/"), 10000);
        // 把获取的内容输出为文件
        FileUtils.writeStringToFile(new File("D:/test.html"), doc.toString(), "UTF-8");

        // 获取title
        Element element = doc.getElementsByTag("title").first();

// 打印title内容
        System.out.println(element.text());
    }

    /**
     * @description: Jsoup可以直接输入字符串，并封装为Document对象
     * @author: lp
     * @date: 2023/2/21 17:03
     * @param: []
     * @return: void
     **/
    public static void testSimplerTwo() throws IOException {
// 读取文件，获取字符串
        String html = FileUtils.readFileToString(new File("D:/test.html"), "UTF-8");

        // 解析字符串
        Document doc = Jsoup.parse(html);

        // 获取title标签
        Element element = doc.getElementsByTag("title").first();

        // 打印title内容
        System.out.println(element.text());
    }

    /**
     * @description: Jsoup可以直接输入文件，并封装为Document对象
     * @author: lp
     * @date: 2023/2/21 17:12
     * @param: []
     * @return: void
     **/
    public static void testSimplerThird() throws IOException {
        // 使用jsoup解析文件
        Document doc = Jsoup.parse(new File("D:/test.html"), "UTF-8");

        // 获取title标签
        Element element = doc.getElementsByTag("title").first();

        // 打印title内容
        System.out.println(element.text());
    }
    public static void main(String[] args) throws IOException {
        JouspDemo.testSimplerTwo();
    }
}
