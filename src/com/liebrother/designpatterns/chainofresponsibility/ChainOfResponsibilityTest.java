package com.liebrother.designpatterns.chainofresponsibility;

import java.util.Random;

/**
 * @author James
 * @date 2019/2/21
 */
public class ChainOfResponsibilityTest {

    public static void main(String[] args) {
        Interviewee interviewee = new Interviewee("小明");
        TeamLeader teamLeader = new TeamLeader("老刚");
        DepartMentManager departMentManager = new DepartMentManager("老孙");
        HR hr = new HR("老刘");
        teamLeader.setNextInterviewer(departMentManager);
        departMentManager.setNextInterviewer(hr);
        teamLeader.handleInterview(interviewee);
    }

}

/**
 * 面试者
 */
class Interviewee {

    private String name;

    private boolean teamLeaderOpinion;
    private boolean departMentManagerOpinion;
    private boolean hrOpinion;

    public Interviewee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTeamLeaderOpinion() {
        return teamLeaderOpinion;
    }

    public void setTeamLeaderOpinion(boolean teamLeaderOpinion) {
        this.teamLeaderOpinion = teamLeaderOpinion;
    }

    public boolean isDepartMentManagerOpinion() {
        return departMentManagerOpinion;
    }

    public void setDepartMentManagerOpinion(boolean departMentManagerOpinion) {
        this.departMentManagerOpinion = departMentManagerOpinion;
    }

    public boolean isHrOpinion() {
        return hrOpinion;
    }

    public void setHrOpinion(boolean hrOpinion) {
        this.hrOpinion = hrOpinion;
    }
}

/**
 * 面试官
 */
abstract class Interviewer {

    protected String name;
    protected Interviewer nextInterviewer;

    public Interviewer(String name) {
        this.name = name;
    }

    public Interviewer setNextInterviewer(Interviewer nextInterviewer) {
        this.nextInterviewer = nextInterviewer;
        return this.nextInterviewer;
    }

    public abstract void handleInterview(Interviewee interviewee);

}

/**
 * 组长
 */
class TeamLeader extends Interviewer {

    public TeamLeader(String name) {
        super(name);
    }

    @Override
    public void handleInterview(Interviewee interviewee) {
        System.out.println("组长[" + this.name + "]面试[" + interviewee.getName() + "]同学");
        interviewee.setTeamLeaderOpinion(new Random().nextBoolean());
        if (interviewee.isTeamLeaderOpinion()) {
            System.out.println("[" + interviewee.getName() + "]同学组长轮面试通过");
            this.nextInterviewer.handleInterview(interviewee);
        } else {
            System.out.println("[" + interviewee.getName() + "]同学组长轮面试不通过");
        }
    }
}

/**
 * 部门经理
 */
class DepartMentManager extends Interviewer {

    public DepartMentManager(String name) {
        super(name);
    }

    @Override
    public void handleInterview(Interviewee interviewee) {
        System.out.println("部门经理[" + this.name + "]面试[" + interviewee.getName() + "]同学");
        interviewee.setDepartMentManagerOpinion(new Random().nextBoolean());
        if (interviewee.isDepartMentManagerOpinion()) {
            System.out.println("[" + interviewee.getName() + "]同学部门经理轮面试通过");
            this.nextInterviewer.handleInterview(interviewee);
        } else {
            System.out.println("[" + interviewee.getName() + "]同学部门经理轮面试不通过");
        }
    }
}

/**
 * HR
 */
class HR extends Interviewer {


    public HR(String name) {
        super(name);
    }

    @Override
    public void handleInterview(Interviewee interviewee) {
        System.out.println("HR[" + this.name + "]面试[" + interviewee.getName() + "]同学");
        interviewee.setHrOpinion(new Random().nextBoolean());
        if (interviewee.isHrOpinion()) {
            System.out.println("[" + interviewee.getName() + "]同学HR轮面试通过, 恭喜拿到 Offer");
//            this.nextInterviewer.handleInterview(interviewee);
        } else {
            System.out.println("[" + interviewee.getName() + "]同学HR轮面试不通过");
        }
    }
}

/*
组长[老刚]面试[小明]同学
[小明]同学组长轮面试通过
部门经理[老孙]面试[小明]同学
[小明]同学部门经理轮面试通过
HR[老刘]面试[小明]同学
[小明]同学HR轮面试通过, 恭喜拿到 Offer
*/