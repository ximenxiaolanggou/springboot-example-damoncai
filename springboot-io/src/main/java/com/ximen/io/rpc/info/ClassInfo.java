package com.ximen.io.rpc.info;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author zhishun.cai
 * @date 2020/4/3 9:17
 * @note
 */
public class ClassInfo implements Serializable {

    private String methodName;

    private String className;

    private Class[] argTypes;

    private Object[] args;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class[] getArgTypes() {
        return argTypes;
    }

    public void setArgTypes(Class[] argTypes) {
        this.argTypes = argTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "methodName='" + methodName + '\'' +
                ", className='" + className + '\'' +
                ", argTypes=" + Arrays.toString(argTypes) +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
