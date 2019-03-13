import java.lang.reflect.Constructor;

class Animal{
    public String name;
    private int age;
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public void sleep(){
        System.out.println("Animal sleep 5 hours everyday");
    }

    public Animal(){}
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }

    private void play(){
        System.out.println("Animal play");
    }
    public String toString(){
        return "name="+name+" age="+age;
    }
}

public class TestReflection {
    public static void main(String[] args) throws Exception{
        try{
            Class<Animal> c= (Class<Animal>) Class.forName("Animal");
            Animal a=c.newInstance();
            System.out.print(a);
            Constructor<Animal> constructor = c.getDeclaredConstructor(new Class[]{String.class, int.class});
            Animal animal = (Animal) constructor.newInstance(new Object[]{"gekoam",14});
            System.out.println(animal.toString());
        }catch(Exception e){
            e.printStackTrace();
        }

        /* Constructor<Animal> con=c.getConstructor(new Class[]{String.class,int.class});
       Animal ani=con.newInstance(new Animal[]{"gejian",25});
       System.out.println(ani.toString());*/
        /*Animal a=new Animal();
        System.out.println(a.toString());
        Class c=a.getClass();

        Field nameField = c.getField("name");
        nameField.set(a,"gejian");
        System.out.println(a.toString());

        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(a,15);
        System.out.println(a.toString());*/


        /*Method[] methods = c.getMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println(methods[i]);
        }
        Method[] declaredMethods = c.getDeclaredMethods();
        for (int i=0;i<declaredMethods.length;i++){
            System.out.println(declaredMethods[i]);
        }*/





    }
}
