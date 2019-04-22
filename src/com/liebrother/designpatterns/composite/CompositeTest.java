package com.liebrother.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @date 2019/4/22
 */
public class CompositeTest {

    public static void main(String[] args) {
        // 透明模式
        Leader2 leader1 = new Leader2("大熊");
        Leader2 leader2 = new Leader2("中熊");
        Engineer2 engineer1 = new Engineer2("小熊1");
        Engineer2 engineer2 = new Engineer2("小熊2");

        leader1.add(leader2);
        leader2.add(engineer1);
        leader2.add(engineer2);

        leader1.display(0);


        // 安全模式
        Leader3 leader3 = new Leader3("大熊");
        Leader3 leader31 = new Leader3("中熊");
        Engineer3 engineer31 = new Engineer3("小熊1");
        Engineer3 engineer32 = new Engineer3("小熊2");

        leader3.add(leader31);
        leader31.add(engineer31);
        leader31.add(engineer32);

        leader3.display(0);

    }

}

/**
 * 透明模式
 */
abstract class Employer {

    private String name;
    private List<Employer> employers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    public abstract void add(Employer employer);

    public abstract void remove(Employer employer);

    public abstract void display(int index);

}

class Leader2 extends Employer {

    public Leader2(String name) {
        this.setName(name);
        this.setEmployers(new ArrayList<>());
    }

    @Override
    public void add(Employer employer) {
        this.getEmployers().add(employer);
    }

    @Override
    public void remove(Employer employer) {
        this.getEmployers().remove(employer);
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("领导：" + this.getName());
        this.getEmployers().forEach(employer -> {
            employer.display(index + 1);
        });
    }
}

/**
 * 工程师
 */
class Engineer2 extends Employer {

    public Engineer2(String name) {
        this.setName(name);
    }

    @Override
    public void add(Employer employer) {
        // 没有下属
    }

    @Override
    public void remove(Employer employer) {
        // 没有下属
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("工程师：" + this.getName());
    }
}


/**
 * 安全模式
 */
abstract class Employer2 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display(int index);

}

class Leader3 extends Employer2 {

    private List<Employer2> employers;

    public Leader3(String name) {
        this.setName(name);
        this.employers = new ArrayList<>();
    }

    public void add(Employer2 employer) {
        this.employers.add(employer);
    }

    public void remove(Employer2 employer) {
        this.employers.remove(employer);
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("领导：" + this.getName());
        this.employers.forEach(employer -> {
            employer.display(index + 1);
        });
    }
}

class Engineer3 extends Employer2 {

    public Engineer3(String name) {
        this.setName(name);
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("工程师：" + this.getName());
    }
}

