package com.liebrother.designpatterns.singleton;

public class SingletonErrorTest {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        Car car1 = xiaoMing.travel();
        Car car2 = xiaoMing.goToSchool();
        Car car3 = xiaoMing.getTogether();

        System.out.println("car1 == car2 ? " + (car1 == car2));
        System.out.println("car2 == car3 ? " + (car2 == car3));

    }

}

class Car {
    public void run() {
        System.out.println("走。。。。");
    }
}


class XiaoMing {
    public Car travel() {
        System.out.println("小明去旅游");
        Car car = new Car();
        car.run();
        return car;
    }

    public Car goToSchool() {
        System.out.println("小明去学校");
        Car car = new Car();
        car.run();
        return car;
    }

    public Car getTogether() {
        System.out.println("小明参加聚会");
        Car car = new Car();
        car.run();
        return car;
    }
}