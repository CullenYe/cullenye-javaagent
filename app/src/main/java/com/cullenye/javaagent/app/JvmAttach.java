package com.cullenye.javaagent.app;


import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;
import java.util.Properties;

/**
 * 使用agmentmain监控方法
 * 通过loadAgent加载监控程序
 * @author yeguanhong
 */
public class JvmAttach {

    public static void main(String[] args)
            throws Exception {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            if (vmd.displayName().endsWith("MainRun")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                Properties props = virtualMachine.getSystemProperties();
                String version = props.getProperty("java.version");

                virtualMachine.loadAgent("E:\\IdeaProjects\\cullenye-javaagent\\agent\\target\\agent-1.0-SNAPSHOT.jar","...");

                System.out.println("version:"+version);
                virtualMachine.detach();
            }
        }
    }
}

