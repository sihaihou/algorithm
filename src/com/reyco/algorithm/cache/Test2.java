package com.reyco.algorithm.cache;

/**
 * LFU:淘汰使用次数最少的key，如果最少使用次数的key很多，先淘汰时间节点早的key
 * 要求get/add时间复杂度O(1)
 * 答：map+二维双向链表：Map<Key,LinkedNode>
 * 	1)Map<Key,LinkedNode>
 *  2)桶：一个桶里的所有key的词频一样，桶里面的节点是双向链表；
 *  3)桶与桶双向链表，每个桶的词频不一致。
 *  
 *  
 * @author reyco
 *
 */
public class Test2 {

}
