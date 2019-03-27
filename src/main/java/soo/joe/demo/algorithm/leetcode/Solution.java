package soo.joe.demo.algorithm.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author: suzhou
 * @createtime: 2019-03-27  08:52
 * @description: Solution
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<2){
            return null;
        }
        Arrays.sort(nums);
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            result[0]=nums[i];
            int other=target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(other==nums[j]){
                    result[1]=nums[j];
                    return result;
                }
            }
        }
        return null;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1=toNum(l1);
        BigInteger num2=toNum(l2);
        return toNListNode(num1.add(num2));
    }

    private static ListNode toNListNode(BigInteger i) {
        String s=i.toString();
        ListNode l=new ListNode(Integer.parseInt(s.charAt(s.length()-1)+""));
        ListNode t=l;
        for (int j=s.length()-2;j>=0;j--){
            t.next=new ListNode(Integer.parseInt(s.charAt(j)+""));
            t=t.next;
        }
        return l;
    }

    private static BigInteger toNum(ListNode l) {
        BigInteger result=new BigInteger("0");
        while (l!=null){
            result=result.multiply(BigInteger.TEN).add(BigInteger.valueOf(l.val));
            l=l.next;
        }
        return result;
    }



    public static void main(String[] args) {
        ListNode q=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode s=new ListNode(4);
        ListNode g=new ListNode(3);
        q.next=b;
        b.next=s;
        s.next=g;
        addTwoNumbers(q,b);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}