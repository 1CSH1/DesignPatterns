package com.liebrother.designpatterns.singleton;

public class SingletonRightLazyTest {

    public static void main(String[] args) {
        XiaoMing2 xiaoMing2 = new XiaoMing2();
        Car2 car1 = xiaoMing2.travel();
        Car2 car2 = xiaoMing2.goToSchool();
        Car2 car3 = xiaoMing2.getTogether();

        System.out.println("car1 == car2 ? " + (car1 == car2));
        System.out.println("car2 == car3 ? " + (car2 == car3));
    }

}


class Car2{

    private static Car2 car2;

    public static synchronized Car2 getInstance() {
        if (null == car2) {
            System.out.println("买车啦。。。");
            car2 = new Car2();
        }
        return car2;
    }

    private Car2() {

    }

    public void run(){
        System.out.println("走。。。。");
    }
}

class XiaoMing2
{
    public Car2 travel() {
        System.out.println("小明去旅游");
        Car2 car = Car2.getInstance();
        car.run();
        return car;
    }

    public Car2 goToSchool() {
        System.out.println("小明去学校");
        Car2 car = Car2.getInstance();
        car.run();
        return car;
    }

    public Car2 getTogether() {
        System.out.println("小明参加聚会");
        Car2 car = Car2.getInstance();
        car.run();
        return car;
    }
}

