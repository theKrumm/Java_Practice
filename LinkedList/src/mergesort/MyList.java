package mergesort;



public class MyList<AnyType> {
	private Node<AnyType> head;
	private int ListSize;
	
	public MyList() {
		head = null;
		ListSize = 0;
	}
	
	public void add(AnyType num) {
		if (head == null) {
			head = new Node<AnyType>(num);
		} else {
			Node<AnyType> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new Node<AnyType>(num));
		}
		ListSize++;
	}
	
	/***  Inserts a new node to the end of this list.* */
	   public void addLast(AnyType item) {
		   if (item == null) {
			   throw new NullPointerException("Item was null.");
		   }
		   
		   if(head == null) {
			  add(item); 
		   } else {
			   Node<AnyType> temp = head;
			   while (temp.getNext() != null) {
				   temp = temp.getNext();
			   }
			   temp.setNext(new Node<AnyType>(item));
		   }
		   ListSize++;

	   } // end of addLast
	   
	   /***  Find a node containing "key" and insert a new node after it.  **/
	   
	   
	   public void insertAfter(AnyType key, AnyType toInsert) {
		   if (key == null) {
			   throw new NullPointerException("key was null.");
		   }else if (toInsert == null) {
			   throw new NullPointerException("toInsert was null.");
		   }
	   	
	   	Node<AnyType> temp = head;
	   	while (temp != null && !temp.getValue().equals(key)) {
	   		temp = temp.getNext();
	   	   }
	   	if (temp != null) {
	   		temp.setNext(new Node<AnyType>(toInsert, temp.getNext()));
	   	}
	   	ListSize++;
	   	
	         
	   } // end of insertAfter
	
	public int count(int key) {
		Node<AnyType> temp = head;
		int count = 0;
	
		while(temp != null) {
			if ((Integer) temp.getValue() == key) {
				count++;
			}
			temp = temp.getNext();
		}
		return count;
	}
	
	public boolean deleteFirst(int key) {
		if (head == null) {
			return false;
		} else {
			if ((Integer)head.getValue() == key) {
				head = head.getNext();
				ListSize--;
				return true;
			} else {
				Node<AnyType> temp = head;
				while (temp.getNext() != null && 
						(Integer) temp.getNext().getValue() != key) {
					temp = temp.getNext();
				}
				
				if(temp.getNext() == null) {
					return false;
				} else {
					temp.setNext(temp.getNext().getNext());
					ListSize--;
					return true;
				}
			}
		}
	}
	
	public int deleteAll(int key) {
		int count = 0;
		while (this.deleteFirst(key)) {
			count++;
		}
		return count;
	}
	
	public void clearList() {
		head = null;
		
	}
	
	public int getSize() {
		return ListSize;
	}
	
	public int findMth(int m) {
		Node<AnyType> temp = head;
		int count = 0;
		int target = ListSize - m - 1;
		if (m < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (target < 0) {
			throw new IndexOutOfBoundsException();
		}
		while (count != target) {
			count++;
			temp = temp.getNext();
		}
		return (Integer) temp.getValue();
	}
	
	public void mergeSort() {
		
	}
	
	public void printList() {
		Node<AnyType> temp = head;
		if (temp != null) {
			while (temp != null) {
				System.out.print(temp.getValue());
				temp = temp.getNext();
				if (temp != null) {
					System.out.print(" -> ");
				}
				
			}
		}
		System.out.println();
	}
	
	public Node<AnyType> mergeTwoLists(MyList<AnyType> l1, MyList<AnyType> l2) {
		return head;
	}
	
}
