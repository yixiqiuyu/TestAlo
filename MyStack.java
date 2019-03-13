public class MyStack{
    int[] data;
    int n;
    int count;
    public MyStack(int n){
        data=new int[n];
        this.n=n;
        count=0;
    }
    public void push(int m){
        data[count]=m;
        count++;
    }

    public void delete(){
        if(count==1||count==0)
            return;
        else
            data[count-1]=data[count];
            count--;
    }

    public void pop(){
        data[count]=0;
        count--;
    }

}
