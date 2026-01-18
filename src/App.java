import java.util.HashMap;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        /**
         * A linked list of length n is given such that each node contains an additional
         * random pointer, which could point to any node in the list, or null.
         * 
         * Construct a deep copy of the list. The deep copy should consist of exactly n
         * brand new nodes, where each new node has its value set to the value of its
         * corresponding original node. Both the next and random pointer of the new
         * nodes should point to new nodes in the copied list such that the pointers in
         * the original list and copied list represent the same list state. None of the
         * pointers in the new list should point to nodes in the original list.
         * 
         * For example, if there are two nodes X and Y in the original list, where
         * X.random --> Y, then for the corresponding two nodes x and y in the copied
         * list, x.random --> y.
         * 
         * Return the head of the copied linked list.
         * 
         * The linked list is represented in the input/output as a list of n nodes. Each
         * node is represented as a pair of [val, random_index] where:
         * 
         * val: an integer representing Node.val
         * random_index: the index of the node (range from 0 to n-1) that the random
         * pointer points to, or null if it does not point to any node.
         * 
         * Your code will only be given the head of the original linked list.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
         * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
         * 
         * Example 2:
         * 
         * Input: head = [[1,1],[2,1]]
         * Output: [[1,1],[2,1]]
         * 
         * Example 3:
         * 
         * Input: head = [[3,null],[3,0],[3,null]]
         * Output: [[3,null],[3,0],[3,null]]
         * 
         */
        System.out.println("Hello, World!");

        /*
         * ListNode list = new ListNode(1);
         * ListNode node2 = new ListNode(2);
         * ListNode node3 = new ListNode(3);
         * ListNode node4 = new ListNode(4);
         * ListNode node5 = new ListNode(5);
         * list.next = node2; // 1 -> 2
         * node2.next = node3; // 2 -> 3
         * node3.next = node4; // 3 -> 4
         * node4.next = node5; // 4 -> 5
         * System.out.println("The given list is:");
         * printList(list);
         */

        Solution solution = new Solution();

        // Test Case 1: Simple case with one node and no random pointer.
        ListNode node1 = new ListNode(1, null, null);
        executeTest(solution, node1, "Test Case 1");

        // Test Case 2: Two nodes with next pointer only.
        ListNode node2 = new ListNode(1, new ListNode(2, null, null), null);
        executeTest(solution, node2, "Test Case 2");

        // Test Case 3: Two nodes where random points back to the first node.
        ListNode node3 = new ListNode(1, new ListNode(2, null, null), null);
        node3.random = node3; // Random points to itself
        executeTest(solution, node3, "Test Case 3");

        // Test Case 4: Multiple nodes with complex random pointers.
        ListNode node4 = new ListNode(1, null, null);
        ListNode node5 = new ListNode(2, null, null);
        ListNode node6 = new ListNode(3, null, null);
        node4.next = node5;
        node5.next = node6;
        node4.random = node6; // Random from 1 to 3
        node5.random = node4; // Random from 2 to 1
        node6.random = null; // Random from 3 to null
        executeTest(solution, node4, "Test Case 4");

        // Test Case 5: No nodes, should return null.
        executeTest(solution, null, "Test Case 5");

    }

    public static void printReverse(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // Pop elements to display in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static void executeTest(Solution solution, ListNode head, String testName) {
        ListNode copiedList = solution.copyRandomList(head);
        printList(head, copiedList, testName);
    }

    private static void printList(ListNode original, ListNode copied, String testName) {
        System.out.println(testName + ":");
        System.out.println("Original List:");
        printNodes(original);
        System.out.println("Copied List:");
        printNodes(copied);
        System.out.println();
    }

    private static void printNodes(ListNode node) {
        HashMap<ListNode, Integer> addresses = new HashMap<>();
        int count = 0;

        while (node != null) {
            System.out.print("Node value: " + node.val);
            addresses.put(node, count++);
            if (node.random != null) {
                System.out.print(", Random points to: " + node.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            node = node.next;
        }
    }
}
