package cn.lp;

import cn.lp.model.Person;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestEquals {
    public static void main(String[] args) {
        Person person = new Person();
        Person person2 = new Person();
        System.out.println(person2.equals(person));
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        String s1 = "1";
        String s2 = "1";
        String string = new String("eqe");
        String string1 = new String("eqe");
        System.out.println(string.equals(string1));
        System.out.println(string==string1);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(new BigDecimal(100>>>2));
        Map<String, String> map = new HashMap<>(16);
        String s = "100012123231321";
        int i = s.hashCode() ^ (s.hashCode() >>> 16);
        System.out.println(s.hashCode());
        System.out.println(s.hashCode() >>> 16);
        System.out.println(i);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
