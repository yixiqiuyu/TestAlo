import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student{
    String name;
    int age;
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString(){
        return name+" "+age;
    }
}

public class TestIterator {
    public static void main(String[] args){
        List<Student> list=new ArrayList<Student>();
        for (int i=0;i<100;i++){
            Student s=new Student("gejian",19);
            list.add(s);
        }
        Iterator it=list.iterator();
        long start=System.nanoTime();
        Student s1=null;
        while(it.hasNext()){
            s1= (Student) it.next();
        }
        long end=System.nanoTime();
        System.out.println((end-start)/1000);

        long start1=System.nanoTime();
        Student s3=null;
        for(Student s2:list){
            s3=s2;
        }
        long end1=System.nanoTime();
        System.out.println((start1-end1)/1000);
    }

}


