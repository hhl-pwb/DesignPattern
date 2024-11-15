package com.atguigu.commandmode.test2;

/**
 * 请求者
 */
public class RemoteControl {
    //持有一个命令对象的引用
    private Command command;

    public RemoteControl(Command command) {
        this.command = command;
    }
    //调用命令对象的excute()方法来执行请求
    public void pressButton(){
        command.excute();
    }
}
