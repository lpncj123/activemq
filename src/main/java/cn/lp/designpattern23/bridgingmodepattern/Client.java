package cn.lp.designpattern23.bridgingmodepattern;

import org.apache.kafka.common.utils.OperatingSystem;

public class Client {
    public static void main(String[] args) {
        OperatingSystemVersion os = new Windows(new AVIFile());
        os.play("战狼3");
    }
}
