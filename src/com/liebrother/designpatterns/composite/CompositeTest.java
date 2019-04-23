package com.liebrother.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @date 2019/4/22
 */
public class CompositeTest {

    public static void main(String[] args) {
        // 安全模式
        Leader2 leader1 = new Leader2("大熊");
        Leader2 leader2 = new Leader2("中熊");
        Engineer2 engineer1 = new Engineer2("小熊1");
        Engineer2 engineer2 = new Engineer2("小熊2");

        leader1.add(leader2);
        leader2.add(engineer1);
        leader2.add(engineer2);

        leader1.display(0);


        // 透明模式
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
 * 安全模式
 */
abstract class Employee2 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display(int index);

}

class Leader2 extends Employee2 {

    private List<Employee2> employees;

    public Leader2(String name) {
        this.setName(name);
        this.employees = new ArrayList<>();
    }

    public void add(Employee2 employee) {
        this.employees.add(employee);
    }

    public void remove(Employee2 employee) {
        this.employees.remove(employee);
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("领导：" + this.getName());
        this.employees.forEach(employee -> {
            employee.display(index + 1);
        });
    }
}

class Engineer2 extends Employee2 {

    public Engineer2(String name) {
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


/**
 * 透明模式
 */
abstract class Employee3 {

    private String name;
    private List<Employee3> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee3> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee3> employees) {
        this.employees = employees;
    }

    public abstract void add(Employee3 employee);

    public abstract void remove(Employee3 employee);

    public abstract void display(int index);

}

class Leader3 extends Employee3 {

    public Leader3(String name) {
        this.setName(name);
        this.setEmployees(new ArrayList<>());
    }

    @Override
    public void add(Employee3 employee) {
        this.getEmployees().add(employee);
    }

    @Override
    public void remove(Employee3 employee) {
        this.getEmployees().remove(employee);
    }

    @Override
    public void display(int index) {
        for(int i = 0; i < index; i++) {
            System.out.print("----");
        }
        System.out.println("领导：" + this.getName());
        this.getEmployees().forEach(employee -> {
            employee.display(index + 1);
        });
    }
}

/**
 * 工程师
 */
class Engineer3 extends Employee3 {

    public Engineer3(String name) {
        this.setName(name);
    }

    @Override
    public void add(Employee3 employee) {
        // 没有下属
    }

    @Override
    public void remove(Employee3 employee) {
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



