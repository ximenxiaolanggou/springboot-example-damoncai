package com.ximen.adapter2;

/**
 * @author zhishun.cai
 * @date 2020/4/20 16:03
 * @note
 */
public class Adapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public int output5V() {
        int src = voltage220V.output220V();
        return src/44;
    }

    public Adapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }
}
