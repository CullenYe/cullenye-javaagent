package com.cullenye.javaagent.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 监控test方法脚本
 * @author yeguanhong
 */
@BTrace
public class TestBtrace {

    @OnMethod(
            clazz = "com.cullenye.javaagent.demo.controller.DemoController",
            method = "test",
            location = @Location(Kind.ENTRY)
    )
    public static void checkEntry(
           @ProbeClassName String pcn,
           @ProbeMethodName String pmn,
           AnyType[] args
    ){
        BTraceUtils.println("Class: "+pcn);
        BTraceUtils.println("Method: "+pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println("===========================");
        BTraceUtils.println();
    }

}
