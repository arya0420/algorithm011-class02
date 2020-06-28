public class PlusOne{
    public static void main(String[] args) {
        int[] origin={1,9,9,1};
        int res=trap(origin);
    }

    public static int trap(int[] height) {
        int res=0;
        for(int i=0;i<height.length;i++){
            int left_h=0,right_h=0;
            //往走左
            for(int j=i;j>=0;j--){
                left_h=Math.max(left_h,height[j]);
            }
            //往右走
            for(int j=i;j<height.length;j++){
                right_h=Math.max(right_h,height[j]);
            }
            res=res+(Math.min(left_h,right_h)-height[i]);
        }
        return res;
    }
}