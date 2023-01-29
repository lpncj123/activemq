package cn.lp.tools;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URL;

public class ImageTest {
    public static void main(String[] args) throws Exception {
        String imageUrl = "https://unified-test.jlishop.com/2022-11-04/ec299db7597f4d4b8f20c3a9564d7ef9/null.jpg";
        URL url = new URL(imageUrl);
        DataInputStream dis = new DataInputStream(url.openStream());
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        byte[] bs = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = dis.read(bs)) != -1) {
            fos.write(bs, 0, len);
        }
        fos.flush();
        byte[] bytes = fos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String encodeStr = encoder.encode(bytes);
        System.out.println(encodeStr);
        dis.close();
        fos.close();
    }
}
