package cn.lp;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JiaMiTest extends TestJunit{
    @Autowired
    private StringEncryptor stringEncryptor;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test(){

        // 原值
        String str = "P@ssword123";

        // 加密
        String ciphertext = stringEncryptor.encrypt(str);
        System.out.println("加密值::" + ciphertext); // 加密值::AgQD8VjIbtFP0xXgTYEu+eeC+ldwVqlYisCJBESKSNE=

        // 解密
        String plaintext = stringEncryptor.decrypt(ciphertext);
        System.out.println("解密值::" + plaintext); // 解密值::92664CB0533C7DE2
    }
    @Test
    public void test2(){
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
