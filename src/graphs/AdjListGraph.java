package graphs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AdjListGraph<T> implements IGraph<T>, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean directed;
	private boolean weighted;
	private int totalVertices;
	private int totalEdges;
	private List<Vertex<T>> vertices;
	private HashMap<T, AdjVertex<T>> hashMap;

	public AdjListGraph(boolean directed, boolean weighted) {
		this.directed = directed;
		this.weighted = weighted;
		totalVertices = 0;
		totalEdges = getTotalEdges();
		vertices = new LinkedList<Vertex<T>>();
		hashMap = new HashMap<>();
	}

	@Override
	public void addVertex(T value) {
		if (!isInGraph(value)) {
			AdjVertex<T> vertex = new AdjVertex<T>(value);
			hashMap.put(value, vertex);
			vertex.setIndex(totalVertices);
			vertices.add(vertex);
			totalVertices++;
		}
	}

	public boolean isInGraph(T value) {
		return searchVertex(value) != null;
	}

	public AdjVertex<T> searchVertex(T value) {
		return hashMap.get(value);
	}

	public void deleteVertex(T v) {
		if (isInGraph(v)) {
			deleteVertex(searchVertex(v));
		}
	}

	public void deleteVertex(Vertex<T> v) {
		for (int i = 0; i < vertices.size(); i++) {
			deleteEdge(vertices.get(i), v);
			if (isDirected()) {
				deleteEdge(v, vertices.get(i));
			}
		}
		vertices.remove(v);
		hashMap.remove(v.getValue());
		totalVertices--;
	}

	@Override
	public void addEdge(T x, T y) {
		AdjVertex<T> initial = searchVertex(x);
		AdjVertex<T> destination = searchVertex(y);
		addEdge(initial, destination);
	}

	@Override
	public void addEdge(T x, T y, double w) {
		if (weighted) {
			AdjVertex<T> initial = searchVertex(x);
			AdjVertex<T> destination = searchVertex(y);
			addEdge(initial, destination, w);
		}
	}

	public void addEdge(AdjVertex<T> initial, AdjVertex<T> destination) {
		addEdge(initial, destination, 1D);
	}

	public void addEdge(AdjVertex<T> initial, AdjVertex<T> destination, double w) {
		if (initial != null && destination != null) {
			Edge<T> edge = new Edge<T>(initial, destination, w);
			initial.getAdjList().add(edge);
			if (!isDirected()) {
				edge = new Edge<T>(destination, initial, w);
				destination.getAdjList().add(edge);
			}
			totalEdges++;
		}
	}

	public void deleteEdge(T x, T y) {
		if (isInGraph(x) && isInGraph(y)) {
			deleteEdge(searchVertex(x), searchVertex(y));
		}
	}

	public void deleteEdge(Vertex<T> x, Vertex<T> y) {
		AdjVertex<T> initial = (AdjVertex<T>) x;
		AdjVertex<T> destination = (AdjVertex<T>) y;
		List<Edge<T>> adjInitial = initial.getAdjList();
		Edge<T> e = initial.findEdge(destination);
		if (e != null)
			adjInitial.remove(e);

		if (!isDirected()) {
			List<Edge<T>> adjDestination = destination.getAdjList();
			e = destination.findEdge(initial);
			if (e != null)
				adjDestination.remove(e);
		}
		totalEdges--;
	}

	public boolean areAdjacent(Vertex<T> x, Vertex<T> y) {
		return getAdjVertices(x).contains(y);
	}

	public List<Vertex<T>> getAdjVertices(Vertex<T> x) {
		List<Vertex<T>> adjVertices = new ArrayList<>();
		AdjVertex<T> initial = (AdjVertex<T>) x;
		List<Edge<T>> adjEdges = initial.getAdjList();
		for (int i = 0; i < adjEdges.size(); i++) {
			adjVertices.add(adjEdges.get(i).getDestination());
		}
		return adjVertices;
	}

	public ArrayList<Edge<T>> getEdges() {
		ArrayList<Edge<T>> edges = new ArrayList<>();
		for (int i = 0; i < vertices.size(); i++) {
			AdjVertex<T> v = (AdjVertex<T>) vertices.get(i);
			for (int j = 0; j < v.getAdjList().size(); j++) {
				edges.add(v.getAdjList().get(j));
			}
		}
		return edges;
	}

	public double getEdgeWeight(Vertex<T> x, Vertex<T> y) {
		double w = 0;
		if (isInGraph(x.getValue()) && isInGraph(y.getValue())) {
			AdjVertex<T> initial = (AdjVertex<T>) x;
			AdjVertex<T> destination = (AdjVertex<T>) y;
			Edge<T> e = initial.findEdge(destination);
			if (e != null)
				w = e.getWeight();
		}
		return w;
	}

	public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w) {
		if (isInGraph(x.getValue()) && isInGraph(y.getValue()) && weighted) {
			AdjVertex<T> initial = (AdjVertex<T>) x;
			AdjVertex<T> destination = (AdjVertex<T>) y;
			Edge<T> e = initial.findEdge(destination);
			if (e != null)
				e.setWeight(w);

			if (!isDirected()) {
				e = destination.findEdge(initial);
				if (e != null)
					e.setWeight(w);
			}
		}
	}

	@Override
	public void bfs(Vertex<T> s) {
		AdjVertex<T> x = (AdjVertex<T>) s;
		for (Vertex<T> u : vertices) {
			u.setColor(Vertex.WHITE);
			u.setInitialTimeStamp(INFINITE);
			u.setPred(null);
		}
		x.setColor(Vertex.GRAY);
		x.setInitialTimeStamp(0);
		x.setPred(null);
		Queue<AdjVertex<T>> q = new LinkedList<>();
		q.offer(x);
		while (!q.isEmpty()) {
			AdjVertex<T> u = q.poll();
			for (int i = 0; i < u.getAdjList().size(); i++) {
				AdjVertex<T> v = (AdjVertex<T>) u.getAdjList().get(i).getDestination();
				if (v.getColor() == Vertex.WHITE) {
					v.setColor(Vertex.GRAY);
					v.setInitialTimeStamp(u.getInitialTimeStamp() + 1);
					v.setPred(u);
					q.offer(v);
				}
			}
			u.setColor(Vertex.BLACK);
		}
	}

	@Override
	public void dfs() {
		for (Vertex<T> u : vertices) {
			u.setColor(Vertex.WHITE);
			u.setPred(null);
		}
		int timeStamp = 0;
		for (Vertex<T> u : vertices) {
			if (u.getColor() == Vertex.WHITE)
				timeStamp = dfsVisited((AdjVertex<T>) u, timeStamp);
		}
	}

	private int dfsVisited(AdjVertex<T> u, int timeStamp) {
		timeStamp++;
		u.setInitialTimeStamp(timeStamp);
		u.setColor(Vertex.GRAY);
		for (int i = 0; i < u.getAdjList().size(); i++) {
			AdjVertex<T> v = (AdjVertex<T>) u.getAdjList().get(i).getDestination();
			if (v.getColor() == Vertex.WHITE) {
				v.setPred(u);
				timeStamp = dfsVisited(v, timeStamp);
			}
		}
		u.setColor(Vertex.BLACK);
		timeStamp++;
		u.setFinalTimeStamp(timeStamp);
		return timeStamp;
	}

	@Override
	public void prim(Vertex<T> s) {
		AdjVertex<T> r = (AdjVertex<T>) s;
		for (Vertex<T> u : vertices) {
			u.setInitialTimeStamp(INFINITE);
			u.setColor(Vertex.WHITE);
		}
		r.setInitialTimeStamp(0);
		r.setPred(null);
		PriorityQueue<AdjVertex<T>> queue = new PriorityQueue<>();
		for (Vertex<T> u : vertices) {
			queue.add((AdjVertex<T>) u);
		}
		while (!queue.isEmpty()) {
			AdjVertex<T> u = queue.poll();
			for (Edge<T> e : u.getAdjList()) {
				AdjVertex<T> v = (AdjVertex<T>) e.getDestination();
				if (v.getColor() == Vertex.WHITE && e.getWeight() < v.getInitialTimeStamp()) {
					queue.remove(v);
					v.setInitialTimeStamp(e.getWeight());
					queue.add(v);
					v.setPred(u);
				}
			}
			u.setColor(Vertex.BLACK);
		}
	}

	public ArrayList<Edge<T>> kruskal() {
		ArrayList<Edge<T>> result = new ArrayList<>();
		int e = 0;
		int i = 0;
		ArrayList<Edge<T>> edges = getEdges();
		Collections.sort(edges);
		DisjointSets dss = new DisjointSets(vertices.size());

		i = 0;
		while (e < vertices.size() - 1 && i < edges.size()) {
			Edge<T> edge = edges.get(i);
			i++;
			int x = dss.find(getIndexOf(edge.getInitial()));
			int y = dss.find(getIndexOf(edge.getDestination()));
			if (x != y) {
				result.add(edge);
				e++;
				dss.union(x, y);
			}
		}
		return result;
	}

	@Override
	public void dijkstra(Vertex<T> x) {
		AdjVertex<T> s = (AdjVertex<T>) x;
		setInitialVertex(s);
		PriorityQueue<AdjVertex<T>> queue = new PriorityQueue<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			AdjVertex<T> u = queue.poll();
			for (Edge<T> e : u.getAdjList()) {
				AdjVertex<T> v = (AdjVertex<T>) e.getDestination();
				double weight = e.getWeight();
				double distanceFromU = u.getInitialTimeStamp() + weight;
				if (distanceFromU < v.getInitialTimeStamp()) {
					queue.remove(v);
					v.setInitialTimeStamp(distanceFromU);
					v.setPred(u);
					queue.add(v);
				}
			}
		}
	}
	
	public List<T> getShortestPathList(Vertex<T> x, Vertex<T> y) {
		List<T> vertexValues = new ArrayList<>();
		dijkstra(x);
		while(y.getPred()!=null) {
			vertexValues.add(y.getValue());
			y = y.getPred();
		}
		Collections.reverse(vertexValues);
		return vertexValues;
	}

	private void setInitialVertex(AdjVertex<T> s) {
		for (Vertex<T> u : vertices) {
			u.setInitialTimeStamp(INFINITE);
			u.setPred(null);
		}
		s.setInitialTimeStamp(0);
	}

	public double[][] floydWarshall() {
		double[][] weights = getWeightsMatrix();
		for (int k = 0; k < vertices.size(); k++) {
			for (int i = 0; i < vertices.size(); i++) {
				for (int j = 0; j < vertices.size(); j++) {
					weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[k][j]);
				}
			}
		}
		return weights;
	}

	private double[][] getWeightsMatrix() {
		double[][] weights = new double[vertices.size()][vertices.size()];
		for (int i = 0; i < weights.length; i++) {
			Arrays.fill(weights[i], INFINITE);
		}
		for (int i = 0; i < vertices.size(); i++) {
			weights[i][i] = 0;
			AdjVertex<T> u = (AdjVertex<T>) vertices.get(i);
			for (Edge<T> e : u.getAdjList()) {
				AdjVertex<T> v = (AdjVertex<T>) e.getDestination();
				double weight = e.getWeight();
				weights[i][getIndexOf(v)] = weight;
			}
		}
		return weights;
	}

	public int getIndexOf(Vertex<T> v) {
		int index = -1;
		boolean searching = true;
		for (int i = 0; i < vertices.size() && searching; i++) {
			if (vertices.get(i) == v) {
				index = i;
				searching = false;
			}
		}
		return index;
	}

	public List<Vertex<T>> getVertices() {
		return vertices;
	}

	public int getTotalVertices() {
		return totalVertices;
	}

	public int getTotalEdges() {
		return totalEdges;
	}

	public boolean isDirected() {
		return directed;
	}

	public boolean isWeighted() {
		return weighted;
	}
}
