package mergesort;


public class Node<AnyType> {
	private AnyType value;
	private Node<AnyType> next;
	
	public Node(AnyType node) {
		value = node;
		next = null;
	}
	
	public Node(AnyType node, Node<AnyType> nextNode) {
		value = node;
		next = nextNode;
	}

	public AnyType getValue() {
		return value;
	}

	public void setValue(AnyType node) {
		value = node;
	}

	public Node<AnyType> getNext() {
		return next;
	}

	public void setNext(Node<AnyType> nextNode) {
		next = nextNode;
	}
	
}
