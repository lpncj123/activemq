package cn.lp.designpattern23.bridgingmodepattern;

public class Client {
    public static void main(String[] args) {
        OperatingSystemVersion os = new Windows(new AVIFile());
        os.play("战狼3");
        OperatingSystemVersion mac = new Mac(new REVBBFile());
        mac.play("hh");
    }
}
