package com.liebrother.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019/5/1
 */
public class FlyweightTest {

    public static void main(String[] args) {
        drawByXiaoMing();
        drawByXiaoHong();
    }

    public static void drawByXiaoMing() {
        ICrayon greenCrayon =  CrayonFactory.getCrayon("绿色");
        greenCrayon.draw("草");

        ICrayon grayCrayon = CrayonFactory.getCrayon("灰色");
        grayCrayon.draw("路");
    }

    public static void drawByXiaoHong() {
        ICrayon blueCrayon = CrayonFactory.getCrayon("蓝色");
        blueCrayon.draw("蓝天");

        ICrayon greenCrayon = CrayonFactory.getCrayon("绿色");
        greenCrayon.draw("树");
    }
}

/**
 * 笔袋
 */
class CrayonFactory {

    private static Map<String, ICrayon> data = new HashMap<>();

    public static ICrayon getCrayon(String color) {
        if (data.containsKey(color)) {
            return data.get(color);
        }
        ICrayon crayon = new Crayon(color);
        data.put(color, crayon);
        return crayon;
    }

}

