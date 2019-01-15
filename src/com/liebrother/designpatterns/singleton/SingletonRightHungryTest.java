package com.liebrother.designpatterns.singleton;

public class SingletonRightHungryTest {

    public static void main(String[] args) {
        XiaoMing1 xiaoMing1 = new XiaoMing1();
        Car1 car1 = xiaoMing1.travel();
        Car1 car2 = xiaoMing1.goToSchool();
        Car1 car3 = xiaoMing1.getTogether();

        System.out.println("car1 == car2 ? " + (car1 == car2));
        System.out.println("car2 == car3 ? " + (car2 == car3));

    }

}


class Car1{

    private static Car1 car1 = new Car1();

    public static Car1 getInstance() {
        return car1;
    }

    private Car1() {

    }

    public void run(){
        System.out.println("走。。。。");
    }
}

class XiaoMing1 {
    public Car1 travel() {
        System.out.println("小明去旅游");
        Car1 car = Car1.getInstance();
        car.run();
        return car;
    }

    public Car1 goToSchool() {
        System.out.println("小明去学校");
        Car1 car = Car1.getInstance();
        car.run();
        return car;
    }

    public Car1 getTogether() {
        System.out.println("小明参加聚会");
        Car1 car = Car1.getInstance();
        car.run();
        return car;
    }
}