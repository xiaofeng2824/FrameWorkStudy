package proxy;

import sun.security.tools.keytool.CertAndKeyGen;

import java.util.Random;

/**
 * 静态代理
 * 1.代理对象里有一个被代理对象
 * 2.通过构造方法传入被代理对象
 * 3.代理对象也实现被代理对象实现的接口
 * 4.在实现的接口里，调用被代理对象的方法前后调用别的方法，从而实现代理的功能
 *
 * 分析：
 * 缺点
 * 1.静态代理耦合太强
 * 2.对于每个要被代理的类都必须要有个被代理对象
 *
 * 优点：
 * 1.实现了代理的功能
 * 2.对于数量少的对象被代理对象适用
 *
 * 优化：传入的被代理对象可以传入接口 类似于装饰者模式了
 *
 *
 *
 */
public class Tank implements Movable {


    public void move() {
        System.out.println("火车开始走动啦，kakakka");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //被代理类
        //new Tank().move();
        new TankProxy(new Tank()).move();
    }
}

 class TankProxy implements Movable{

     Tank tank;
     public TankProxy(Tank tank) {
         this.tank = tank;
     }

     public void move() {
         System.out.println("火车开动！！！");
         tank.move();
         System.out.println("火车开动");
      }
}
