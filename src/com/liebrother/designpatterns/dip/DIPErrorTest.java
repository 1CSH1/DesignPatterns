package com.liebrother.designpatterns.dip;

/**
 * @author LieBrother
 * @date 2018/12/30
 */
public class DIPErrorTest {

    public static void main(String[] args) {
        /** 初始化老板和员工 */
        StaffA staffA = new StaffA("A 员工");
        StaffB staffB = new StaffB(" B 员工");
        Boss bossA = new BossA(staffA);
        Boss bossB = new BossB(staffB);

        /** A 老板向 B 老板求支援 */
        bossA.askHelp(bossB); // 打印出：B 员工提供服务

        /** B 员工向 A 老板求支援 */
        staffB.askHelp(bossA); // 打印出：A 员工提供服务

        // 如果这时 A 老板裁掉 A 员工，换了个 C 员工呢？要把 A 老板的类中的 StaffA 去掉，改为 StaffC，
        // 还要新增一个 StaffC 类，这时是非常费劲的，仅仅是因为我们破坏了第三条规则。
    }

}

/**
 * 错误的示范
 */
abstract class Boss {

    abstract void support();

    abstract void askHelp(Boss boss);
}

abstract class Staff {

    private String name;

    abstract void service();

    abstract void askHelp(Boss boss);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BossA extends Boss {

    private StaffA staffA;

    public BossA(StaffA staffA) {
        this.staffA = staffA;
    }

    @Override
    void support() {
        staffA.service();
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }

}

class BossB extends Boss {

    private StaffB staffB;

    public BossB(StaffB staffB) {
        this.staffB = staffB;
    }

    @Override
    void support() {
        staffB.service();
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}

class StaffA extends Staff {

    public StaffA(String name) {
        this.setName(name);
    }

    @Override
    void service() {
        System.out.println(this.getName() + "提供服务");
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}

class StaffB extends Staff {

    public StaffB(String name) {
        this.setName(name);
    }

    @Override
    void service() {
        System.out.println(this.getName() + "提供服务");
    }

    @Override
    void askHelp(Boss boss) {
        boss.support();
    }
}

