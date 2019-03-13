public class TestSort {
    public static void main(String[] args){
        int[] a={1,4,7,2,6};
        Sort s=new Sort();
        s.selectSort(a);
        s.printArray(a);
    }
}
class Sort{
    //打印数组
    public void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    //冒泡排序
    public void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    //插入排序
    public void insertSort(int[] array){
        for(int i=1;i<array.length;++i){
            int min=array[i];
            int j=i-1;
            for(;j>=0;--j){
                if(array[j]>min){
                    array[j+1]=array[j];
                }else {
                    break;
                }
            }
            array[j+1]=min;
        }
    }

    //选择排序
    public void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            //查找最小值
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            //交换
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
    }
}
