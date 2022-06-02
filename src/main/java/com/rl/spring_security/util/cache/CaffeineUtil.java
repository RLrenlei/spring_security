package com.rl.spring_security.util.cache;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Ren
 * @description Caffeine工具类
 * @date 2022/5/30 15:12
 */
public class CaffeineUtil {
    /** 手动加载 */
    private static Cache<String, Map<String, Double>> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(10_000)
            .build();

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("1", 12.12);
        map.put("2", 13.13);
        map.put("3", 14.14);
        String key = "IN0000008" + ":" + "2018";
        Map<String, Double> ifPresent = cache.getIfPresent(key);
        if (ifPresent == null) {
            cache.put(key, map);
        }
    }

//    Graph graph = cache.getIfPresent(key);
//    graph = cache.get(key, k -> createExpensiveGraph(key));
//cache.put(key, graph);
//cache.invalidate(key);
//
//    /** 自动加载 */
//    LoadingCache<Key, Graph> cache = Caffeine.newBuilder()
//            .maximumSize(10_000)
//            .expireAfterWrite(10, TimeUnit.MINUTES)
//            .build(key -> createExpensiveGraph(key));
//
//    Graph graph = cache.get(key);
//    Map<Key, Graph> graphs = cache.getAll(keys);
//
//    /** 手动异步加载 */
//    AsyncCache<Key, Graph> cache = Caffeine.newBuilder()
//            .expireAfterWrite(10, TimeUnit.MINUTES)
//            .maximumSize(10_000)
//            .buildAsync();
//
//    CompletableFuture<Graph> graph = cache.getIfPresent(key);
//    graph = cache.get(key, k -> createExpensiveGraph(key));
//cache.put(key, graph);
//cache.synchronous().invalidate(key);
//
//    /** 自动异步加载 */
//    AsyncLoadingCache<Key, Graph> cache = Caffeine.newBuilder()
//            .maximumSize(10_000)
//            .expireAfterWrite(10, TimeUnit.MINUTES)
//            // 可以选择: 去异步的封装一段同步操作来生成缓存元素
//            .buildAsync(key -> createExpensiveGraph(key));
//    // 也可以选择: 构建一个异步缓存元素操作并返回一个future
//    .buildAsync((key, executor) -> createExpensiveGraphAsync(key, executor));
//
//    // 查找缓存元素，如果其不存在，将会异步进行生成
//    CompletableFuture<Graph> graph = cache.get(key);
//    // 批量查找缓存元素，如果其不存在，将会异步进行生成
//    CompletableFuture<Map<Key, Graph>> graphs = cache.getAll(keys);


}
