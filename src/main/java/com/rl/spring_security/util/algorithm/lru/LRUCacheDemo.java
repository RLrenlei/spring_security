package com.rl.spring_security.util.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ren
 * @description 最近最少使用，因为要满足o(1)时间复杂度，所以采用hash+双向链表的结构，插入快删除快
 * @date 2022/5/21 13:49
 */
public class LRUCacheDemo<k, v> extends LinkedHashMap<k, v> {
    private int capacity;

    public LRUCacheDemo(int capacity) {
        // true 代表访问顺序，false代表插入顺序
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo<Integer, String> lruCacheDemo = new LRUCacheDemo<>(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        // [1, 2, 3]
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4, "d");
        // [2, 3, 4]
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.get(2);
        // [3, 4, 2]
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5, "f");
        // [4, 2, 5]
        System.out.println(lruCacheDemo.keySet());
    }
}
