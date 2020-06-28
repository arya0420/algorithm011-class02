public class PlusOne{
    public static void main(String[] args) {
        int[] origin={1,9,9,1};
        int[] res=PlusOne(origin);
    }

    public static int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0) return digits;
        int step=1;
        for(int i=digits.length-1;i>=0;i--){
            int value=digits[i]+step;
            digits[i]=value%10; //取摸
            //进位标识，这个数字处理完成以后下一个数字是否还需要+1处理？
            step=value/10; //除
        }
        if(step==1){//如果经过一轮循环之后还有进位1
            int[] result=new int[digits.length+1];
            result[0]=1;
            return result;
        }
        return digits;
    }
}