// 138. Copy List with Random Pointer

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node temp = head;
        Node dummy = newHead;
        map.put(head, newHead);

        while (temp != null) {

            // CHECKING FOR NEXT
            if (temp.next != null) {
                if (!map.containsKey(temp.next)) {
                    Node newNode = new Node(temp.next.val);
                    map.put(temp.next, newNode);
                    dummy.next = newNode;
                } else if (map.containsKey(temp.next)) {
                    dummy.next = map.get(temp.next);
                }
            }

            if(temp.random!=null){
                if(!map.containsKey(temp.random)){
                    Node newNode =new Node(temp.random.val);
                    map.put(temp.random,newNode);
                    dummy.random=newNode;
                }
                else if(map.containsKey(temp.random)){
                    dummy.random=map.get(temp.random);
                }

            }

            temp=temp.next;
            dummy=dummy.next;

        }

        return newHead;

    }
}

// 725. Split Linked List in Parts
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        int len=0;
        ListNode temp=head;

        while(temp!=null){
            temp=temp.next;
            len++;
        }

        int size=len/k;
        int add =len%k;

        ListNode result[]=new ListNode[k];
        temp=head;

        for(int i=0;i<k;i++){
            ListNode newHead=temp;
            result[i]=newHead;

            int currentPartSize=size+(add>0?1:0);
            if(add>0)add--;

            for(int j=0;j<currentPartSize-1 && temp!=null;j++){
                temp=temp.next;
            }
            
            if(temp!=null){
                ListNode next=temp.next;
                temp.next=null;
                temp=next;
            }

        }

        return result;
        
    }
}


// 92. Reverse Linked List II
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}

// 206. Reverse Linked List
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
}

// 1669. Merge In Between Linked Lists
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode last=list2;
        while(last.next!=null){
            last=last.next;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=list1;

        ListNode curr=list1;
        ListNode prev=dummy;

        int idx=0;
        while(idx<a){
            prev=curr;
            curr=curr.next;
            idx++;
        }

        prev.next=list2;

        while(idx<b){
            curr=curr.next;
            idx++;
        }

        last.next=curr.next;
        curr.next=null;

        return dummy.next;
    }
}








// ---------------------------------------------------------------------------------------------------
