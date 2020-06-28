学习笔记

# 本周所学
学习内容：数组、栈、队列、链表、跳表、优先队列、双端队列。
以及老师所说的关于刻意练习、算法学习和LeetCode的刷题技巧。

# 本周所做
刷了几道算法题目，基本上都是老师出的题目，还有与上面所学相关的几道题。

# 本周所想
1、虽然过了一遍【数组、栈、队列、链表、跳表、优先队列、双端队列】的数据结构，但是
看完视频之后几乎忘掉，不知道是年纪大了还是怎么滴。还是要多练所想才行。
正如另一个老师所说：眼过千遍不如手过一遍，一定不要光听不练，按时完成作业。
2、刷题的时候，一开始想的都是暴力解法，能解就能解，解不了那就完全没有思路。
   是不是思维定势？一看题解，发现人家写的好精妙，备受打击。
3、以前自己也看过几道题，但是基本上都是挑简单的，然后还不会。
这次跟着老师困难的也竟然上了，好像有点小小进步，至少不畏惧了。
4、印象中老师说过程序只做重复性的工作、也都是if、loop、recursion等，听起来好像也不难的样子。
5、优先队列、双端队列还需要多加练习。
6、时间没安排好，另外自己刷题有点慢，比较费时间，后面还是需要尽量往前赶。


# 课后题目
## 用 add first 或 add last 这套新的 API 改写 Deque 的代码
       ` Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addLast("d");
        System.out.println(deque);

        String first = deque.getFirst();
        System.out.println(first);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }

        System.out.println(deque);`
## Queue和PriorityQueue 分析
### Queue
`boolean add(E e);往队列中添加元素，如果添加成功返回true，如果因为空间不够等原因会跑各种异常。
boolean offer(E e);往队列中添加元素，如果添加成功返回true，否则为false或者抛异常。
E remove();取出头部元素， 队列为空则抛出NoSuchElementException
E poll();取出头部元素， 队列为空则返回null
E element();获取头部元素的值，队列为空则抛出NoSuchElementException
E peek();获取头部元素的值，队列为空则返回null`
### PriorityQueue
`没看得懂，作为一个TODO待办事项
`








