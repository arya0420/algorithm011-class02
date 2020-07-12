//分治算法
/**
 从前序遍历中找根节点，然后从中序遍历中找左右子树；
 然后再不断的循环处理左右子树(根节点-左右子树)

 一开始真是不太明白，也不想看，真是的静下心来硬着头皮看才好一些
 */
class Solution {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点,
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    //分治的代码模版
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        //子问题的终止条件
        if(preorder_left>preorder_right){
            return null;
        }

        //处理当前逻辑
        //1、根据preorder找到根节点
        Integer pre_rootIdx=preorder_left;
        //2、然后再根据根节点从inorder中划分左右子树
        Integer in_rootIdex=indexMap.get(preorder[pre_rootIdx]);
        //3、构建根节点
        TreeNode root=new TreeNode(preorder[pre_rootIdx]);
        //4、得到左子树节点的数量
        int size_left_subtree = in_rootIdex - inorder_left;


        //进入到下一层,对左右子树的子问题进行递归
        //左子树呢:
        // pre:[left+1,left+size_left_subtree]
        //in:[inorder_left,in_rootIdex-1]
        root.left=myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,in_rootIdex-1);
        //右子树呢：
        //pre: [preorder_left+size_left_subtree+1,preorder_right]
        //in:[in_rootIdex+1,inorder_right]
        root.right=myBuildTree(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,in_rootIdex+1,inorder_right);

        //组装结果返回
        return root;
    }


}