package com.ximen.adapter;

/**
 * @author zhishun.cai
 * @date 2020/4/20 16:03
 * @note
 */
public class Adapter extends Voltage220V implements IVoltage5V {

    public int output5V() {
        int src = output220V();
        return src/44;
    }
}
