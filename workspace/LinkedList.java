// Taiyo Murphy
//Linked List Project

/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/

public class LinkedList{

  
  //instance varialbes go here (think about what you need to keep track of!)
  ListNode head;
  //constructors go here
  public LinkedList(){
    head = null;
  }

  public LinkedList(String line, ListNode next){
    head = new ListNode(line, next);
  }
  public LinkedList(ListNode a){
    head = a;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned

  public ListNode getHead(){
    return head;
  }

  public ListNode addAValue(String line) {
    // If the list is empty, set head to the new node
    if (head == null) {
        head = new ListNode(line, null);
        return head;
    }

    if (head.getValue().compareTo(line) > 0) {
        head = new ListNode(line, head);
        return head;
    }

    ListNode currNode = head;
    while (currNode.getNext() != null && currNode.getNext().getValue().compareTo(line) < 0) {
        currNode = currNode.getNext();
    }

    // Insert new node
    ListNode newNode = new ListNode(line, currNode.getNext());
    currNode.setNext(newNode);
    return newNode;
}

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    if (head == null) {
        return new ListNode(null,null);
    }
    ListNode currNode = head;

    if (currNode.getValue() != null && currNode.getValue().equals(line)) {
        ListNode temp = head;
        head = currNode.getNext();
        // After removal, head may be null, so next call will return null safely
        return temp;
    }
    // If head was removed above, next call will have head == null
    while (currNode != null && currNode.getNext() != null) {
        ListNode nextNode = currNode.getNext();
        if (nextNode.getValue() != null && nextNode.getValue().equals(line)) {
            ListNode toDelete = nextNode;
            currNode.setNext(toDelete.getNext());
            return toDelete;
        }
        currNode = nextNode;
    }
    return new ListNode(null,null);
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String fin = "";
    ListNode currNode = head;
    while (currNode != null && currNode.getValue() != null){
      fin = fin + currNode.getValue() + " ";
      currNode = currNode.getNext();
    }
    return fin;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
  }

  // precondition: the list has been initialized
  // postcondition: reverses the order of the nodes in the list. 
  public void reverse() {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.getNext();
        curr.setNext(prev);
        prev = curr;
        curr = next;
    }
    head = prev;
  }

  // precondition: n>0, the list has been initialized.
  // postcondition: each set of n nodes in the linkedList will be reversed
  public void nReverse(int n) {
    if (n <= 1 || head == null) return;

    // dummy -> head
    ListNode dummy = new ListNode(null, head);
    ListNode prevEnd = dummy;
    ListNode start = head;

    while (start != null) {
        ListNode groupEnd = start;
        int x = 1;
        while (x < n && groupEnd.getNext() != null) {
            groupEnd = groupEnd.getNext();
            x++;
        }

        ListNode nextGroupStart = groupEnd.getNext();

        ListNode prev = nextGroupStart;
        ListNode curr = start;
        while (curr != nextGroupStart) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        prevEnd.setNext(groupEnd);
        prevEnd = start;
        start = nextGroupStart;
    }

    head = dummy.getNext();
  }
}



  // // precondition: n>0, the list has been initialized.
  // // postcondition: each set of n nodes in the linkedList will be reversed
  // public void xnReverse(int n){
  //   ListNode prev = null;
  //   ListNode curr = head;
  //   while (curr != null) {
  //     int x = 0;
  //     ListNode first = curr; // set tentative values for first and last
  //     ListNode last = first;
  //     while (curr != null && x<n){
  //       if (x == 0){
  //         first = curr;
  //       } 
  //       if (x == n-1 || curr.getNext() == null){
  //         last = curr;
  //       }
  //       x+=1;
  //       curr = curr.getNext();
  //     }
      
  //     ListNode aft = last.getNext();
  //     last.setNext(null);
  //     LinkedList temp = new LinkedList(first);
  //     temp.reverse();

  //     // first.setNext(aft);
  //     ListNode mark = temp.getHead();


  //     // probably the problem
  //     while (mark.getNext() != null){
  //       mark = mark.getNext();
  //     }
  //     mark.setNext(aft);
      

  //     if (prev == null){
  //       head = temp.getHead();
  //       System.out.println("head is "+ head.getValue());
  //     } else {
  //       System.out.println("reassign "+ prev.getNext().getValue() + " to "+ temp.getHead().getValue());
  //       prev.setNext(temp.getHead());
        
  //     }
  //     prev = mark;
  //   }
  // }