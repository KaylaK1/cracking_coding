package com.crackingcoding.linked_lists;

/* Loop Detection
 * Given a linked list which may contain a loop, implement an algorithm
 * that returns the node at the beginning of the loop (if a loop exists).
 * 
 * Ex: A -> B -> C -> D -> E -> C (Same c as earlier)
 * Output: C
 */
public class LoopDetection {
    public LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        /* Find the meeting point. Which is LOOP_SIZE - k steps into LL */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Collision
                break;
            }
        }

        /* If the fast pointer is null, then there is no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /*
         * Move slow to Head. Keep fast at Collision. Each are k steps from
         * Loop Start. If you move both pointers at same pace, they will meet
         * at Loop Start
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* Both point to start of the loop */
        return fast;
    }
}
