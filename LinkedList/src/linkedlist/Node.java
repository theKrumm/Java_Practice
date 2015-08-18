package linkedlist;


public class Node<AnyType> {
	private AnyType myNode;
	private Node<AnyType> myNextNode;
	
	public Node(AnyType node) {
		myNode = node;
		myNextNode = null;
	}
	
	public Node(AnyType node, Node<AnyType> nextNode) {
		myNode = node;
		myNextNode = nextNode;
	}

	public AnyType getMyNode() {
		return myNode;
	}

	public void setMyNode(AnyType node) {
		myNode = node;
	}

	public Node<AnyType> getMyNextNode() {
		return myNextNode;
	}

	public void setMyNextNode(Node<AnyType> nextNode) {
		myNextNode = nextNode;
	}
}
