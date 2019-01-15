package com.liebrother.designpatterns.factorymethod;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        // 小明骑摩托车去学校
        IVehicle motorcycle = GarageFactory.getVehicle("motorcycle");
        xiaoMing.goToSchool(motorcycle);

        // 小明开汽车去旅游
        IVehicle car = GarageFactory.getVehicle("car");
        xiaoMing.travel(car);
    }

}

/**
 * 车库
 */
class GarageFactory {

    public static IVehicle getVehicle(String type) {
        if ("car".equals(type)) {
            return new Car();
        } else if ("motorcycle".equals(type)) {
            return new Motorcycle();
        }
        throw new IllegalArgumentException("请输入车类型");
    }

}

/**
 * 交通工具
 */
interface IVehicle {
    void run();
}

/**
 * 汽车
 */
class Car implements IVehicle {

    @Override
    public void run() {
        System.out.println("开汽车去。。。。");
    }
}

/**
 * 摩托车
 */
class Motorcycle implements IVehicle {

    @Override
    public void run() {
        System.out.println("骑摩托车去。。。。");
    }
}


class XiaoMing {

    public void goToSchool(IVehicle vehicle) {
        System.out.println("小明去学校");
        vehicle.run();
    }

    public void travel(IVehicle vehicle) {
        System.out.println("小明去旅游");
        vehicle.run();
    }

}

