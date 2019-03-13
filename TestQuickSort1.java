public class TestQuickSort1 {
    public static void main(String[] args){
        int[] a={1,5,3,8,6};
        sort(a,0,a.length-1);
        printAll(a);
    }

    public static void printAll(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static int dividerAndChange(int[] array,int start,int end){
        //标准值
        int pivot=array[start];
        while(start<end){
            /*
            * 从右向左寻找，一直找到比参照值还小的数值，进行替换
            * 这里要注意，循环条件必须是 当后面的数小于参照值时
            * 我们才跳出这一循环
            * */
            while (start<end&&array[end]>=pivot){
                end--;
            }
                if (start<end){
                    swap(array,start,end);
                    start++;
                }

            while (start<end&&array[start]<pivot){
                start++;
            }
                if(start>end){
                    swap(array,end,start);
                    end--;
                }

        }
        array[start]=pivot;
        return pivot;
    }

    public static void sort(int[] array,int start,int end){
        //当分治的元素大于1的时候才有意义
        if(end-start>1){
            int mid=0;
            mid=dividerAndChange(array,start,end);
            //对左部分排序
            sort(array,start,mid);
            //对右部分排序
            sort(array,mid+1,end);
        }
    }

    public static void swap(int[] array,int fromIndex,int toIndex){
        array[fromIndex]=array[toIndex];
    }
}
