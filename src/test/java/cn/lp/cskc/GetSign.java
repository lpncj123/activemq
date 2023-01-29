package cn.lp.cskc;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

@Slf4j
public class GetSign {
    public String getAuth() {
        Optional<String> sign = getSign("supplychain-base-oms", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjeZMrdEa26DEAuAmKdDJ5GSPUTHiczJSdnsumwGPgPWCqDAZW/O5iaXdqQ3t40VY5h0vyifnxtQ7Qz6THzRHGj2+0EKVCB5qBPuB3EItwPlzAFAXbFvKsnfcgLDIHXunSdeklBjMzeFeERNfYAFLTwrtHMWXEk8qLqx7wqTpgZ+s/berrhCwjVzMWgwhWBAzYUCY5JFqyk/k//wzOhbq04KXPN4upfblX+4xleoyIzzbZ4n8m+03bEfulSYM/0OcCUFSqqpgFgbkOuCeWrDp9YS8W4SDOm6dzoaj72JkuXzid1V2d9us8HcJIvODFa8rCSwJna6SXAfmvuVX1Hn+1wIDAQAB");

        String encrypt = sign.orElse("");
        return encrypt;
    }

    public Optional<String> getSign(String clientID, String publicKey) {
        if (!StringUtils.isBlank(clientID) && !StringUtils.isBlank(publicKey)) {
            RSA rsa = SecureUtil.rsa(null, publicKey);
            long currentTime = System.currentTimeMillis();
            String source = clientID + ":" + currentTime;
            String encrypt = rsa.encryptBase64(source, KeyType.PublicKey);
            return Optional.ofNullable(encrypt);
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) throws IOException {
        GetSign getSign = new GetSign();
        String auth = getSign.getAuth();
        RequestConfig requestConfig = RequestConfig.custom()
            // 设置连接超时时间
            .setConnectTimeout(2000)
            // 设置响应超时时间
            .setSocketTimeout(2000)
            .build();
        List<Header> headers = new ArrayList<>();
        //创建httpClient链接
        HttpClient httpClient = HttpClients.custom()
            .setDefaultHeaders(headers)
            .setDefaultRequestConfig(requestConfig)
            .build();
        String url = "http://dohko.supplychain.hw.hualala.com/oms/platformapi/stock/queryStockAvailableQuantity";
        HttpPost httpPost = new HttpPost(url);
        Map map = new HashMap<>();
        map.put("ent","8151");
        map.put("productCodes","DC228153");
        map.put("warehouseCode","DC01");
        HttpEntity httpEntity = new StringEntity(JSON.toJSONString(map));
        httpPost.setEntity(httpEntity);
        httpPost.setHeader("charset","utf-8");
        httpPost.setHeader("content-type","application/json");
        httpPost.setHeader("clientID","supplychain-base-oms");
        httpPost.setHeader("sign",auth);
        HttpResponse response = httpClient.execute(httpPost);
        JSONObject jsonResult = null;
        if(response.getStatusLine().getStatusCode()==200){
           String str = EntityUtils.toString(response.getEntity());
            jsonResult = (JSONObject) JSONObject.parse(str);
        }
        System.out.println(jsonResult);

    }
}
