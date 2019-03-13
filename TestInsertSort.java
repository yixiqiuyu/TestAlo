class InsertSort{
    public void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0;j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }

    public void printAll(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}

public class TestInsertSort {
    public static void main(String[] args){
        int[] a={1,5,2,8,4};
        InsertSort i=new InsertSort();
        i.insertSort(a);
        i.printAll(a);
    }
}
