import java.util.List;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // assume both l1 and l2 are non-empty
        ListNode head = null;
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        ListNode resultCurrent = null;
        int addToNextDigit = 0;
        while(true){
            if(l1Current != null || l2Current != null){
                int l1Val = l1Current == null ? 0 : l1Current.val;
                int l2Val = l2Current == null ? 0 : l2Current.val;
                ListNode ln = new ListNode((l1Val+l2Val+addToNextDigit)%10);
                addToNextDigit = (l1Val+l2Val+addToNextDigit)/10;
                if(head == null){
                    head = ln;
                    resultCurrent = head;
                }else{
                    resultCurrent.next = ln;
                    resultCurrent = resultCurrent.next;
                }
                l1Current = l1Current == null ? null : l1Current.next;
                l2Current = l2Current == null ? null : l2Current.next;
            }else{
                break;
            }
        }
        if(addToNextDigit > 0){
            resultCurrent.next = new ListNode(addToNextDigit);
        }
        return head;
    }

    public static void main(String[] argv){
        /**
         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         Output: 7 -> 0 -> 8
         */
        //ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(1, new ListNode(8));
        ListNode l2 = new ListNode(0);
        ListNode result = new AddTwoNumbers2().addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.val);
            if (result.next != null){
                System.out.print(" -> ");
            }
            result = result.next;
        }
    }
}
