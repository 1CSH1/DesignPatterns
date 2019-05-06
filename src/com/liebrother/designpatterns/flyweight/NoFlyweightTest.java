package com.liebrother.designpatterns.flyweight;

public class NoFlyweightTest {

    public static void main(String[] args) {
        drawByXiaoMing();
        drawByXiaoHong();
    }

    public static void drawByXiaoMing() {
        ICrayon greenCrayon =  new Crayon("绿色");
        greenCrayon.draw("草");

        ICrayon grayCrayon = new Crayon("灰色");
        grayCrayon.draw("路");
    }

    public static void drawByXiaoHong() {
        ICrayon blueCrayon = new Crayon("蓝色");
        blueCrayon.draw("蓝天");

        ICrayon greenCrayon = new Crayon("绿色");
        greenCrayon.draw("树");
    }

}

interface ICrayon {

    void draw(String place);

}

/**
 * 蜡笔
 */
class Crayon implements ICrayon {

    private String color;

    public Crayon(String color) {
        System.out.println("---新建【" + color + "】蜡笔" );
        this.color = color;
    }

    @Override
    public void draw(String place) {
        System.out.println("用" + this.color + "蜡笔画" + place);
    }
}