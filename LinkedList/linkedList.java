public class linkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    // add node at first
    public void addFirst(int data){
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        //when empty LL
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        //step2 - newNode next = head
        newNode.next = head;
        //step3 - head = newNode
        head = newNode;
    }


    //add node at last
    public void addLast(int data){
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        //when empty LL
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        //step2 - tail next = newNode
        tail.next = newNode;
        //step3 - tail = newNode
        tail = newNode;
    }


    //print Linked List
    public void print(){
        if(head == null){
            System.out.println("LinkedList is Empty!!");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    //add node
    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
    }


    //remove first node
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }


    //remove last node
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size - 2
        Node prev = head;
        for(int i=0; i< size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size --;
        return val;
    }


    //search for a value
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key)
    {
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }


    //reverse LL
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    //delete node
    public void deleteNthfromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;    // remove first
            return;
        }

        //sz-n
        int i =1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

        //Slow-fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow .next; // +1
            fast  = fast.next.next; //+2
        
        }
        return slow;
    }

    //check LL palindrome or not
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        //step 1 - find mid
        Node midNode = findMid(head);

        //step 2 - reverse 2nd half
        Node prev = null;
        Node curr  = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next  = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //right half head
        Node left = head;

        //step 3 - check 1st half & 2nd half for palindrome
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    
    //Floyd's Cycle Finding Algorithm(CFA) --> for detecting cycle
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next; //+2
            if(slow == fast){
                return true; // cycle exists
            }
        }
        return false;
    }


    //remove cycle
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;// last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;

        }

        //remove cycle --> last.next = null
        prev.next = null; 
    }



    // Function to find middle of the linked list
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid node
    }

    // Function to merge two sorted linked lists
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    // Merge Sort for Linked List
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left & right MS
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        linkedList ll = new linkedList();
        
        /*ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);*/

        //ll.add(2, 3);

        //System.out.println(linkedList.size);

        //ll.removeFirst();
        //ll.removeLast();
        // ll.print();
        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.itrSearch(10));

        // ll.deleteNthfromEnd(3);
        //ll.print();

       /*  head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = temp;
        
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());*/

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        // ll.addFirst(5);
        
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();

    }
}