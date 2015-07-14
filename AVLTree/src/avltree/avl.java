package avltree;

import java.util.NoSuchElementException;


public class avl{
	
    Node root;

    private class Node{
    	
        String keyword;
        Record record;
        Node left;
        Node right;
        int size;
        int height;
        
        private Node(String k) {
        	keyword = k;
        }

        private void update(Record theRecord) {
        	if (theRecord == null) {
        		throw new NullPointerException("Record is not valid.");
        	}
        	
        	Record temp = record;
        	record = theRecord;
        	record.next = temp;
        	size++;
        }
    }

	public void insert(String keyword, FileData fd) {
		
		if (keyword == null || keyword == "") {
        	throw new NullPointerException("Keyword is null.");
        } else if (fd == null) {
        	throw new NullPointerException("Data is null.");
        }
		
        Record recordToAdd = new Record(fd.id, fd.title, fd.author, null);
        root = insert(root, keyword, recordToAdd);
    }

	private Node insert(Node node, String keyword, Record theRecord) {
		
		if (keyword == null || keyword == "") {
        	throw new NullPointerException("Keyword is null.");
        } else if (theRecord == null) {
        	throw new NullPointerException("Data is null.");
        }
		
		if (node == null) {
			node = new Node(keyword);
			node.record = theRecord;
			node.size++;
		}
		keyword = keyword.toLowerCase();
		int result = keyword.compareTo(node.keyword);
		
		if (result == 0) {
			node.update(theRecord);
		} else if (result < 0) {
			node.left = insert(node.left, keyword, theRecord);
		} else {
			node.right = insert(node.right, keyword, theRecord);
		}
		return balance(node);
	}

	private Node balance(Node node) {
		if (node == null) {
			return node;
		}
		if (height(node.left) - height(node.right) > 1) {
			if (height(node.left.left) >= height(node.left.right)) {
				node = leftChildLeft(node);
			} else {
				node = rightChildLeft(node);
			}
		} else if (height(node.right) - height(node.left) > 1) {
			if (height(node.right.right) >= height(node.right.left)) {
				node = rightChildRight(node);
			} else {
				node = leftChildRight(node);
			}
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private int height(Node node) {
		if (node != null) {
			return node.height;
		}
		return -1;		
	}

	private Node leftChildLeft(Node node) {
		Node rootLeft = node.left;
		node.left = rootLeft.right;
		rootLeft.right = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		rootLeft.height = Math.max(height(rootLeft.left), node.height) + 1;
		return rootLeft;
	}
	 
	private Node leftChildRight(Node node) {
		node.right = leftChildLeft(node.right);
		return rightChildRight(node);
	}
	
	private Node rightChildRight(Node node) {
		Node rootRight = node.right;
		node.right = rootRight.left;
		rootRight.left = node;
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		rootRight.height = Math.max(height(rootRight.right), node.height) + 1;
		return rootRight;
	}
	
	private Node rightChildLeft(Node node) {
		node.left = rightChildRight(node.left);
		return leftChildLeft(node);
	}
	
	public boolean contains(String keyword){
    	if (keyword == null || keyword == "") {
    		throw new NullPointerException("Empty string exception.");
    	}
    	keyword = keyword.toLowerCase();
    	return contains(root, keyword);
    }
    
    private boolean contains(Node node, String keyword) {
    	if (node == null) {
    		throw new NullPointerException("Null node.");
    	} else if (keyword == null || keyword == "") {
    		throw new NullPointerException("Empty string exception.");
    	}
    	
    	keyword = keyword.toLowerCase();
    	int result = keyword.compareTo(node.keyword);

    	if (result > 0) {
    		return contains(node.right, keyword);
    	} else if (result < 0) {
    		return contains(node.left, keyword);
    	}
    	return true;
    }
	
	public Record get_records(String keyword){
    	if (keyword == null || keyword == "") {
    		throw new NullPointerException("keyword was null in get_records request.");
    	}
    	if (!contains(keyword)) {
    		return null;
    	}
    
    	return get_records(root, keyword);
    }
    
    public Record get_records(Node node, String keyword) {
    	if (node == null) {
    		throw new NullPointerException("Null node");
    	}
    	if (keyword == null || keyword == "") {
    		throw new NullPointerException("Null keyword");
    	}
    	
    	int result = keyword.compareTo(node.keyword);
    	
    	if (result == 0) {
    		return node.record;
    	} else if (result > 0) {
    		return get_records(node.right, keyword);
    	} else if (result < 0) {
    		return get_records(node.left, keyword);
    	}
    	return null;
    }
    
    public void delete(String keyword){
    	keyword = keyword.toLowerCase();
    	if (keyword == null || keyword == "") {
        	throw new IllegalArgumentException("Keyword is null.");
        }
    	
    	if (!contains(keyword)) {
    		throw new IllegalArgumentException("Tree does not contain that keyword(s)");
    	}
    	delete(root, keyword);
    }

    
    private Node delete(Node node, String keyword) {
    	if (keyword == null || keyword == "") {
    		throw new NullPointerException("Empty string exception.");
    	} else if (node == null) {
    		throw new NullPointerException("Null node.");
    	}
    	
    	int result = keyword.compareTo(node.keyword);

    	if (result > 0) {
    		return delete(node.right, keyword);
    	} else if (result < 0) {
    		return delete(node.left, keyword);
        } else {
        	if (node.left == null && node.right == null) {
                 node = null;
            } else if (node.left == null) {
                  node = node.right;
            } else if (node.right == null) {
                  node = node.left;
            } else {
            	String min = getMin(node.right);
                node.right = delete(node.right, min);
                node.keyword = min; 
            }
        }
    	return node;
	
    }
    
    public String getMin() {
    	if (root == null) {
            throw new NoSuchElementException();
        } else {
            return getMin(root);
        }
    }
    
    private String getMin(Node node) {
        if (node.left == null) {
            // no left child, so this must be the leftmost (min) node
            return node.keyword;
        } else {
            // I have a left child, so he must be smaller than me; go to the left
            return getMin(node.left);
        }
    }
    	

    public void print(){
        print(root);
    }

    private void print(Node t){
        if (t!=null){
            print(t.left);
            System.out.println(t.keyword);
            Record r = t.record;
            while(r != null){
                System.out.printf("\t%s\n",r.title);
                r = r.next;
            }
            print(t.right);
        } 
    }
    
    
	
}