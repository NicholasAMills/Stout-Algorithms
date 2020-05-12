import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;

public class GraphMatrix {
	private Vertex[] vertices;
	private int[][] edgeWeights;

	/**
	 * Constructor
	 * 
	 * @param vertices    - instance variable to the array of all vertices in the
	 *                    graph
	 * @param edgeWeights - a 2D array of edge weights from Vertex to Vertex. The
	 *                    indices in the array match the indices of the Vertex in
	 *                    vertices
	 */
	public GraphMatrix(Vertex[] vertices, int[][] edgeWeights) {
		this.vertices = vertices;
		this.edgeWeights = edgeWeights;
	}

	public void Dijkstra(int sourceIndex) {
		Vertex source = vertices[sourceIndex];

		// create PriorityQueue<Vertex> Q
		LinkedList<Vertex> Q = new LinkedList<Vertex>();

		// create a HashMap<Vertex, Vertex> predecessor
		HashMap<Vertex, Vertex> predecessor = new HashMap<Vertex, Vertex>();

		// for each vertex v in Graph:
		for (Vertex v : vertices) {
			v.setDistance(Integer.MAX_VALUE); // dist[v] <- INFINITY
			if (v.equals(source)) // if v is source
				v.setDistance(0); // set dist[source] <- 0
			Q.add(v);
		}

		while (!Q.isEmpty()) {
			// u <- vertex in Q with min distance
			// remove u from Q
			Vertex u = Q.remove();

			// Find u index in vertices.
			// uIndex <- index of u in vertices
			int uIndex = -1;
			for (int i = 0; i < vertices.length; ++i) {
				if (vertices[i] == u)
					uIndex = i;
			}
			// get all neighbors of u (has >0 in edgeWeights)
			for (int i = 0; i < vertices.length; ++i) {
				// if edge exists u to v and in Min Queue
				if (this.edgeWeights[uIndex][i] > 0 && Q.contains(vertices[i])) {
					// alt <- dist[u] + length(u, v)
					int altDist = u.getDistance() + this.edgeWeights[uIndex][i];
					if (altDist < vertices[i].getDistance()) { // if alt < dist[v]
						Q.remove(vertices[i]);
						vertices[i].setDistance(altDist); // dist[v] <- alt
						Q.add(vertices[i]); // add v to u
						predecessor.put(vertices[i], u); // set u to be the predecessor to v
					}

				}
			}
		}
		
		System.out.println("Distance: \n");
		for (int i = 0; i < vertices.length; ++i) {
			System.out.println(vertices[i] + " ");
		}
		

		System.out.println("\nPath: ");
		// for each vertex current in vertices
		for (Vertex current : vertices) {
			String path = "";
			if (current != vertices[sourceIndex]) {
				path = " -> " + current;

				// while (predecessor contains key (current) )
				while (predecessor.containsKey(current)) {
					if (predecessor.get(current) == vertices[sourceIndex]) {
						// if (predecessor of current is source)
						path = predecessor.get(current) + path;
						//path = predecessor.get(current).getName() + ", " + predecessor.get(current).getDistance()
								//+ path;
					} else
						path = " -> " + predecessor.get(current) + path;
					current = predecessor.get(current);
				} // end while

			} // end if
			System.out.println(path);
		} // end for

	}

	public String toString() {

		
		String s = "Adjacency matrix for graph:\n";

		for(int fromVertex = 0; fromVertex < edgeWeights.length; fromVertex++) {

			s+=vertices[fromVertex];
		

			for(int toVertex = 0; toVertex < edgeWeights[fromVertex].length; toVertex++) {
	
				if(edgeWeights[fromVertex][toVertex]>0)
		
				s+= " ->"+vertices[toVertex]+", "+edgeWeights[fromVertex][toVertex];
	
			}

		s+="\n";
	}
		return s;
	}

}
