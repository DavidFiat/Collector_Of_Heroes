package graphs;

import java.io.Serializable;

public class Edge<T> implements Comparable<Edge<T>>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private double weight;
	private Vertex<T> initial;
	private Vertex<T> destination;

	public Edge(Vertex<T> initial, Vertex<T> destination) {
		this(initial, destination, 1d);
	}

	public Edge(Vertex<T> initial, Vertex<T> destination, double weight) {
		this.initial = initial;
		this.destination = destination;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex<T> getInitial() {
		return initial;
	}

	public Vertex<T> getDestination() {
		return destination;
	}

	@Override
	public int compareTo(Edge<T> o) {
		return Double.compare(weight, o.weight);
	}
}
