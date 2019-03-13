public class TestQuickSort {
    public static void main(String[] args){
        int[] a={1,5,2,7,4};
        QuickSort q=new QuickSort();
        q.quickSot(a);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
class QuickSort{
    public void quickSot(int[] array){
        quickSortInternally(array,0,array.length-1);
    }

    //快速排序递归函数，p、r为下标
    private void quickSortInternally(int[] array,int p,int r){
        if(p>r)return;
        int q=partition(array,p,r);//获取分区点
        quickSortInternally(array,p,q-1);
        quickSortInternally(array,q+1,r);
    }

    private int partition(int[] array,int p,int r){
        int pivot=array[r];
        int i=p;
        for(int j=p;j<r;++j){
            if(array[i]<pivot){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                ++i;
            }
        }

        int temp=array[i];
        array[i]=array[r];
        array[r]=temp;

        System.out.println("i="+i);
        return i;
    }
}