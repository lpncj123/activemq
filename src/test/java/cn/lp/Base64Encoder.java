package cn.lp;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encoder {

    public static void main(String[] args) {
        // 要编码的JSON数组
        String jsonData = "[{\"ExpressOrderNo\":\"22300202366\",\"TradingAmt\":\"79.96\",\"TradingDate\":\"2022-12-23\",\"TradingOrderNo\":\"orderno_20230209008\"}]";

        // 将JSON数组转换为UTF-8编码的字节数组
        byte[] utf8Bytes = jsonData.getBytes(StandardCharsets.UTF_8);

        // 使用Base64编码
        String base64Encoded = Base64.getEncoder().encodeToString(utf8Bytes);

        // 打印Base64编码结果
        System.out.println("Base64编码后: " + base64Encoded);
    }
}
