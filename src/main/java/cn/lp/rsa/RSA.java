package cn.lp.rsa;

import org.apache.commons.net.util.Base64;

import java.security.*;

public class RSA {
  public static void main(String[] args) throws NoSuchAlgorithmException {
    String algorithm="RSA";
    //生成密钥对并保存在本地文件中
//        generateKeyToFile(algorithm,"a.pub","a.pri");
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
    //生成密钥对
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    //生成私钥
    PrivateKey privateKey = keyPair.getPrivate();
    //生成公钥
    PublicKey publicKey = keyPair.getPublic();
    byte[]  privateKeyEncoded= privateKey.getEncoded();
    byte[] publicKeyEncoded = publicKey.getEncoded();
    //使用base64进行编码
    String siyao = Base64.encodeBase64String(privateKeyEncoded);
    String gongyao = Base64.encodeBase64String(publicKeyEncoded);
    System.out.println(siyao);
    System.out.println(gongyao);
  }
}
