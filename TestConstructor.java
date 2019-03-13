import java.lang.reflect.Constructor;

class Dog{
    String name;
    int age;
    public Dog(){
        System.out.println("Dog()");
    }
    public Dog(String name, int age) {
        System.out.println("Dog(String, int)");
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name + " " + age;
    }
}
public class TestConstructor {
    public static void main(String[] args) throws Exception {
        Class c = Dog.class;
        Dog d1 = (Dog) c.newInstance();
        System.out.println(d1);
//获得构造方法
        Constructor con = c.getConstructor(
                new Class[]{String.class, int.class});
//创建对象时指定构造方法
        Dog d2 = (Dog) con.newInstance(
//为构造方法传递的参数
                new Object[]{"Snoopy", new Integer(5)});
        System.out.println(d2);
    }
}

