package ir.home.tutorial.algorithm.leetcode.cache.lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRU extends LinkedHashMap<Integer, Integer> implements LRUCache{

    private final int CAPACITY;


    public LinkedHashMapLRU(int capacity) {
        super((int) (capacity + 1 / 0.75f), 0.75f, true);
        this.CAPACITY = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > CAPACITY;
    }

    public static void main(String[] args) {
        final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        map.put(1, null);
        System.out.println("contains: " + map.containsKey(1));
    }
    @Override
    public int get(int key) {
        /*Integer result = super.get(key);
        if (result == null)
            result = -1;

        return result;*/
        super.get(key);
        super.containsKey(key);
        return getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        super.put(key, value);
    }
}
