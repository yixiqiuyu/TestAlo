/*
* 递归需要满足的三个条件
* 1.一个问题的解可以分解为几个子问题的解
* 2.这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样
* 3.存在递归终止条件
* */

public class TestDiGui {
    public static void main(String[] args){
        TestDiGui t=new TestDiGui();
        int m=t.fabnic(5);
        System.out.println(m);
    }
    //递归
    public int fabnic(int n){
        if (n==1)return 1;
        if (n==2)return 1;
        else {
            return fabnic(n-1)+fabnic(n-2);
        }
    }
    //非递归
    public int fabnic1(int n){
        if(n==1)return 1;
        if (n==2)return 1;
        int sum=0;
        int pre=2;
        int prepre=1;
        for(int i=3;i<=n;i++){
                sum=pre+prepre;
                prepre=pre;
                pre=sum;
        }
        return sum;

    }
}
