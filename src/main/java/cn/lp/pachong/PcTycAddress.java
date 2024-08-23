package cn.lp.pachong;

import cn.lp.model.PcBean;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.pachong
 * @Author: lp
 * @CreateTime: 2024-07-26  18:01
 * @Description: TODO
 * @Version: 1.0
 */
public class PcTycAddress {
    public static void main(String[] args) {
        String url = "https://aiqicha.baidu.com/detail/basicAllDataAjax?pid=25802052262730";
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        // 启用JS解释器，默认为true
        webClient.getOptions().setJavaScriptEnabled(true);
        // 禁用css支持
        webClient.getOptions().setCssEnabled(false);
        // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        //当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        // 设置连接超时时间
        webClient.getOptions().setTimeout(10 * 1000);
        //不下载图片
        webClient.getOptions().setDownloadImages(false);
        //很重要，设置支持AJAX
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = null;
        try {
            //url是你要解析的页面路径
            page = webClient.getPage(url);
            System.out.println(page.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        webClient.waitForBackgroundJavaScript(1*1000);
        List<PcBean> list = new ArrayList<>();
//        if(page!=null){
//            //下面要根据不同的页面进行解析
//            String pageAsXml = page.asXml();
//            Document document = Jsoup.parse(pageAsXml);
//            Elements elementsByTag = document.getElementById("databody").getElementsByTag("tr");
//            for (Element element : elementsByTag) {
//                Elements td = element.getElementsByTag("td");
//                PcBean pcBean = new PcBean();
//                pcBean.setHbzl(td.get(0).text());
//                pcBean.setDw(td.get(1).text());
//                pcBean.setHmj(td.get(2).text());
//                pcBean.setHmaij(td.get(3).text());
//                pcBean.setCmj(td.get(4).text());
//                pcBean.setCmaij(td.get(5).text());
//                pcBean.setJzj(td.get(6).text());
//                pcBean.setFbsj(td.get(7).text());
//                list.add(pcBean);
//            }
//        }
//        list.forEach(i-> System.out.println(i));
    }
}
