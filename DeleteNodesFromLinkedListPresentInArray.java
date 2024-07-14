import java.util.Arrays;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



public class DeleteNodesFromLinkedListPresentInArray {
 public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> ns = new HashSet<>();
        for (int n : nums) {
            ns.add(n);
        }
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode c = a;
        while (c.next != null) {
            if (ns.contains(c.next.val)) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }

        return c.next;
    }

    public static void main(String[] args) {
        DeleteNodesFromLinkedListPresentInArray d = new DeleteNodesFromLinkedListPresentInArray();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        int[] nums = {2, 3};
        ListNode res = d.modifiedList(nums, head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
