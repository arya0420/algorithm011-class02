int[] nums = {10, 9, 1, -1, 0, 2, -1, 9, 9, 9};
        int k = 3;
        HashMap<Integer, Integer> hashmap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
        if (hashmap.containsKey(nums[i])) {
        int value = hashmap.get(nums[i]);
        hashmap.put(nums[i], value + 1);
        }else {
        hashmap.put(nums[i], 1);
        }
        }
        for(Integer key:hashmap.keySet())
        {
        System.out.println("Key: "+key+" Value: "+hashmap.get(key));
        }
        //hashmap里面的值是：1-3 2-1 3-1 4-1...
        //用最小堆来存储,建堆,建立一个大小为k、比较器为map中value值比较的小顶堆
        PriorityQueue heap = new PriorityQueue(k, new Comparator<Integer>() {
@Override
public int compare(Integer o1, Integer o2) {
        return hashmap.get(o1) - hashmap.get(o2);
        }
        });
        //往堆中加入元素：遍历map的keyset，如果说堆的大小，那么往堆中加入元素，元素的顺序为按照map的value值排序的key值
        for (Integer key : hashmap.keySet()) {
        if (heap.size() < k) {
        heap.add(key);
        } else if (hashmap.get(key) > hashmap.get(heap.peek())) {
        heap.remove();
        heap.add(key);
        }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
        res[i] = (Integer) heap.remove();
        i++;
        }

        for(int kk=0;kk<res.length;kk++){
        System.out.println(res[kk]);
        }
        }