public class Array {
    //定义整型数组保存元素
    public int data[];
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;

    //构造方法，定义数组大小
    public Array(int capacity){
        this.data=new int[capacity];
        this.n=capacity;
        this.count=0;
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index){
        if(index<0||index>count)
            return -1;
        else
            return data[index];
    }

    //在index位置插入元素
    public boolean insert(int index,int value){
        if(count==n){
            System.out.println("没有位置可插入");
            return false;
        }
        //如果count还没有满，那么久可以插入数据到数组
        //如果不合法
        if(index<0||index>count){
            System.out.println("位置不合法");
            return false;
        }
        //位置合法
        for(int i=count;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=value;
        count++;
        return true;
    }
    //根据index删除元素
    public boolean delete(int index){
        if(index<0||index>count)
            return false;
        for(int i=index;i<count;i++){
            data[i]=data[i+1];
        }
        count--;
        return true;
    }

    //打印
    public void printAll(){
        for(int i=0;i<count;i++){
            System.out.println(data[i]+" ");
        }
    }

    public static void main(String[] args){
        Array array=new Array(6);
        array.insert(0,1);
        array.insert(0,2);
        array.printAll();
    }
}
