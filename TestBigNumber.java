public class TestBigNumber {
    public static void main(String[] args){
        System.out.println(bigNumberSum("123456789","11111111"));
    }
    //两个大数字相加
    public static String bigNumberSum(String bigNumberA,String bigNumberB){
        char[] charsA=new StringBuffer(bigNumberA).reverse().toString().toCharArray();
        char[] charsB=new StringBuffer(bigNumberB).reverse().toString().toCharArray();
        int maxLength=charsA.length>charsB.length?charsA.length:charsB.length;
        int[] result=new int[maxLength+1];
        //遍历数组，按位相加
        for(int i=0;i<result.length;i++){
            int temp=result[i];
            if(i<charsA.length){
                temp+=charsA[i]-'0';
            }
            if(i<charsB.length){
                temp+=charsB[i]-'0';
            }
            //判断是否进位
            if(temp>=10){
                temp=temp-10;
                result[i+1]=1;
            }
            result[i]=temp;
        }
        //把result数组在此逆序并转成String
        StringBuilder sb=new StringBuilder();
        boolean flag=true;
        for(int i=result.length-1;i>=0;i--){
            if (result[i]==0&&flag){
                continue;
            }
            flag=false;
            sb.append(result[i]);
        }
        return sb.toString();
    }

}
