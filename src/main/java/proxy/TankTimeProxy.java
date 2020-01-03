package proxy;

/**
 * 适用接口作为传输的参数，实现了多态
 * 只要实现了moveable的接口都可以作为参数，通过构造方法传递
 * 相比于实参，更加灵活，不是某个类的具体代理，而是实现了这个接口的抽象代理
 */
public class TankTimeProxy implements Movable {
    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();
    }
}

class TankLogProxy implements  Movable{
    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    public void move() {
        System.out.println("火车开始前");
        movable.move();
        System.out.println("火车开了之后");
    }
}
