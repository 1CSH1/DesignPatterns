package com.liebrother.designpatterns.composite;

import java.util.LinkedList;
import java.util.List;

/**
 * @author James
 * @date 2019/4/22
 */
public class NoCompositeTest {

    public static void main(String[] args) {
        Manager manager = new Manager("大熊");
        Leader leader = new Leader("中熊");
        Engineer engineer1= new Engineer("小熊1");
        Engineer engineer2 = new Engineer("小熊2");

        manager.add(leader);
        leader.add(engineer1);
        leader.add(engineer2);

        manager.display(0);
    }

}

/**
 * 经理
 */
class Manager {

    private String name;
    private List<Leader> leaders;

    public Manager(String name) {
        this.name = name;
        this.leaders = new LinkedList<>();
    }

    public void add(Leader leader) {
        this.leaders.add(leader);
    }

    public void remove(Leader leader) {
        this.leaders.remove(leader);
    }

    public void display(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("经理：" + this.name);
        leaders.forEach(leader -> {
            leader.display(index+1);
        });
    }

}

/**
 * 组长
 */
class Leader {

    private String name;
    private List<Engineer> engineers;

    public Leader(String name) {
        this.name = name;
        this.engineers = new LinkedList<>();
    }

    public void add(Engineer engineer) {
        this.engineers.add(engineer);
    }

    public void remove(Engineer engineer) {
        this.engineers.remove(engineer);
    }

    public void display(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("组长：" + this.name);
        engineers.forEach(engineer -> {
            engineer.display(index + 1);
        });
    }
}

/**
 * 工程师
 */
class Engineer {

    private String name;

    public Engineer(String name) {
        this.name = name;
    }

    public void display(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("工程师：" + this.name);
    }

}
