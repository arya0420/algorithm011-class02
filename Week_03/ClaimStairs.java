public int climbStairs(int n) {
        //傻递归会超时
        //记忆化递归走一波(傻递归超时，但是记忆化递归的化超过100%？ 这么惊人的嘛。。。)
        //动态规划还没学
        int[] mem=new int[n+1];
        return climb_Stairs(n,mem);
        }
// n最大楼梯 mem记忆化楼梯
public static int climb_Stairs(int n,int[] mem){
        // System.out.println("===循环了n次==:"+n);

        if(n<=3){
            mem[n]=n;
        }
        if(mem[n]>0){
            return mem[n];
        }

        mem[n]=climb_Stairs(n-1,mem)+climb_Stairs( n-2,mem);

        return mem[n];
}