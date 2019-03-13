public class GenericArray<T> {
    public T[] data;
    int size;

    public GenericArray(int capacity){
        data=(T[])new Object[capacity];
        size=0;
    }

    //无参构造方法，默认容量为10
    public GenericArray(){
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取当前元素个数
    public int count(){
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //修改index位置的元素
    public void set(int index,T e){
        checkIndex(index);
        data[index]=e;
    }

    //获取对应index位置元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    //查看数组是否包含元素e
    public boolean contain(T e){
        for(int i=0;i<size;i++){
            if(data[i]==e){
                return true;
            }
        }
        return false;
    }

    //获取对应元素的下标，否则返回-1
    public int find(T e){
        for(int i=0;i<size;i++){
            if(data[i]==e){
                return i;
            }
        }
        return -1;
    }

    //在index位置插入元素，时间复杂度O(m+n)
    public void add(int index,T e){
        if(size==data.length){
            resize(data.length*2);
        }
        for(int i=size-1;i>index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    //向数组头部插入数据
    public void addFirst(T e){
        add(0,e);
    }

    //向数组尾部插入数据
    public void addLast(T e){
        add(size,e);
    }

    //删除index位置的元素，并返回
    public T remove(int index){
        checkIndexForRemove(index);
        T ret=data[index];
        for(int i=index;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        //缩容
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    //删除第一个元素
    public T removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public T removeLast(){
        return remove(size-1);
    }

    //从数组中删除指定元素
    public void removeElement(T e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
    }

    //toString方法
    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Array size=%d \n",size,data.length));
        builder.append('[');
        for (int i=0;i<size;i++){
            builder.append(data[i]);
            if(i!=size-1){
                builder.append(',');
            }
        }
        builder.append(']');
        return builder.toString();
    }

    //扩容方法
    public void resize(int capacity){
        T[] newData= (T[]) new Object[capacity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }


    //检查index是否大于数组长度或小于0
    private void checkIndex(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed! Require index>=0 and index<size");
        }
    }

    private void checkIndexForRemove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("add failed! Require index>=0 and index<size");
        }
    }

    public static void main(String[] args) {
        GenericArray<String> array = new GenericArray<>();
        array.add(0, "gejian");
        array.add(1, "wanger");

        System.out.println(array.toString());
    }
}
