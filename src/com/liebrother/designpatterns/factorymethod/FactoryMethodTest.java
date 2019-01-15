package com.liebrother.designpatterns.factorymethod;

public class FactoryMethodTest {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        // 小明骑摩托车去学校
        VehicleGarage motorcycleGarage = new MotorcycleGarage();
        IVehicle motorcycle = motorcycleGarage.getVehicle();
        xiaoMing.goToSchool(motorcycle);

        // 小明开汽车去旅游
        VehicleGarage carGarage = new CarGarage();
        IVehicle car = carGarage.getVehicle();
        xiaoMing.travel(car);
    }

}

interface VehicleGarage {
    IVehicle getVehicle();
}

/**
 * 汽车车库
 */
class CarGarage implements VehicleGarage {

    @Override
    public IVehicle getVehicle() {
        return new Car();
    }
}

/**
 * 摩托车车库
 */
class MotorcycleGarage implements VehicleGarage {

    @Override
    public IVehicle getVehicle() {
        return new Motorcycle();
    }
}



