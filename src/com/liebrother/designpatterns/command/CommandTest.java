package com.liebrother.designpatterns.command;

/**
 * @author James
 * @date 2019/2/21
 */
public class CommandTest {

    public static void main(String[] args) {
        Command command = new CommandImpl();
        TechnicalManager technicalManager = new TechnicalManager("大明");
        technicalManager.setCommand(command);

        Developer xiaoMing = new Developer("小明");
        Requirement requirement1 = new Requirement("新增黑名单");
        command.setDeveloper(xiaoMing);
        technicalManager.action(requirement1);

        Requirement requirement2 = new Requirement("新增白名单");
        Developer xiaoHong = new Developer("小红");
        command.setDeveloper(xiaoHong);
        technicalManager.action(requirement2);
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
 * 开发人员
 */
class Developer {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void develop(Requirement requirement) {
        System.out.println(requirement.getName() + " 这个需求由 " + this.name + " 开发");
    }

    public String getName() {
        return name;
    }

}

abstract class Command {

    protected Developer developer;

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public abstract void distributeRequirement(Requirement requirement);
}

/**
 * 需求分配
 */
class CommandImpl extends Command {

    @Override
    public void distributeRequirement(Requirement requirement) {
        System.out.println(requirement.getName() + " 需求分配处理");
        this.developer.develop(requirement);
    }
}

class TechnicalManager {


    private String name;
    private Command command;

    public TechnicalManager(String name) {
        this.name = name;
    }

    public void action(Requirement requirement) {
        this.command.distributeRequirement(requirement);
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

/*
public class CommandTest {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}

class Receiver {

    public void doSometiong(){
        System.out.println("doSomething");
    }

}

abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();

}

class ConCommand extends Command {

    public ConCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.receiver.doSometiong();
    }
}

class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

}
*/
