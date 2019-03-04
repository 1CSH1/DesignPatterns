package com.liebrother.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 * @date 2019/2/27
 */
public class ObserverTest {

    public static void main(String[] args) {
        Policeman thPol = new TianHePoliceman();
        Policeman hpPol = new HuangPuPoliceman();

        Citizen citizen = new HuangPuCitizen(hpPol);
        citizen.sendMessage("unnormal");
        citizen.sendMessage("normal");

        citizen = new TianHeCitizen(thPol);
        citizen.sendMessage("normal");
        citizen.sendMessage("unnormal");

    }

}

abstract class Kettle {

    protected BoiledWater boiledWater;

    abstract void isBoiled();

    public void register(BoiledWater boiledWater) {
        this.boiledWater = boiledWater;
    }

}

class JiuYangKettle extends Kettle {

    @Override
    void isBoiled() {
        this.boiledWater.action(this);
    }
}

interface BoiledWater {

    void action(Kettle kettle);

}

class Mom implements BoiledWater {

    @Override
    public void action(Kettle kettle) {

    }

}

abstract class Citizen {

    List pols;

    String help = "normal";

    public void setHelp(String help) {
        this.help = help;
    }

    public String getHelp() {
        return this.help;
    }

    abstract void sendMessage(String help);

    public void setPolicemen() {
        this.pols = new ArrayList();
    }

    public void register(Policeman pol) {
        this.pols.add(pol);
    }

    public void unRegister(Policeman pol) {
        this.pols.remove(pol);
    }
}

interface Policeman {

    void action(Citizen ci);
}

class HuangPuCitizen extends Citizen {

    public HuangPuCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }

    @Override
    public void sendMessage(String help) {
        setHelp(help);
        for(int i = 0; i < pols.size(); i++) {
            Policeman pol = (Policeman) pols.get(i);
            //通知警察行动
            pol.action(this);
        }
    }
}

class TianHeCitizen extends Citizen {

    public TianHeCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }

    @Override
    public void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            Policeman pol = (Policeman) pols.get(i);
            //通知警察行动
            pol.action(this);
        }
    }
}


class HuangPuPoliceman implements Policeman {

    @Override
    public void action(Citizen ci) {
        String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常, 不用出动");
        }
        if (help.equals("unnormal")) {
            System.out.println("有犯罪行为, 黄埔警察出动!");
        }
    }
}

class TianHePoliceman implements Policeman {

    @Override
    public void action(Citizen ci) {
        String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常, 不用出动");
        }
        if (help.equals("unnormal")) {
            System.out.println("有犯罪行为, 天河警察出动!");
        }
    }
}
