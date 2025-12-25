public class LinkedListCycle2 {
    static class ListNode{
        ListNode next;
        int val;
        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public static ListNode startIndex(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(fastPtr == slowPtr){
                while(head != slowPtr){
                    head = head.next;
                    slowPtr = slowPtr.next;
                }
                return slowPtr;
            }
        }
        return null;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode common = new ListNode(3);
        head.next.next = common;
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);
        common.next.next.next = new ListNode(6);
        common.next.next.next.next = common;

        System.out.println(startIndex(head).val);

    }
        
}

