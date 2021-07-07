package com.cullenye.javaagent.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 监控test方法脚本2
 * @author yeguanhong
 */
import static com.sun.btrace.BTraceUtils.*;
@BTrace
public class MoreBtrace {

    @OnMethod(
            clazz = "com.cullenye.javaagent.demo.controller.DemoController",
            method = "test",
            location = @Location(value = Kind.CALL,
                    clazz = "/.*/", method = "/.*/",
                    where = Where.AFTER))
    public static void onInvoke(@Self Object self, @TargetInstance Object instance,
                              @TargetMethodOrField String method,
                              @Duration long duration){
        BTraceUtils.println(strcat("self: ", str(self)));
        BTraceUtils.println(strcat("instance: ", str(instance)));
        BTraceUtils.println(strcat("method: ", str(method)));
        BTraceUtils.println(strcat("duration(ns): ", str(duration )));
        println("===========================");
        BTraceUtils.println();
    }
}
