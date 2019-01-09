package com.liebrother.designpatterns.ocp;

import java.math.BigDecimal;

public class OcpTest {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        IPatient xiaoMing = new Patient("小明");
        hospital.sellMedicine(xiaoMing);

        IPatient xiaoHong = new OneLevelSocialSecurityPatient("小红");
        hospital.sellMedicine(xiaoHong);

        IPatient xiaoHua = new TwoLevelSocialSecurityPatient("小花");
        hospital.sellMedicine(xiaoHua);

        IPatient xiaoJie = new ThreeLevelSocialSecurityPatient("小杰");
        hospital.sellMedicine(xiaoJie);
    }

}


class Medicine {
    private String name;
    private BigDecimal price;

    public Medicine(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

class Hospital {

    private Medicine medicine = new Medicine("阿司匹林", new BigDecimal(20));

    public void sellMedicine(IPatient patient) {
        BigDecimal money = patient.pay(medicine);
        System.out.println(patient.getName() + " 花了 " + money.setScale(2, BigDecimal.ROUND_UP) + " 块钱买了药：" + medicine.getName());
    }

}

interface IPatient {
    String getName();
    BigDecimal pay(Medicine medicine);
}

class Patient implements IPatient{

    private String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal pay(Medicine medicines) {
        return medicines.getPrice();
    }

    @Override
    public String getName() {
        return name;
    }

}


/**
 * 小红的实现
 */
/*
class Medicine {
    private String name;
    private BigDecimal price;

    public Medicine(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPrice1() {
        return price.multiply(new BigDecimal(0.7));
    }

    public BigDecimal getPrice2() {
        return price.multiply(new BigDecimal(0.8));
    }

    public BigDecimal getPrice3() {
        return price.multiply(new BigDecimal(0.9));
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
*/

/**
 * 小花的实现
 */
/*
class Patient implements IPatient{

    private String name;
    private int level;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal pay(Medicine medicines) {
        if (level == 1) {
            return medicines.getPrice().multiply(new BigDecimal(0.7));
        } else if (level == 2) {
            return medicines.getPrice().multiply(new BigDecimal(0.8));
        } else if (level == 3) {
            return medicines.getPrice().multiply(new BigDecimal(0.9));
        }
        return medicines.getPrice();
    }

    @Override
    public String getName() {
        return name;
    }

}
*/

/**
 * 小明的实现
 */
class OneLevelSocialSecurityPatient implements IPatient {

    private String name;

    public OneLevelSocialSecurityPatient(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal pay(Medicine medicine) {
        return medicine.getPrice().multiply(new BigDecimal(0.7));
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class TwoLevelSocialSecurityPatient implements IPatient {

    private String name;

    public TwoLevelSocialSecurityPatient(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal pay(Medicine medicine) {
        return medicine.getPrice().multiply(new BigDecimal("0.8"));
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class ThreeLevelSocialSecurityPatient implements IPatient {

    private String name;

    public ThreeLevelSocialSecurityPatient(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal pay(Medicine medicine) {
        return medicine.getPrice().multiply(new BigDecimal("0.9"));
    }

    @Override
    public String getName() {
        return this.name;
    }
}