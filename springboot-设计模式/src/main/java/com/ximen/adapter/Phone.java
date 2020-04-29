package com.ximen.adapter;

import com.ximen.adapter.Adapter;
import com.ximen.adapter.IVoltage5V;

/**
 * @author zhishun.cai
 * @date 2020/4/20 16:07
 * @note
 */
public class Phone {
    public void charing(IVoltage5V iVoltage5V){
        iVoltage5V.output5V();
        System.out.println("5V充电");
    }
}
