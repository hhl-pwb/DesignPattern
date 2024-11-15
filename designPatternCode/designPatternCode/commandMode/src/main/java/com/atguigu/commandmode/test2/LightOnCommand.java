package com.atguigu.commandmode.test2;

/**
 * 执行命令
 */
public class LightOnCommand implements Command{
    // 持有一个接受者对象的引用
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    //调用接受者的方法来执行命令
    @Override
    public void excute() {
        light.on();
    }
}
