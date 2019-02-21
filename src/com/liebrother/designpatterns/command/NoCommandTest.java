package com.liebrother.designpatterns.command;

/**
 * @author James
 * @date 2019/2/21
 */
public class NoCommandTest {

    public static void main(String[] args) {
        Developer xiaoMing = new Developer("小明");
        Requirement requirement = new Requirement("新增黑名单");
        TechnicalManager1 technicalManager2 = new TechnicalManager1("大明");
        technicalManager2.setDeveloper(xiaoMing);
        technicalManager2.action(requirement, "develop");
        technicalManager2.action(requirement, "suspend");
    }

}

/**
 * 开发人员
 */
class Developer {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void develop(Requirement requirement) {
        System.out.println(this.name + " 开始开发需求：" + requirement.getName());
    }

    public void suspend(Requirement requirement) {
        System.out.println(this.name + " 停止开发需求：" + requirement.getName());
    }

    public String getName() {
        return name;
    }

}

/**
 * 需求
 */
class Requirement {
    private String name;

    public Requirement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

/**
 * 技术经理
 */
class TechnicalManager1 {

    private String name;

    private Developer developer;

    public TechnicalManager1(String name) {
        this.name = name;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void action(Requirement requirement, String type) {
        if ("develop".equals(type)) {
            this.developer.develop(requirement);
        } else if ("suspend".equals(type)) {
            this.developer.suspend(requirement);
        }
    }

}

