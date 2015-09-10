package bfs;


import java.util.*;
public class LinkedGraph {
	
	private static final int INFINITY = Integer.MAX_VALUE;
	Map<String, Node> nodeList;
	boolean directed;
	
	public LinkedGraph(){
		directed = false;
		nodeList = new TreeMap<String,Node>();
	}

	public void addNode(String label){
		nodeList.put(label, new Node(label));
	}

	public void addEdge(String source, String dest){
		Node src = nodeList.get(source);
		Node dst = nodeList.get(dest);
		if(src != null && dst != null){
			src.adjacencyList.add(dst);
			if(!directed && src != dst) dst.adjacencyList.add(src);
		}	
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(Node nde : nodeList.values()){
			sb.append(nde.toString());
			sb.append(" : ");
			for(Node oth : nde.adjacencyList){
				sb.append('(');
				sb.append(nde.toString());
				sb.append(", ");
				sb.append(oth.toString());
				sb.append(')');
				sb.append(' ');
			}
			sb.append('\n');
		}
		
		return sb.toString();
	}
	
	public void resetDistance() {
		for(Node n : nodeList.values())
			n.distance = INFINITY;
	}


	public int shortestPath(String source, String dest) {
		if(nodeList.get(source) == null || nodeList.get(dest) == null) {
	         throw new NoSuchElementException("Element not found.");
		}
		if (source == null) {
			throw new NullPointerException("Source null");
		}
		if (dest == null) {
			throw new NullPointerException("Destination null");
		}
		
	    resetDistance();
	    Node start = new Node(source);
	    Node finish = new Node(dest);
	    
	    if (start.label.equals(finish.label)) {
			Node temp = nodeList.get(start);
			temp.distance = 0;
		} else {
			Queue<Node> q = new LinkedList<Node>();
			Node temp = nodeList.get(start.label);
			temp.distance = 0;
			q.add(temp);
			while (!q.isEmpty()) {
				Node current = q.remove();
				for(Node node : current.adjacencyList) {
					if (node.distance == INFINITY) {
						node.distance = current.distance + 1;
						q.add(node);
					}					
				}
			}			
		}		
		if (nodeList.get(finish.label).distance == INFINITY)
			throw new IllegalStateException("No path found.");
		return nodeList.get(finish.label).distance;
	}

	private class Node{
		List<Node> adjacencyList;
		String label;
		public int distance;
		
		public Node(String lbl){
			label = lbl;
			adjacencyList = new ArrayList<Node>();
			distance = INFINITY;
		}
		
		public String toString(){
			return label;
		}
	}
	
}





