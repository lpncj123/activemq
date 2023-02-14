package cn.lp.rsa;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
@Slf4j
public class RsaTest {
  private static final String privateKe="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCZ9YkAHoSu7UnJaNnf+wMfuQy0\n" +
      "LMC6wojHNlAhlaFXx7ubFMttkqkc7rD/89cgthVd7nLZr060D/gUNUlXswBH+vqvv4tF0EdyWqbl\n" +
      "GsPspm9EQTIsvPe1MeUIzZdoMyIuuNsh2OJbvvIc6lKQei04LqKF1JnMjlxQdTnX6RGo02u6kt0B\n" +
      "ZnNyK+b91Ks8jg2d6/W8lsqO0GA3hu79jcZzQo4bZE1+qDMJaXRGLKyws4iQ+j9ma7SWbCWBU7KX\n" +
      "tuQf1ZIDjkr/BXAlSwXwEFytc5DCVpRRrm7NZ64yhc6CUx52+x6zN58QEnwo6movsw+YrS8v9NpV\n" +
      "QO9I3Rhwn7UBAgMBAAECggEAPOyK8D8jZk2EG22geh/MlqsVud7TzZPZqGt3vjKGDER/mtjZv1yA\n" +
      "C3DxHfgSM2Gahvcq/7V9wYdoNib4BPpSrClHNnDn3hKTk08IKDU1PtqFwU7DWizVISDDb35b4eIK\n" +
      "Ls77+CLpQEEJciPP1FhkuIzLx4Xf7rCPG0+oOiaC1Hln6Fgl0jeL2758Dyaj2i/XWKycyMZuXn0T\n" +
      "GYKfv0RW+1ZCUa0I8pH8Or5HpCGiIIotlgHScTzw2uGevMhBval9PeyqJn6MT5onItPcFp6fFtKc\n" +
      "ZoH9kEx6pz7BUTwMuKm/xgKsAo7A5zbuUxXcpT7SgOaYjlIuumonXFAx5zsUgQKBgQDVeKB7d3mi\n" +
      "7fTyRlB6ocwgafztamqbAFFL0uIM5hPkk7SEFJPDt6b/UmUPFqfG6pqvdR7xWiuK8dYgCT+mONFk\n" +
      "5WLU3pKujV5LrtfIuO85H8YZV9FDkRWa24Rvn6yz9ok/DDJpBDIyKly0rtanMaF8ffc8Rwh+zFu3\n" +
      "Ithfq90VGQKBgQC4obJvBO01aEGKMLpaaSrm0ituD0sDG3uHs+6wC7VxWDpfydEf0txVw24ctQZJ\n" +
      "bo5fnLOZMmEcomjfy+ohR1ny2IHIJjhAe3XWm9APF6IedyJ8y3PDgx5gQcqFeAEuZl89VY54J3ZR\n" +
      "YG48uhmbrKLruxZbQl5wTEH4sRalTuh0KQKBgGkHycYVuaY9eBhAGlbMBrgoDcbuZfdPh7BL2ObJ\n" +
      "yR3cwqN90FoqoSLcclajKfeH9IXBlXDgka3yYQ0wH730FKqU5jSgMgFqEuwf4ZGj1CgCByDvAUpC\n" +
      "NyQTP60AHiQJd+uqX58l7mCaUTShFYH7vF2ZSKzCsl5YxANuRJGF6Of5AoGANs5Y5zexKk9eVSUN\n" +
      "zFS3lXkBx1Pm0m9QBgJVchCntZOZEGIaH7Y6DYNLpl3eFeIphRxA+9LGnPdg5j3jrCk//CRksgMW\n" +
      "Y53CZwgthK1hRGXc6OqD3J+JXs1ozqHGx/0/fDdvaR9dsd5MGt6rR1jBq/QHOOPEoNUiKC55KGz5\n" +
      "97ECgYEAsssOLG4FNDZi0KxgZ+D1DhylkA11mYw54dsYfx91DLUM8Ov7yFr6vPxobdX5wv1Snz9Q\n" +
      "LSPebp0TaoZXdYUJxQcb0zdMqSGTvoR8pP+1d4dbajgK+er0nIk/uVO2cxKt1xV9qJWU+bnFKVnM\n" +
      "ckg+EeHRi+hWwjukn8FqWeUtk5k=";
  private final static  String publickey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmfWJAB6Eru1JyWjZ3/sDH7kMtCzAusKI\n" +
      "xzZQIZWhV8e7mxTLbZKpHO6w//PXILYVXe5y2a9OtA/4FDVJV7MAR/r6r7+LRdBHclqm5RrD7KZv\n" +
      "REEyLLz3tTHlCM2XaDMiLrjbIdjiW77yHOpSkHotOC6ihdSZzI5cUHU51+kRqNNrupLdAWZzcivm\n" +
      "/dSrPI4Nnev1vJbKjtBgN4bu/Y3Gc0KOG2RNfqgzCWl0RiyssLOIkPo/Zmu0lmwlgVOyl7bkH9WS\n" +
      "A45K/wVwJUsF8BBcrXOQwlaUUa5uzWeuMoXOglMedvseszefEBJ8KOpqL7MPmK0vL/TaVUDvSN0Y\n" +
      "cJ+1AQIDAQAB";
  public static void main(String[] args) throws UnsupportedEncodingException {
    String data="我是数据";
    String dataSign="我是需要签名的数据";
    String keyStr = RandomUtil.randomString(16);
    log.info("加密签名16位{}",keyStr);
    byte[] key = keyStr.getBytes(StandardCharsets.UTF_8);
    RSA rsa= SecureUtil.rsa(privateKe,publickey);
    //公钥加密
    byte[] keyRsa = rsa.encrypt(key, KeyType.PublicKey);
    String dataAes = SecureUtil.aes(key).encryptBase64(data);
    log.info("加密成功数据{}",dataAes);

    Sign sign = SecureUtil.sign(SignAlgorithm.SHA1withRSA, privateKe, null);
    byte[] singByte=  sign.sign(dataSign);
    String signStr = Base64.getEncoder().encodeToString(singByte);
    log.info("签名成功数据{}",signStr);

    Sign sign1 = SecureUtil.sign(SignAlgorithm.SHA1withRSA, null, publickey);
    boolean verify = sign1.verify(dataSign.getBytes("utf-8"), Base64.getDecoder().decode(signStr));
    if(verify){
      log.info("验签成功");
    }else{
      System.out.println("验签失败");
    }
    byte[] keyDe = rsa.decrypt(keyRsa, KeyType.PrivateKey);
    log.info("解密秘钥{}",new String(keyDe));
    String s = SecureUtil.aes(keyDe).decryptStr(Base64.getDecoder().decode(dataAes));
    log.info("解密数据",s);
  }
}
