
public class Vertex implements Comparable<Vertex>{
	private String name;
	private int color;
	private int distance;
	private boolean visited;
	public static int WHITE = 1;
	public static int GREEN = 2;
	public static int BLACK = 3;
	
	/**
	 * 
	 * @param name
	 */
	public Vertex(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return - returns name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return - returns node color
	 */
	public int getColor() {
		return this.color;
	}
	
	/**
	 * 
	 * @param color - set color of node
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * 
	 * @return - return True or False depending if node has been visited
	 */
	public boolean isVisited() {
		return this.visited;
	}
	
	/**
	 * 
	 * @param visited - update vertex's visited state
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * 
	 * @return - return distance to vertex
	 */
	public int getDistance() {
		return this.distance;
	}
	
	/**
	 * 
	 * @param distance - update distance to vertex
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * 
	 * @param o - vertex being compared
	 * @return - return the result of the comparison
	 */
	public int compareTo(Vertex o) {
		int value = 0;
		if (this.distance < o.getDistance())
			value = -1;
		else if (this.distance > o.getDistance())
			value = 1;
		return value;
	}
	
	/**
	 * @return - return vertex name
	 */
	public String toString() {
		if (this.distance > 0)
			return name + ", " + this.distance;
		else 
			return name;
	}
	

}
