package com.crackingcoding;

import java.util.Arrays;
import java.util.List;

import com.crackingcoding.linked_lists.LinkedListNode;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Testing World!");

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

        System.out.println("All done!");
    }
}
