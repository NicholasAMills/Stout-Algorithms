import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class UndirectedGraph {
	/** vertices will store the name of a vertex(String) as the key that maps
	 * to a LinkedList of Vertex objects. This will provide the adjacency list
	 * for our UndirectedGraph */
	private HashMap<String, LinkedList<Vertex>> vertices;
	/** listOfVertices is an ArrayList of Vertex objects for all vertices in our graph */
	private ArrayList<Vertex> listOfVertices;
	
	/**
	 * UndirectedGraph constructor to assign listOfVertices and construct the HashMap vertices.
	 * @param listOfVertices - ArrayList of Vertex objects for all vertices in the graph
	 */
	public UndirectedGraph(ArrayList<Vertex> listOfVertices) {
		vertices = new HashMap<String, LinkedList<Vertex>>();
		for (int i = 0; i < listOfVertices.size(); i++) {
			vertices.put(listOfVertices.get(i).getName(), new LinkedList<Vertex>());
		}
		this.listOfVertices = listOfVertices;
	}
	
	/**
	 * addEdge - adds edge to graph by adding Vertex v to key u in vertices and
	 * adding Vertex u to key v in vertices. Both directions must be added for edge.
	 * @param u - Vertex incident on edge
	 * @param v - Vertex incident on edge
	 * @return true if edge added to graph from u to v and v to u, false otherwise
	 */
	public boolean addEdge(Vertex u, Vertex v) {
		return (vertices.get(u.getName()).add(v) && vertices.get(v.getName()).add(u));
	}
	
	@Override
	public String toString() {
		String s = "Adjacency list for graph:\n";
		for (String key : vertices.keySet()) {
			s += "Vertex " + key + ":" ;
			LinkedList<Vertex> adjacentNodes = vertices.get(key);
			Iterator<Vertex> iterator = adjacentNodes.iterator();
			while (iterator.hasNext()) {
				Vertex vertex = iterator.next();
				s += " ->" + vertex;
			}
			s += "\n";
		}
		return s;
	}
	
	public UndirectedGraph BreadthFirstSearch(Vertex start) {
//		initialize vertices; // mark all vertices as white
		for (Vertex v : listOfVertices) {
			v.setColor(v.WHITE);
		}
//		create graph T (BFS tree) using all vertices from G
		UndirectedGraph T = new UndirectedGraph(listOfVertices);
		
//		Q = {Start};
		LinkedList<Vertex> Q = new LinkedList<Vertex>();
		Q.add(start);
		
		while (Q.size() > 0) {
			//u = Dequeue Q
			Vertex u = Q.removeFirst();
			
			LinkedList<Vertex> adjList = vertices.get(u.getName());
			for (Vertex v : adjList) {//each v in u->adjacent) {
				if (v.getColor() == v.WHITE) {
//					v->color = GREEN;
					v.setColor(v.GREEN);
//					Enqueue to Q Vertex v
					Q.add(v);
//					tree T add edge(u,v)
					T.addEdge(u, v);
				}
			}
			//u->color = BLACK;
			u.setColor(u.BLACK);
		}
		return T;
	}
	
	public UndirectedGraph DepthFirstSearch(Vertex start) {
//		create Stack s
		Stack<Vertex> s = new Stack<Vertex>();
		
//		create ArrayList<Vertex> visited //store order of visited vertices
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		
//		create HashMap<Vertex, Vertex> predecessor //store predecessor value
		HashMap<Vertex,Vertex> predecessor = new HashMap<Vertex, Vertex>();
		
//		initialize each vertex u in the graph to set visited false
		for (Vertex v : listOfVertices)
			v.setVisited(false);
		
//		push Vertex start onto S
		s.push(start);
		
		while (!s.empty()) {
			//u := pop S;
			Vertex u = s.pop();
			if (!u.isVisited()) {
				//set visited u = true;
				u.setVisited(true);
				//add u to visited
				visited.add(u);
				
				// for each unvisited neighbor w of u do
				LinkedList<Vertex> adj = vertices.get(u.getName());
				for (Vertex w : adj) {
					if (!w.isVisited()) {
						//push Vertex w onto S
						s.push(w);
						//put w as key and u as value predecessor Hashmap
						predecessor.put(w, u);
					}
				}
			}
		}
		
		//Create Undirected Graph tree with vertices visited
		UndirectedGraph dfs = new UndirectedGraph(listOfVertices);

//		for each Vertex v stored in visited do
		for (Vertex v : visited) {
//			if predecessor contains key for v
			if (predecessor.containsKey(v))
//				get Vertex u from predecessor
//				add edge (u, v) to tree
				dfs.addEdge(predecessor.get(v), v);
		}
//		return tree
		return dfs;
//
//		//end DFS 
	}

}
