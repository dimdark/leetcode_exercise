package leetCode_432;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @author dimdark
 * @date 2017-08-31
 * @time 9:59 AM
 */
public class AllOne {

     class DLinkedList<T> {
         HashSet<String> strings;
         DLinkedList<T> prev;
         DLinkedList<T> next;
         public DLinkedList() {
             strings = new HashSet<String>();
         }
         /**
          * 在list后面插入节点node并返回node
          */
         public DLinkedList<T> insertAfter(DLinkedList<T> list, DLinkedList<T> node) {
             if (list == null) throw new IllegalArgumentException("list can not be null!");
             if (node == null) return null; //当插入的节点为null时, 返回null
             node.prev = list;
             node.next = list.next;
             list.next = node;
             if (node.next != null) node.next.prev = node;
             return node;
         }
         /**
          *  删除链表中的节点node
          */
         public void delete(DLinkedList<T> node) {
             if (node == null) return; // 节点node为null则不做处理
             node.prev.next = node.next;
             node.next.prev = node.prev;
             node.prev = node.next = null;
         }
     }

    HashMap<String, Integer> map; // 将字符串和对应的值快速关联起来
    DLinkedList<Integer> head, tail; // 设置头尾指针
    HashMap<Integer, DLinkedList<Integer>> nodeMap; // 将值和所有与其相关的字符串快速关联起来

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<String, Integer>();
        head = new DLinkedList<Integer>();
        tail = new DLinkedList<Integer>();
        head.insertAfter(head, tail); //
        nodeMap = new HashMap<Integer, DLinkedList<Integer>>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Integer oldValue = map.get(key);
        if (oldValue == null) {
            map.put(key, 1);
            if(!nodeMap.containsKey(1)) {
                DLinkedList<Integer> node = new DLinkedList<Integer>();
                nodeMap.put(1, node);
                head.insertAfter(head, node);
            }
            nodeMap.get(1).strings.add(key);
        } else {
            Integer newValue = oldValue + 1;
            map.put(key, newValue);
            DLinkedList<Integer> oldNode = nodeMap.get(oldValue); // 绝对是存在的
            DLinkedList<Integer> newNode = nodeMap.get(newValue); // 不一定存在
            if (newNode == null) {
                newNode = new DLinkedList<Integer>();
                nodeMap.put(newValue, newNode);
                head.insertAfter(oldNode, newNode);
            }
            newNode.strings.add(key);
            oldNode.strings.remove(key);
            if (oldNode.strings.isEmpty()) {
                nodeMap.remove(oldValue);
                head.delete(oldNode);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Integer oldValue = map.get(key);
        if (oldValue == null) return;
        if (oldValue == 1) map.remove(key);
        else map.put(key, oldValue-1);
        DLinkedList<Integer> oldNode = nodeMap.get(oldValue);
        oldNode.strings.remove(key);
        if (oldValue > 1) {
            Integer newValue = oldValue - 1;
            DLinkedList<Integer> newNode = nodeMap.get(newValue);
            if (newNode == null) {
                newNode = new DLinkedList<Integer>();
                nodeMap.put(newValue, newNode);
                head.insertAfter(oldNode.prev, newNode);
            }
            newNode.strings.add(key);
        }
        if(oldNode.strings.isEmpty()) {
            nodeMap.remove(oldValue);
            head.delete(oldNode);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return map.isEmpty() ? "" : tail.prev.strings.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return map.isEmpty() ? "" : head.next.strings.iterator().next();
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
