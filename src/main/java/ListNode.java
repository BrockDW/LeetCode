import Solution.AddTwoNumbers;

import java.util.Objects;

public class ListNode {
    public int val;
    public AddTwoNumbers.ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, AddTwoNumbers.ListNode next) { this.val = val; this.next = next; }

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
        if (!(o instanceof AddTwoNumbers.ListNode)) return false;

        AddTwoNumbers.ListNode listNode = (AddTwoNumbers.ListNode) o;
        if (val == listNode.val){
            if (listNode.next == null && next == null){
                return true;
            } else {
                return next.equals(listNode.next);
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}