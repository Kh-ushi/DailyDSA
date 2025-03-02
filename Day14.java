// 23. Merge k Sorted Lists

class Solution {

    public ListNode mergeSorted(ListNode left, ListNode right) {

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.val < right.val) {
            left.next = mergeSorted(left.next, right);
            return left;
        } else {
            right.next = mergeSorted(left, right.next);
            return right;
        }
    }

    public ListNode mergeSolve(ListNode lists[], int si, int ei) {

        if (si > ei) {
            return null;
        }

        if (si == ei) {
            return lists[si];
        }

        int mid = si + (ei - si) / 2;

        ListNode left = mergeSolve(lists, si, mid);
        ListNode right = mergeSolve(lists, mid + 1, ei);

        return mergeSorted(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSolve(lists, 0, lists.length - 1);
    }
}



// 1171. Remove Zero Sum Consecutive Nodes from Linked List
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {

        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        int sum = 0;

        while (temp != null) {
            sum += temp.val;

            if (map.containsKey(sum)) {
                ListNode prev = map.get(sum);
                ListNode toRemove = prev.next;

                int tempSum = sum;
                while (toRemove != temp) {
                    tempSum += toRemove.val;
                    map.remove(tempSum);
                    toRemove = toRemove.next;
                }

                prev.next = temp.next;
            } else {
                map.put(sum, temp);
            }

            temp = temp.next;
        }

        return dummy.next;
    }
}

//1721. Swapping Nodes in a Linked List

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        

        ListNode temp=head;

        ListNode p1=head;
        
        for(int i=1;i<k;i++){
            temp=temp.next;
            p1=p1.next;
        }

        temp=temp.next;

        ListNode p2=head;
        while(temp!=null){
            temp=temp.next;
            p2=p2.next;
        }

       if(p1!=p2){
         p1.val=p1.val+p2.val;
        p2.val=p1.val-p2.val;
        p1.val=p1.val-p2.val;
       }

        return head;
    }
}



// 24. Swap Nodes in Pairs
class Solution {
    public ListNode swap(ListNode p1,ListNode p2){
       
       if(p1==null){
        return p2;
       }

       if(p2==null){
        return p1;
       }

       p1.next=p2.next;
       p2.next=p1;

       if(p1.next!=null && p1.next.next!=null){
        p1.next=swap(p1.next,p1.next.next);
       }

       return p2;

    }
    public ListNode swapPairs(ListNode head) {

         if(head==null){
            return head;
         }
         
         return swap(head,head.next);
    }
}

// 2130. Maximum Twin Sum of a Linked List
class Solution {
    public int pairSum(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode prev=null;
        ListNode curr=slow;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode left=head;
        ListNode right=prev;

        int maxSum=Integer.MIN_VALUE;

        while(left!=right && right!=null){
            maxSum=Math.max(left.val+right.val,maxSum);

            left=left.next;
            right=right.next;
        }

        return maxSum;
    }
}