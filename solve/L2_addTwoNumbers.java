
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
// 进位是 sum / 10
    // 个位数字是 sum mod 10
    // reference type  =是copy地址
    //dummy是保证首个指针不变，curr改变后面的指针

public class L2_addTwoNumbers {
   static class ListNode{
       int val;
       ListNode next;

       public ListNode() {
       }
       public ListNode(int val) {
           this.val = val;
       }
       public ListNode(int val, ListNode next) {
           this.val = val;
           this.next = next;
       }
   }
   public static ListNode add2nums(ListNode a,ListNode b){
       ListNode dummy = new ListNode(0);
       ListNode curr = dummy;
       int carry = 0 ;

       while(a != null || b != null || carry != 0){
           int x = (a != null) ? a.val : 0;
           int y = (b != null) ? b.val : 0;

           int sum = x + y + carry;
           carry = sum / 10;

           curr.next = new ListNode(sum % 10);
           curr =curr.next;

           if(a != null ) a = a.next;
           if(b != null) b = b.next;
       }
       return dummy.next;
   }

   public static void printList(ListNode head){
       while(head != null){
           System.out.print(head.val);
           if(head.next != null) System.out.print("->");
           head = head.next;
       }

       System.out.println();
   }

   public static void main(String[] args){
       ListNode a = new ListNode(2,new ListNode(4,new ListNode(3)));
       ListNode b = new ListNode(5,new ListNode(6,new ListNode(4)));
       ListNode c = add2nums(a,b);
       printList(c);

   }

}
