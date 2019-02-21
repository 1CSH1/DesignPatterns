package com.liebrother.designpatterns.command;

/**
 * @author James
 * @date 2019/2/21
 */
public class CommandTest {

    public static void main(String[] args) {
        Developer xiaoMing = new Developer("小明");
        Command developCommand = new DevelopCommand(xiaoMing);
        Command suspendCommand = new SuspendCommand(xiaoMing);
        Requirement requirement = new Requirement("新增黑名单");
        TechnicalManager2 technicalManager = new TechnicalManager2("大明");
        technicalManager.setCommand(developCommand);
        technicalManager.action(requirement);

        technicalManager.setCommand(suspendCommand);
        technicalManager.action(requirement);

    }

}

/**
 * 命令
 */
abstract class Command {

    protected Developer developer;

    public Command(Developer developer) {
        this.developer = developer;
    }

    public abstract void execute(Requirement requirement);
}

/**
 * 开始开发
 */
class DevelopCommand extends Command {

    public DevelopCommand(Developer developer) {
        super(developer);
    }

    @Override
    public void execute(Requirement requirement) {
        this.developer.develop(requirement);
    }
}

/**
 * 开发中断
 */
class SuspendCommand extends Command {

    public SuspendCommand(Developer developer) {
        super(developer);
    }

    @Override
    public void execute(Requirement requirement) {
        this.developer.suspend(requirement);
    }
}

/**
 * 技术经理
 */
class TechnicalManager2 {

    private String name;
    private Command command;

    public TechnicalManager2(String name) {
        this.name = name;
    }

    public void action(Requirement requirement) {
        this.command.execute(requirement);
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

