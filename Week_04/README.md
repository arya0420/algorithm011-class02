学习笔记

#  本周所学

## 搜索-遍历
每个节点仅访问一次
每个节点仅仅访问一次
对于节点的访问顺序不同：深度优先搜索、广度优先搜索
优先级优先->启发式搜索
### 深度优先搜索代码模版，用的递归，递归状态树
`def bfs(node):
   if node in visited
        return
   visited.add(node)
   bfs(node.left)
   bfs(node.right)`
### 广度优先搜索代码模版，用的队列，而不是递归或者栈
`def BFS(graph, start, end):
     visited = set()
 	queue = [] 
 	queue.append([start]) 
 	while queue: 
 		node = queue.pop() 
 		visited.add(node)
 		process(node) 
 		nodes = generate_related_nodes(node) 
 		queue.push(nodes)
 	# other processing work 
 	... `
 
 ## 贪心算法
 贪心算法是一种在每一步都中都采取在当前状态下最好或者最优(即最有利)的选择，
 从而希望导致结果是全局最好或最优的算法。
 
 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，
 不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对
 当前进行选择，有回退功能。
 
 贪心：当下做局部最优判断
 回溯：能够回退
 动态规划：最优判断+回退
 
 贪心算法可以解一些最优化问题，如最小生成树，
 对于工程和生活中的问题，
 贪心法一般不能得到我们所要求的答案。
 
 贪心法可以用做辅助算法或者直接解决一些要求结果不特别精确的问题。
 
 贪心算法的适用场景
 解法：从前往后贪、从后往前贪、转换一下再贪、或者从局部切入贪心

## 二分查找【代码模版和边界条件要注意一下】
二分查找的前提
1、目标函数单调性(单调递增或者递减)
2、存在上下界
3、能够通过索引访问
`代码模版
left,right=0,len(array)-1
while left<=right:
 mid=(left+right)/2
 if array[mid]==target:
    break or return result
  elif array[mid]<array:
    left=mid+1
  else:
     right=mid+1 
    `

#  本周所做

1、柠檬水找零
2、分发饼干
3、x 的平方根	
4、在每个树行中找最大值	
5、二叉树的层序遍历	
6、有效的完全平方数	


#  本周所想

1、贪心算法的几个简单题目理解起来和贪心挂钩不大呀，感觉就是找规律或者找技巧，找到了那个突破点代码就很好写，否则就很难写