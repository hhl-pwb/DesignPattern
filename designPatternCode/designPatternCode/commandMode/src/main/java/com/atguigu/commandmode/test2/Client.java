package com.atguigu.commandmode.test2;

/**
 * 命令模式是一种行为型设计模式，它将一个请求封装成一个对象，从而使你可以用不同的请求对客户进行参数化，
 * 或者对请求排队，或者记录请求日志，或者支持可撤销的操作。
 * 命令模式的主要角色有以下四个：
 * 命令接口（command）：定义了执行命令的方法，通常只有一个execute()方法。
 * 具体命令（ConcreteCommand）：实现了命令接口，持有一个接受者对象的引用，并调用其相应的方法来执行命令
 * 请求者（Invoker）：负责调用命令对象执行请求。
 * 接收者（Receiver）：执行与请求相关的操作，它具体实现了对请求的业务处理
 *
 * 举个例子：请求着就是一个遥控器，具体命令就是遥控器上的按钮，按钮连接者一个具体的业务，
 * 这个业务就是接收者，这个业务本身自己不会直接执行，而是等待命名对象给它下达命令，
 * 接收到命令后，才会执行具体的业务。而具体的命令就需要请求者，去按遥控器上的按钮执行具体的命令。
 * 这样做的好处：就是具体要执行的命令和业务本身是分开的，比如说开灯的业务逻辑需要修改的话，
 * 用户不需要知道具体修改了哪些内容，他只要关心遥控器上按哪个按钮就行了，就是说只要找对遥控器，
 * 找对遥控器上的按钮就可以吧这个灯打开，具体打开灯的逻辑发生了怎样的变化，是不用管的。
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个接收者对象
        Light light = new Light();
        // 创建一个命令对象，将接收者传递给它
        Command command = new LightOnCommand(light);
        // 创建一个请求对象，将命令传给它
        RemoteControl remoteControl = new RemoteControl(command);
        // 模拟按下按钮，执行操作
        remoteControl.pressButton();
        // 输出结果：电灯打开了
    }
}
