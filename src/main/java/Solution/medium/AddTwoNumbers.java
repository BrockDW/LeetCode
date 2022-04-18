package Solution.medium;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode start = result;
        boolean incrementHa = false;
        while (l1 != null || l2 != null){
            int newVal = 0;
            if (l1 == null){
                newVal = l2.val;
                l2 = l2.next;
            } else if (l2 == null){
                newVal = l1.val;
                l1 = l1.next;
            } else {
                newVal = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
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

        }
        if (incrementHa){
            start.next = new ListNode(1);
        }
        return result.next;
    }

    //https://leetcode.com/problems/add-two-numbers/discuss/1789385/Simple-Java-Solution
    public ListNode addTwoNumbersKaustavGurey(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode newHead = new ListNode(0);
        ListNode ans = newHead;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1!=null || temp2!=null) {
            if(temp1!=null && temp2!=null) {
                sum += (temp1.val+temp2.val);
                newHead.next = new ListNode(sum%10);
                sum/=10;
                newHead = newHead.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if(temp1!=null) {
                sum += temp1.val;
                newHead.next = new ListNode(sum%10);
                sum /= 10;
                newHead = newHead.next;
                temp1 = temp1.next;
            }
            else if(temp2!=null) {
                sum += temp2.val;
                newHead.next = new ListNode(sum%10);
                sum /= 10;
                newHead = newHead.next;
                temp2 = temp2.next;
            }
        }
        while(sum!=0) {
            newHead.next = new ListNode(sum%10);
            sum /= 10;
        }
        return ans.next;
    }

    // https://redquark.org/leetcode/0002-add-two-numbers/
    public ListNode addTwoNumbersAnirudh(ListNode l1, ListNode l2) {
        // Head of the new linked list - this is the head of the resultant list
        ListNode head = null;
        // Reference of head which is null at this point
        ListNode temp = null;
        // Carry
        int carry = 0;
        // Loop for the two lists
        while (l1 != null || l2 != null) {
            // At the start of each iteration, we should add carry from the last iteration
            int sum = carry;
            // Since the lengths of the lists may be unequal, we are checking if the
            // current node is null for one of the lists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // At this point, we will add the total sum % 10 to the new node
            // in the resultant list
            ListNode node = new ListNode(sum % 10);
            // Carry to be added in the next iteration
            carry = sum / 10;
            // If this is the first node or head
            if (temp == null) {
                temp = head = node;
            }
            // For any other node
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        // After the last iteration, we will check if there is carry left
        // If it's left then we will create a new node and add it
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1Two = new ListNode(
                9,
                new ListNode(
                        9,
                        new ListNode(
                                9,
                                new ListNode(
                                        9,
                                        new ListNode(
                                                9,
                                                new ListNode(
                                                        9,
                                                        new ListNode(9, null)))))));

        ListNode l2Two = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode resultTwo = new ListNode();

        System.out.println(atn.addTwoNumbers(l1Two, l2Two));
    }
}
