import org.junit.Test;

import java.lang.ref.SoftReference;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * @Author DiaoJianBin
 * @Date 2021/12/6 11:05
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class JustTest {
    @Test
    public void test() {
        char[][] nums = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        int[] nums2 = {2,4,0,0,8,1};
        int[] nums3 = {25};
        int[][] nums4 = {{1,3},{2,3}};
        int[][] nums5 = {{1,2},{5,1},{1,3},{1,4}};
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);

        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;

        List<Integer> wordDict = new ArrayList<>();
        wordDict.add(8);
        wordDict.add(2);
        wordDict.add(1000);
        wordDict.add(1000);
        wordDict.add(3);
        wordDict.add(7);

        System.out.println(canReorderDoubled(nums2));
        System.out.println();
    }

    public boolean canReorderDoubled(int[] arr) {
        //必须先排序，才能解决2,4,8,1这种情况
        Arrays.sort(arr);

        //还没有匹配成对的数量
        int aloneCount = 0;

        //记录数字的数量，只考虑数字之间能否两两匹配
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++){
            int a = arr[i];
            //先尝试匹配低值
            if(a%2 == 0){
                //只有是偶数才能匹配低值
                Integer halfNum = map.get(a / 2);
                if(halfNum!=null && halfNum > 0){
                   //说明低值是有数量的，那么减少一个
                   map.put(a/2,halfNum - 1);
                   aloneCount--;
                   continue;
                }
            }

            Integer doubleNum = map.get(a * 2);
            if(doubleNum!=null && doubleNum>0){
                //说明高值是有数量的，那么减少一个
                map.put(a*2,doubleNum-1);
                aloneCount--;
                continue;
            }

            //都没找到匹配的，那么将该数存入
            Integer num = map.get(a);
            if(num == null){
                num = 0;
            }
            ++num;
            map.put(a,num);

            aloneCount++;
        }

        if(aloneCount == 0){
            return true;
        }else{
            return false;
        }
    }
}


