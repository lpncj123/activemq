package cn.lp.designpattern23.builderpattern;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
            .cpu("intel")
            .mainboard("华硕")
            .memory("金士顿")
            .screen("三星")
            .build();
        System.out.println(phone);
        showBike(new OfoBuilder());
        showBike(new MobikeBuilder());
    }
    private static void showBike(Builder builder) {
        Director director = new Director(builder);
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
