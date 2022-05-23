package com.rl.spring_security.util.algorithm.lru;

import java.util.*;

/**
 * @author Ren
 * @description 自己实现双向链表和hash定义
 * @date 2022/5/21 14:10
 */
public class LRUCacheDemo2 {

    // 先写node
    class Node<k, v> {
        k key;
        v value;
        Node<k, v> prev;
        Node<k, v> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node (k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    // 然后实现双向链表
    class DoubleLinkedList<k, v> {
        Node<k, v> head;
        Node<k, v> tail;

        // 初始化
        public DoubleLinkedList() {
            this.head = new Node<k, v>();
            this.tail = new Node<k, v>();
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        // 头插法
        public void add(Node<k, v> node) {
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next.prev = node;
            this.head.next = node;
        }

        // 删数据
        public void removeNode(Node<k, v> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        // 得到最后一个
        public Node<k, v> getLast() {
            if (this.tail.prev == head) {
                return null;
            }
            return this.tail.prev;
        }

        // 倒叙输出所有key
        @Override
        public String toString() {
            List<k> list = new ArrayList<>();
            Node<k, v> node = this.head.next;
            while (node != tail) {
                list.add(node.key);
                node = node.next;
            }
            Collections.reverse(list);
            return list.toString();
        }
    }

    private int cacheSize;
    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 保证hash，o(1)找到
        Node<Integer, Integer> node = map.get(key);
        // 这样可以保证最近使用的永远在头部，到时删除的时候只需要删除尾部就行了
        doubleLinkedList.removeNode(node);
        doubleLinkedList.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            doubleLinkedList.removeNode(node);
            doubleLinkedList.add(node);
        } else {
            if (map.size() == cacheSize) {
                Node<Integer, Integer> last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.add(node);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo2 lruCacheDemo2 = new LRUCacheDemo2(3);
        lruCacheDemo2.put(1, 1);
        lruCacheDemo2.put(2, 2);
        lruCacheDemo2.put(3, 3);
        System.out.println(lruCacheDemo2.doubleLinkedList);
        lruCacheDemo2.put(4, 4);
        System.out.println(lruCacheDemo2.doubleLinkedList);
        lruCacheDemo2.get(2);
        System.out.println(lruCacheDemo2.doubleLinkedList);
    }
}
