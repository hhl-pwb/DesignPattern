package com.atguigu.commandmode.example.task;

import java.util.concurrent.Callable;

/**
 * 对应的task类属于命令模式的命令（Command）角色，命令角色是定义任务的接口，声明执行方法
 * 在这个例子中，task类型实现了Callable接口，定义了一个call方法，可以返回一个指定类型的结果。
 */
public interface Task extends Callable<Object> {
    //执行方法
    public Object call() throws Exception;

}
