package graphs;

import java.util.List;

/**
 * Basic operations and algorithms used by a graph
 * @author usuario
 * @param <T> Type parameters stored in the vertex
 */
public interface IGraph<T> {
	
	/**
	 * Very large number to represent an infinite value
	 */
	public static final int INFINITE = Integer.MAX_VALUE;
	
	/**
	 * Adds a new vertex to the graph with no connections
	 * @param value Vertex to be added
	 */
	public void addVertex(T value);
	
	/**
	 * Searches a vertex in the graph
	 * @param value Type parameter stored in the vertex
	 * @return Vertex<T> which contains the value T
	 */
	public Vertex<T> searchVertex(T value);
	
	/**
	 * Deletes a vertex and its edges
	 * @param v Vertex to be deleted
	 */
	public void deleteVertex(T v);
	
	/**
	 * Adds an edge to connect two vertices
	 * @param x Starting vertex
	 * @param y Destination vertex
	 */
	public void addEdge(T x, T y);
	
	/**
	 * Adds a weighted edge to connect two vertices
	 * @param x Starting vertex
	 * @param y Destination vertex
	 * @param w Edge's weight
	 */
	public void addEdge(T x, T y, double w);
	
	/**
	 * Deletes the edge which starting vertex is x and destination vertex is y
	 * @param x Starting vertex
	 * @param y Destination vertex
	 */
	public void deleteEdge(T x, T y);

	/**
	 * Implementation of the Breadth-first search algorithm to iterate over a graph
	 * @param s Starting vertex
	 */
	public void bfs(Vertex<T> s);
	
	/**
	 * Implementation of the Depth-first search algorithm to iterate over a graph
	 * @param s Starting vertex
	 */
	public void dfs();
	
	/**
	 * Implementation of the Dijkstra algorithm to find the shortest path from x to all the other vertices
	 * @param x Starting point vertex
	 */
	public void dijkstra(Vertex<T> x);
	
	public boolean isInGraph(T value);
	
	public boolean areAdjacent(Vertex<T> x, Vertex<T> y);
	
	public List<Vertex<T>> getAdjVertices(Vertex<T> x);
	
	public List<Edge<T>> getEdges();
	
	public double getEdgeWeight(Vertex<T> x, Vertex<T> y);
	
	public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w);
	
	public List<Vertex<T>> getVertices();
	
	public int getTotalVertices();
	
	public int getTotalEdges();
	
	public boolean isDirected();

	public boolean isWeighted();
}
