List<List<Integer>> res = new LinkedList<>();
public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
        }
        void backtrack(int[] nums, LinkedList<Integer> track){
        //结束条件
        if(track.size()==nums.length){
        res.add(new LinkedList(track));
        return ;
        }

        //选择、递归处理
        for (int i = 0; i < nums.length; i++){
        //比如说上一次选择了A,那么这一次就不能再选择A,直接跳过选择下一个,需要判断一下
        if(track.contains(nums[i])){
        continue;
        }

        //做选择,选择了元素
        track.add(nums[i]);
        System.out.println(nums[i]+"-track.add-"+track);
        //递归选择下一个元素
        backtrack(nums,track);
        //取消选择(这一句的作用......有点不得其解.....好好琢磨琢磨擦才行---把它放在idea里面调试了一下才知道运行路径，不然蒙圈了都)
        track.removeLast();
        System.out.println(nums[i]+"-track.removeLast-"+track);
        }
        }