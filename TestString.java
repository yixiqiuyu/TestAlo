import org.junit.Test;

public class TestString {
    @Test
    //String的连接
    public void test1(){
        String s1="a";
        String s2="a";
        String s3="a"+s1;
        String s4="a"+"a";
        String s5=s1+s2;
        //表达式只有常量时，编译期完成运算
        //表达式有变量时，运行期才算，所以地址不同
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s4=="aa");
        /*
        * 输出结果：
        * false
        * false
        * true
        * */
    }
    @Test
    //String类型的intern
    public void test2(){
        //s1是基本类型，比较值，s2是String实例，比较地址
        //字符串类型用equals方法只会比较值
        String s1="a";
        String s2=new String("a");
        //调用intern方法时 ，如果s2中的字符串不在常量池，则加入常量池并返回常量的引用
        String s3=s2.intern();
        System.out.println(s1==s2);
        System.out.println(s1==s3);

        /*
        * 输出：
        * false
        * true
        * */
    }
    @Test
    public void test3(){
        //StringBuffer sb=new StringBuffer();
        StringBuilder sb=new StringBuilder();
        sb.append("1234");
        System.out.println(sb.reverse());
        sb.replace(0,2,"mmm");
        System.out.println(sb);
        sb.delete(0,3);
        System.out.println(sb);
        System.out.println();
    }
}
