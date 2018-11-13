package silence.leetcode._2_两数相加;

/**
 * @author zhouqi
 * @date 2018/11/13
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            if (l1.val > 9) {
                l1.val = l1.val % 10;
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                l1.next.val += 1;
                l1.next = addTwoNumbers(l1.next, null);
            }
            return l1;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else {
            int num = l1.val + l2.val;
            ListNode newNode = new ListNode(num % 10);
            if (num > 9) {
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                l1.next.val += 1;
            }
            newNode.next = addTwoNumbers(l1.next, l2.next);
            return newNode;
        }
    }
}