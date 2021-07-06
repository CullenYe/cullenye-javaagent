package com.cullenye.javaagent.app;

/**
 * app中的启动类
 * VM参数中加入：-javaagent:D:\maven\repository\com\cullenye\javaagent\agent\1.0-SNAPSHOT\agent-1.0-SNAPSHOT.jar
 * @author yeguanhong
 */
public class MainRun {
    public static void main(String[] args) {
        hello("world");
    }

    private static void hello(String name) {
        System.out.println("hello " + name );
        try {
            Thread.sleep(3000);//线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
