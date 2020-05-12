
public class Vertex {
	//constant color values for BFS Algorithm
	public static final int WHITE = 1;
	public static final int GREEN = 2;
	public static final int BLACK = 3;
	//instance variables
	private String name;
	private int color;
	private boolean visited; //used for DFS Algorithm
	/**
	 * Vertex constructor to initialize instance variables
	 * @param name
	 */
	public Vertex(String name) {
		this.name = name;
		color = 0;
		visited = false;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return color - color of vertices
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param color - new color
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * 
	 * @return visited
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * 
	 * @param visited - update vertices to say it was visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	

}
