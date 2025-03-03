// 237. Delete Node in a Linked List

class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode curr=node;
        ListNode prev=null;

        while(curr.next!=null){
            curr.val=curr.next.val;
            prev=curr;
            curr=curr.next;
        }

        prev.next=null;

    }
}

// 2095. Delete the Middle Node of a Linked List
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        int size=0;
        ListNode temp=head;

        while(temp!=null){
            temp=temp.next;
            size++;
        }

        if(size==1){
            return null;
        }

    
        int idx=size/2;
        temp=head;

        int i=0;
        while(i<idx-1){
           temp=temp.next;
           i++;
        }
      
       temp.next=temp.next.next;

       return head;

    
        
    }



}

// 876. Middle of the Linked List
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
        }
        
        return slow;
    }
}


// 328. Odd Even Linked List
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
         if (head == null || head.next == null) {
            return head; 
        }

        ListNode OddStart=head;
        ListNode EvenStart=head.next;

        ListNode odd=head;
        ListNode even=EvenStart;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }
        
        odd.next=EvenStart;
       
        return head;
        

    }
}


// 142. Linked List Cycle II
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        boolean isCycle=false;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                isCycle=true;
                break;
            }
        }

        if(!isCycle)return null;

        slow=head;

        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;


        
    }
}
// 382. Linked List Random Node

class Solution {

    int size;
    ListNode head;

    public Solution(ListNode head) {
        this.head=head;

        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }

    }
    
    public int getRandom() {
        
        int idx=(int)(Math.random()*(size));

        int i=0;
        ListNode temp=head;;

        while(i<idx){
         temp=temp.next;
         i++;
        }

        return temp.val;

    }
}


//109. Convert Sorted List to Binary Search Tree
Day14 
class Solution {
    public ListNode midNode(ListNode head){
    
      ListNode slow=head;
      ListNode prev=null;

      ListNode fast=head;

      while(fast!=null && fast.next!=null){
         prev=slow;
         slow=slow.next;
         fast=fast.next.next;
      }

      prev.next=null;

      return slow;

    }


    public TreeNode sortedListToBST(ListNode head) {

        if(head==null ){
            return null;
        }

        if(head.next==null){
            return new TreeNode(head.val);
        }

        ListNode mid=midNode(head);

        TreeNode root=new TreeNode(mid.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);

        return root;
         
    }
}