public class TestFind {
    public static void main(String[] args){
        int[] a={1,8,3,6,2};
        sort(a);
        System.out.print(find(a,3));
    }

    public static void sort(int[] array){
        for(int i=0;i<array.length;i++){
            int min=i;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;
        }
    }

    public static int find(int[] o,int num){
        int low=0;
        int high=o.length-1;
        while(low<high){
        int mid=low+(high-low)/2;
        if(num==o[mid]){
            return mid;
        }else if(num>o[mid]){
            low=mid+1;
        }else if(num<o[mid]){
            high=mid-1;
        }
        }
            return -1;
    }
}
