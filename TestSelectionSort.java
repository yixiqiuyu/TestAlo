class SelectionSort{
    public void selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;
        }
    }

    public void printAll(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}

public class TestSelectionSort {
    public static void main(String[] args){
        int[] a={3,5,1,2,7};
        SelectionSort s=new SelectionSort();
        s.selectionSort(a);
        s.printAll(a);
    }
}
