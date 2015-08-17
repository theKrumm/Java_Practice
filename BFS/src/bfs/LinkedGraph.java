package bfs;


import java.util.*;
public class LinkedGraph {
	
	private class Node{
		List<Node> adjacencyList;
		String label;
		
		public Node(String lbl){
			label = lbl;
			adjacencyList = new ArrayList<Node>();
		}
		
		public String toString(){
			return label;
		}
	}
	
	Map<String, Node> nodeList;
	boolean directed;
	
	/**
	 * Creates empty LinkedGraph.  Default is undirected.
	 */
	public LinkedGraph(){
		directed = false;
		nodeList = new TreeMap<String,Node>();
	}
	
	/**
	 * Adds a new node to the LinkedGraph.
	 * 
	 * @param label The label of the new node.
	 */
	public void addNode(String label){
		nodeList.put(label, new Node(label));
	}
	
	/**
	 * Adds a new edge to the LinkedGraph.
	 * 
	 * @param source The source endpoint of the edge.
	 * @param dest The destination endpoint of the edge.
	 */
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
	
	public int shortestPath(String source, String dest){
		// find shortest length
		 /*TO DO*/
	}// end of shortestPath

}
