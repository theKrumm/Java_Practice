package avltree;
//tree node f.
public class AVLNode {
	 public AVLNode left;
	 public AVLNode right;
	 public AVLNode parent;
	 public int key;
	 public int balance;

	 public AVLNode(int k) {
	  left = right = parent = null;
	  balance = 0;
	  key = k;
	 }
	 
	 public boolean waffle() {
		 return true;
	 }
	 public String toString() {
	  return "" + key;
	 }
}
