package graph;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	private Vertex<T> vertex;
	private Double cost;

	public Node(Vertex<T> vertex, Double cost) {
		this.vertex = vertex;
		this.cost = cost;
	}

	public Vertex<T> getVertex() {
		return vertex;
	}

	public void setVertex(Vertex<T> vertex) {
		this.vertex = vertex;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Node<T> n) {
		int value = 0;
		if (this.cost <= n.cost) {
			value = -1;
		} else {
			value = 1;
		}
		return value;
	}
}
