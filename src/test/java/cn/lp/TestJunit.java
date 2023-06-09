package cn.lp;

import cn.hutool.core.util.RandomUtil;
import com.google.common.base.Joiner;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.TreeMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJunit {
  public static void main(String[] args) {
    String format = String.format("https://bankfrontv2.jieqianhua.com/api/DHNotify/PayMentNotify", "21312312321");
    System.out.println(format);
    String s = RandomUtil.randomString(16);
    System.out.println(s);
    Map map = new TreeMap();
    map.put("1","2");map.put("3","4");
    String join = Joiner.on("&").withKeyValueSeparator("=").join(map);
    System.out.println(join);
  }
  @Test
  public void createJasypt(){
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    //加密配置
    EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
    config.setAlgorithm("PBEWithMD5AndDES");
    //自己在用的时候更改此密码
    config.setPassword("P@ssword123");
    //应用配置
    encryptor.setConfig(config);
    System.out.println(encryptor.encrypt("P@ssword123"));
  }
  @Test
  public void testStringEquals(){
    String demoStringOne = "hello";
    String demoStringTwo = "hello";
    System.out.println(demoStringOne==demoStringTwo);
    String demoStringThree = new String("hello");
    System.out.println(demoStringOne == demoStringThree);
  }
  @Test
  public void yYAndZy(){
    System.out.println("\"\"");
    System.out.println("李四/n李五");
    System.out.println("李四\\\n李五");
  }
  @Test
  public void charTest(){
    char name ='刘';
    System.out.println(name);

  }
}
