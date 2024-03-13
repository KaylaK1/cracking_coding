package com.crackingcoding;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test; // need this for DisplayName to work.
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import com.crackingcoding.linked_lists.LinkedListNode;
import com.crackingcoding.linked_lists.LoopDetection;

public class LinkedListTests {

    @Mock
    LoopDetection loopDetection = new LoopDetection();;

    LinkedListNode head = new LinkedListNode();

    // @BeforeEach
    // public void setup() {
    // loopDetection = new LoopDetection();
    // head = new LinkedListNode();
    // }

    @Test
    @DisplayName("The loop was detected")
    public void FindBeginning() {
        // Create a Linked List with a loop
        // Test 1 input: A -> B -> C -> D -> E -> C
        // Output: C
        List<Character> charList = Arrays.asList('A', 'B', 'C', 'D', 'E');
        LinkedListNode head = null;
        LinkedListNode current = null;
        LinkedListNode loopStart = null;

        for (char ch : charList) {
            if (head == null) {
                head = new LinkedListNode(ch);
                current = head;
            } else {
                current.next = new LinkedListNode(ch);
                if (ch == 'C') {
                    loopStart = current.next;
                }
                current = current.next;
            }
        }
        current.next = loopStart;

        Assertions.assertEquals(loopStart, loopDetection.FindBeginning(head));
    }
}
