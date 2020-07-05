学习笔记

# 本周所学
## 理论知识
1、哈希表及其工程实践
2、为什么会出现树形结构：从实际生活需求和工程需求上面去分析。
3、可以迅速找到一堆数中最大或者最小值的数据结构。
  将根节点最大的堆叫做大顶堆，根节点最小的堆叫做小顶堆，常见的堆有二叉堆、斐波那契堆等。
  堆是一种抽象的数据数据，二叉堆只是堆的一种实现方式可能并不是很实用。  
4、图：有点有边。有向图和无向图。
   表示方法：邻接矩阵和邻接表。
   常见算法：DFS代码和BFS-->标准的DFS模版，递归
   代码模版本身一定要熟记于心，变成条件反射，不需要花时间去思考那种。类似于锻炼的肌肉式记忆。
   
  
## 方法&技巧&思想&精妙总结
1、精选代码库
2、最大的误区是只做一遍
3、升维的思想，目的在于加速
4、链表是特殊化的树、树是特殊化的图.
   树和图最关键的差别是有没有环，如果有环就叫做图。
5、树的操作，一定不要害怕递归，要拥抱递归并且爱上递归这种形式   
## 必熟悉、机械化记忆的代码
`//树节点的定义
public class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}`
`//前中后序的递归遍历
//前序遍历
//中序遍历
//后序遍历
`
# 本周所做
## leetcode刷题
1、字母异位词以及分组
2、两数之和
## HashMap小总结
1、是基于哈希表实现的一个键值对的集合数据类型。
2、底层是数组+链表+红黑树(jdk1.8引入)，Node<K,V>[] table
3、核心put()方法，涉及到hash()、resize()、treeifyBin()等操作
4、非线程安全类，多个线程操作可能会出现线程安全的问题
### HashMap简介和类关系
HashMap是基于哈希表实现的一个键值对的数据集合类型。
继承了AbstractMap抽象类，实现了Map、Cloneable、Serializable接口。
HashMap的底层实现jdk1.7以前单纯是是数组+链表，jdk1.8之后引入了红黑树；
数组是主干，链表/红黑树是为了解决哈希冲突而存在的。
### HashMap的成员变量
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //默认初识容量 1 << 4 ，也就是16，必须是2的整数次方。
static final int MAXIMUM_CAPACITY = 1 << 30; //最大容量， 2^ 30 次方。
static final float DEFAULT_LOAD_FACTOR = 0.75f;//默认加载因子，大小为0.75。
static final int TREEIFY_THRESHOLD = 8;//树形阈值，大于这个数就要树形化，也就是转成红黑树。
static final int MIN_TREEIFY_CAPACITY = 64;//树形最小容量。

transient Node<K,V>[] table;//哈希表的链接数组，对应桶的下标---->非常重要的字段
//实现了 Map.Entry 接口
static class Node<K,V> implements Map.Entry<K,V> {
    //哈希值，就是位置
    final int hash;
    //键
    final K key;
    //值
    V value;
    //指向下一个节点的指针
    Node<K,V> next;
}

