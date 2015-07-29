package mergesort;


public class MyList<AnyType> {
	private Node<AnyType> myHead;
	private int ListSize;
	
	public MyList() {
		myHead = null;
		ListSize = 0;
	}
	
	public void add(AnyType num) {
		if (myHead == null) {
			myHead = new Node<AnyType>(num);
		} else {
			Node<AnyType> temp = myHead;
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
		   
		   if(myHead == null) {
			  add(item); 
		   } else {
			   Node<AnyType> temp = myHead;
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
	   	
	   	Node<AnyType> temp = myHead;
	   	while (temp != null && !temp.getValue().equals(key)) {
	   		temp = temp.getNext();
	   	   }
	   	if (temp != null) {
	   		temp.setNext(new Node<AnyType>(toInsert, temp.getNext()));
	   	}
	   	ListSize++;
	   	
	         
	   } // end of insertAfter
	
	public int count(int key) {
		Node<AnyType> temp = myHead;
		int count = 0;
	
		while(temp != null) {
			if ((int) temp.getValue() == key) {
				count++;
			}
			temp = temp.getNext();
		}
		return count;
	}
	
	public boolean deleteFirst(int key) {
		if (myHead == null) {
			return false;
		} else {
			if ((int)myHead.getValue() == key) {
				myHead = myHead.getNext();
				ListSize--;
				return true;
			} else {
				Node<AnyType> temp = myHead;
				while (temp.getNext() != null && 
						(int) temp.getNext().getValue() != key) {
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
		myHead = null;
		
	}
	
	public int getSize() {
		return ListSize;
	}
	
	public int findMth(int m) {
		Node<AnyType> temp = myHead;
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
		return (int) temp.getValue();
	}
	
	public void mergeSort() {
		
	}
	
	public void printList() {
		Node<AnyType> temp = myHead;
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
}
