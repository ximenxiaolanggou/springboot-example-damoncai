package com.ximen._3.factory._1.simplefactory;

/**
 * @author zhishun.cai
 * @date 2020/6/16 10:51
 * @note
 */
public class SimpleFactory {

    public static Shape createObj(String shapeType){
        Shape shape = null;
        switch (shapeType){
            case "square":
                shape = new Square();
                break;
            case "circle":
                shape = new Circle();
                break;
            default:
                break;
        }
        return shape;
    }
}
