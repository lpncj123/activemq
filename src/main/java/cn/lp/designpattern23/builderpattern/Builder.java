package cn.lp.designpattern23.builderpattern;

/**
 * @author lp
 */
public abstract class Builder {
    protected Bike mBike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();

}
