package com.liebrother.designpatterns.dip;

/**
 * @author LieBrother
 * @date 2018/12/30
 */
public class DIPRightTest {

    public static void main(String[] args) {
        /** 正确示范 */
        Staff2 staffA2 = new StaffImpl("A 员工");
        Staff2 staffB2 = new StaffImpl("B 员工");
        Boss2 bossA2 = new BossImpl(staffA2);
        Boss2 bossB2 = new BossImpl(staffB2);

        /** A 老板向 B 老板求支援 */
        bossA2.askHelp(bossB2); // 打印出：B 员工提供服务

        /** B 员工向 A 老板求支援 */
        staffB2.askHelp(bossA2); // 打印出：A 员工提供服务

        /** A 老板辞退了 A 员工，换成了 C 员工 */
        Staff2 staffC2 = new StaffImpl("C 员工");
        bossA2.setStaff(staffC2);

        /** B 员工向 A 老板求支援 */
        staffB2.askHelp(bossA2); // 打印出：C 员工提供服务
    }

}
/**
 * 正确的示范
 */
abstract class Boss2 {

    private Staff2 staff;

    public Boss2(Staff2 staff) {
        this.staff = staff;
    }

    abstract void support();

    abstract void askHelp(Boss2 boss);

    public void setStaff(Staff2 staff) {
        this.staff = staff;
    }

    public Staff2 getStaff() {
        return staff;
    }
}

abstract class Staff2 {

    private String name;

    abstract void service();

    abstract void askHelp(Boss2 boss);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BossImpl extends Boss2 {

    public BossImpl(Staff2 staff) {
        super(staff);
    }

    @Override
    void support() {
        this.getStaff().service();
    }

    @Override
    void askHelp(Boss2 boss) {
        boss.support();
    }
}

class StaffImpl extends Staff2{

    public StaffImpl(String name) {
        this.setName(name);
    }

    @Override
    void service() {
        System.out.println(this.getName() + "提供服务");
    }

    @Override
    void askHelp(Boss2 boss) {
        boss.support();
    }
}