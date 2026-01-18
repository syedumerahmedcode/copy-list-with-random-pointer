
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    /**
     * Key: Copy of values of the old node
     * Value: newly generated copy that is created.
     */
    HashMap<ListNode, ListNode> visistedNode = new HashMap<ListNode, ListNode>();

    public ListNode copyRandomList(ListNode head) {
        /**
         * We treat the given linked list as a graph structure and apply Depth first
         * Search on it.
         */
        if (head == null) {
            return null;
        }

        /**
         * Check if the current head value has already been visited
         */
        if (this.visistedNode.containsKey(head)) {
            /**
             * If yes, we are going to return the subsequent refernce value that we have
             * stored in our visited node hashmap
             */
            return this.visistedNode.get(head);
        }
        ListNode node = new ListNode(head.val, null, null);
        /**
         * Put the entry in the visited hashmap
         */
        this.visistedNode.put(head, node);
        /**
         * Assigning next and random pointers by recursively calling function
         */
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;

    }

}
