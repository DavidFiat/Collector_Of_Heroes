package graph;

import java.util.ArrayList;

public class GraphList<T extends Comparable<T>, V extends Comparable<V>> implements IGraph<T, V> {
	private ArrayList<ArrayList<Vertex<T>>> adjList;
	private ArrayList<Vertex<T>> vertices;
	private ArrayList<Edge<V>> edges;
	
	public GraphList(int numVertex) {
		adjList = new ArrayList<ArrayList<Vertex<T>>>(numVertex);
		vertices = new ArrayList<>(numVertex);
		edges = new ArrayList<>();
	}
	
	public int getIndexVertex(T valueVertex) {
		int index = -1;
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getValue().equals(valueVertex))
				index = i;
		}
		return index;
	}
	
	@Override
	public void addEdge(T vertex, T vertexEnd, boolean directed, double weight, V value) {
		int f = getIndexVertex(vertex);
		int d = getIndexVertex(vertexEnd);
		if (directed) {
			adjList.get(f).add(new Vertex<T>(vertexEnd));
			vertices.get(f).getEdges()
					.add(new Edge<V>(new Vertex<T>(vertex), new Vertex<T>(vertexEnd), weight, directed, value));
			edges.add(new Edge<V>(new Vertex<T>(vertex), new Vertex<T>(vertexEnd), weight, directed, value));
		} else {
			adjList.get(f).add(new Vertex<T>(vertexEnd));
			adjList.get(d).add(new Vertex<T>(vertex));
			vertices.get(f).getEdges()
					.add(new Edge<V>(new Vertex<T>(vertex), new Vertex<T>(vertexEnd), weight, directed, value));
			vertices.get(d).getEdges()
					.add(new Edge<V>(new Vertex<T>(vertexEnd), new Vertex<T>(vertex), weight, directed, value));
			edges.add(new Edge<V>(new Vertex<T>(vertex), new Vertex<T>(vertexEnd), weight, directed, value));
		}
	}

	@Override
	public void removeEdge(T vertex, T vertexEnd, boolean directed, double weight) {
		
	}

	@Override
	public void addVertex(T valueVertex) {
		vertices.add(new Vertex<T>(valueVertex));
		adjList.add(new ArrayList<Vertex<T>>());
	}

	@Override
	public void removeVertex(T valueVertex) {
		
	}

	@Override
	public int getNumVertex() {
		return adjList.size();
	}

	public ArrayList<ArrayList<Vertex<T>>> getAdjList() {
		return adjList;
	}

	public void setAdjList(ArrayList<ArrayList<Vertex<T>>> adjList) {
		this.adjList = adjList;
	}

	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Edge<V>> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge<V>> edges) {
		this.edges = edges;
	}
	
	public ArrayList<Edge<?>> getEdgesOfVertex(T vertex) {
		int index = getIndexVertex(vertex);
		return vertices.get(index).getEdges();

	}

	public int numEdgesOfVertex(T vertex) {
		int index = getIndexVertex(vertex);
		return vertices.get(index).getEdges().size();
	}
}
