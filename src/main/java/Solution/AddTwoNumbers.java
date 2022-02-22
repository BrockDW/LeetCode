package Solution;

import java.util.List;
import java.util.Objects;

public class AddTwoNumbers {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode)) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && next.equals(listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode start = result;
        boolean incrementHa = false;
        while (l1 != null && l2 != null){
            int newVal = l1.val + l2.val;
            if (incrementHa){
                newVal++;
                incrementHa = false;
            }
            if (newVal >= 10){
                newVal-=10;
                incrementHa = true;
            }
            ListNode next = new ListNode(newVal);
            start.next = next;
            start = next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1!=null){
            if (incrementHa){
                start.val++;
                incrementHa = false;
            }
        }

        if (incrementHa){
            start.next = new ListNode(1);
        }
        return result.next;

    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, null));
        ListNode result = new ListNode(7, new ListNode(0, new ListNode(8, null)));

        System.out.println(atn.addTwoNumbers(l1, l2));

//        ListNode l1Two = new ListNode(2, new ListNode(4, new ListNode(3, null)));
//        ListNode l2Two = new ListNode(5, new ListNode(6, new ListNode(4, null)));
//        ListNode resultTwo = new ListNode(7, new ListNode(0, new ListNode(8, null)));
//
//        System.out.println(atn.addTwoNumbers(l1, l2));
    }
}
