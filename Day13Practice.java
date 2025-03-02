public class Day13Practice {

    public static class Node{
       
        int data;
        Node next;
         
        public Node(int data){
          this.data=data;
          this.next=null;
        }

    }

    public static Node head;
    public static Node tail;

    public static int size;

   
    public void AddFirst(int data){

        Node newNode=new Node(data);
        size++;
       
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;

    }

    public void AddLast(int data){
        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    public void AddMiddle(int data,int idx){
         
        if(idx==0){
            AddFirst(data);
            return;
        }

        if (idx == size) {
            AddLast(data);
            return;
        }

        Node newNode=new Node(data);
        size++;

        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        
        newNode.next=temp.next;
        temp.next=newNode;

    }


    public void printLL(){
        if(head==null){
            System.out.println("LL is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("Null");

    }

    public int removeFirst(){
       
        if(size==0){
            System.out.println("LL is Empty");
            return -1;
        }

        if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=head.data;
        head=head.next;
        size--;

        return val;

    }
    public int removeLast(){

        if(size==0){
            System.out.println("LL is Empty");
            return -1;
        }

        if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        Node temp=head;
        int i=0;

        while(i<size-2){
            temp=temp.next;
            i++;
        }
        int val=tail.data;
        temp.next=null;
        tail=temp;
        size--;
       
        return val;

    }

    public void reverseLL(){

        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        head=prev;
    }

    public static int recSearch(Node head,int key){

        if(head==null){
            return -1;
        }
       
        if(head.data==key){
            return 0;
        }

        int idx=recSearch(head.next, key);

        if(idx==-1){
            return -1;
        }

        return idx+1;

    }

  
    // CHECK IF LL IS A PALINDROME

    public static Node findMid(Node head){
         
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static boolean checkPalindrome(Node head){
      
        Node mid=findMid(head);

        Node left=head;

        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;


        while(right!=null){
            if(left.data!=right.data){
                return false;
            }

            left=left.next;
            right=right.next;
        }

        return true;
        
    }

    // FLOYDS CYCLE FINDING ALORTIHM

    public static Node removeLoop(Node head){
       
        //FINDING MEETING POINT

        Node slow=head;
        Node fast=head;

        boolean isCycle=false;

        while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;

           if(fast==slow){
             isCycle=true;
             break;
           }

        }

        if(!isCycle){
            return head;
        }

        slow=head;
        Node prev=null;

        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        prev.next=null;

        return head;

    }




    public static void main(String args[]){

        Day13Practice ll=new Day13Practice();
        ll.AddLast(1);
        ll.AddLast(2);
        ll.AddLast(3);
        ll.AddFirst(0);
        ll.AddFirst(-1);
        
        ll.printLL();
        System.out.println(recSearch(head,2));


        ll.reverseLL();
        ll.printLL();

        System.out.println(recSearch(head,2));

        
       
   
    }
    
}
