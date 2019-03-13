class Queue {
    private String[] items;
    private int n;
    private int head=0;
    private int tail=0;
    public Queue(){}
    //创建一个大小为capacity的队列
    public Queue(int capacity){
        items=new String[capacity];
        n=capacity;
    }
    //入队列
    public boolean enqueue(String s){
        /*if (tail==n)return false;
        items[tail]=s;
        tail++;
        return true;*/
        //队列满的时候判断
        if (tail==n){
            //如果队头也满，则说明队列满了
            if(head==0)return false;
            //否则向前移动之后再入队
            else{
                for (int i=head;i<tail;i++){
                    items[i-head]=items[i];
                }
                tail-=head;
                head=0;
            }
        }
        //入队
        items[tail]=s;
        tail++;
        return true;
    }

    //出队列
    public String dequeue(){
        //当队头和队尾相同时，说明队列为空
        if (head==tail)
            return null;
        //出队
        String ret=items[head];
        head++;
        return ret;
    }

    //打印队列
    public void printAll(){
        for(int i=head;i<tail;i++){
            System.out.println(items[i]+" ");
        }
    }
}
public class TestQueue{
    public static void main(String[] args){
        Queue q=new Queue(5);
        q.enqueue("gejian");
        q.enqueue("haha");
        q.enqueue("xiaoming");
        q.enqueue("xiaohong");
        q.dequeue();
        q.enqueue("xiaohua");
        boolean b=q.enqueue("mi");
        System.out.println(b);
        q.printAll();
    }
}
