package graph;

public interface IGraph<T extends Comparable<T>, V extends Comparable<V>>{
	public void addEdge(T vertex, T vertexEnd, boolean directed, double weight, V value);
	public void removeEdge(T vertex, T vertexEnd, boolean directed, double weight);
	public void addVertex(T valueVertex);
	public void removeVertex(T valueVertex);
	public int getNumVertex();
}
