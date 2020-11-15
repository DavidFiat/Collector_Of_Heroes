package graph;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
	private T value;
	private double weight;
	private boolean directed;
	private Vertex<?> vertex;
	private Vertex<?> vertexEnd;
	
	public Edge(boolean directed, double weight, T value) {
		directed=false;
		this.weight= weight;
		this.value= value;
	}
	
	public Edge(Vertex<?> vertex, Vertex<?> vertexEnd, double weight, boolean directed, T value) {
		directed= false;
		this.vertex = vertex;
		this.vertexEnd = vertexEnd;
		this.weight= weight;
		this.value= value;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public Vertex<?> getVertex() {
		return vertex;
	}

	public void setVertex(Vertex<?> vertex) {
		this.vertex = vertex;
	}

	public Vertex<?> getVertexEnd() {
		return vertexEnd;
	}

	public void setVertexEnd(Vertex<?> vertexEnd) {
		this.vertexEnd = vertexEnd;
	}

	@Override
	public int compareTo(Edge<T> o) {
		if (this.weight - o.weight < 0) {
			return -1;
		} else if (this.weight - o.weight > 0) {
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override
	public String toString() {

		return value + " - " + weight;

	}
}