transient Set<Map.Entry<K,V>> entrySet;//键值对集合。
transient int size;//键值对的数量，也就是HashMap的大小
transient int modCount;
int threshold;//阈值，下次需要扩容时的值，等于 容量*加载因子。
final float loadFactor;//加载因子
### HashMap的构造方法
public HashMap(）
public HashMap(int initialCapacity)
public HashMap(int initialCapacity, float loadFactor)
public HashMap(Map<? extends K, ? extends V> m)
### HashMap的关键方法
put()插入数据的方法逻辑以及涉及到的一些重要方法
`public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
 }`
 `static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 }`
 `final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                    boolean evict) {
         Node<K,V>[] tab; Node<K,V> p; int n, i;
         if ((tab = table) == null || (n = tab.length) == 0)
         ....
 }`
 1、先调用 hash() 方法计算哈希值：hash(key)
 2、然后调用 putVal() 根据第1步计算出来的哈希值进行相关操作
 2.1、如果当前 哈希表内容为空，做扩容：n = (tab = resize()).length;
 2.2、如果要插入的桶中没有元素，新建个节点并放进去，tab[i] = newNode(hash, key, value, null);
      可以看下Node<K,V>的定义：
      //用来定位数组索引位置
      final int hash;
      //键
      final K key;
      //值
      V value;
      //指向下一个节点的指针
      Node<K,V> next;
 2.3、否则从要插入的桶中第一个元素开始查找
      如果没有碰撞，赋值给e，结束查找
      有碰撞，而且当前采用的还是 红黑树的节点，调用 putTreeVal() 进行插入
      链表节点的话从传统的链表数组中查找、找到赋值给e，结束
      如果链表长度达到8，转换成红黑树
 2.4、最后检查是否需要扩容
 
 put方法的代码中有几个关键的方法，分别是：
 hash():哈希函数，计算key对应的位置，是HashMap中的核心函数，在存储数据时，将key传入中进行运算，
        得出key的哈希值，通过这个哈希值运算才能获取key应该放置在 “桶” 的哪个位置。(key的hashCode)
 resize():扩容
 putTreeVal():插入红黑树的节点
 treeifyBin():树形化容器

### HashMap的一些总结
1、代码好复杂和精妙
2、非线程安全类，多个线程操作可能会出现线程安全的问题
3、搞清楚HashMap，首先需要知道HashMap是什么，即它的存储结构-字段；(数据底层具体存储的是什么？这样的存储方式有什么优点呢？)
   其次弄明白它能干什么，即它的功能实现-方法。
资料：https://blog.csdn.net/qq_40574571/article/details/97612100?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-2

## 上一节中的PriorityQueue优先队列源码解析
【它是什么｜数据底层具体存储的是什么｜它能干什么】
优先队列，PriorityQueue的逻辑结构是一棵完全二叉树(二叉堆)，存储结构其实是一个数组。
逻辑结构层次遍历的结果刚好是一个数组。
PriorityQueue默认是一个小顶堆，可以传入自定义的Comparator函数来实现大顶堆。
下面通过它的源码来具体分析分析它的数据存储以及相关操作的实现。
### 字段
`private static final int DEFAULT_INITIAL_CAPACITY = 11; 默认容量
transient Object[] queue; 存放元素的数组
private int size = 0; 优先队列中元素的个数
private final Comparator<? super E> comparator;比较器，如果没有的话就是默认自然排序
transient int modCount = 0 该优先队列被修改的次数
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;数组最大长度
`
### 构造函数
1、默认容量+自然排序(无Comparator对象)
2、指定容量+自然排序(无Comparator对象)
3、默认容量+指定比较器
4、指定容量+指定比较器
5、从已有的Collection对象中构造PriorityQueue
6、从已有的PriorityQueue对象中构造新的PriorityQueue
7、从已有的SortedSet对象中构造新的PriorityQueue
### 核心方法
`public boolean add(E e) {
        return offer(e);
    }   //添加元素
add涉及到两个核心动作：
1、如果当前优先队列元素的个数大于等于数组的长度，那么自动扩容数组长度(重新申请一个+1长度的数组并拷贝元素过去)。
2、如果优先队列长度为0，那么新元素就加入到数组为0的位置，否则就往堆中压入元素，然后从下往上调整堆为小顶堆。
调整的过程为：从k指定的位置开始，将x逐层与当前点的parent进行比较并交换，直到满足x >= queue[parent]为止。
            注意这里的比较可以是元素的自然顺序，也可以是依靠比较器的顺序。
public E poll(){}  //返回队首元素，队首元素出队列
1、取出下标为0的元素(小顶堆，也就是最小的元素)
2、并用最后一个元素替换0下标位置的元素，之后调用siftDown()方法对堆进行调整，
最后返回原来0下标处的那个元素（也就是最小的那个元素）。
siftDown(int k, E x)方法详解：该方法的作用是从k指定的位置开始，
将x逐层向下与当前点的左右孩子中较小的那个交换，直到x小于或等于左右孩子中的任何一个为止。
`

# 本周所想
1、由衷的感叹设计精妙的工程代码，又是感觉自己是傻子的第二周


