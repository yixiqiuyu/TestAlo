/*
* 单例模式：
* 使用一个私有构造函数，一个私有静态变量和一个公有静态函数来实现
*
* */
public class Singleton {
    private static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            uniqueInstance=new Singleton();
        }
        return uniqueInstance;
    }
}

class Singleton1{
    private static Singleton1 uniqueInstance1=new Singleton1();
    private Singleton1(){}
    public static Singleton1 getUniqueInstance1(){
        return uniqueInstance1;
    }
}
