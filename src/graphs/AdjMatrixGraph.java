package graphs;

import java.io.Serializable;
import java.util.*;

public class AdjMatrixGraph<T> implements IGraph<T>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private boolean directed;
	private boolean weighted;
	private int totalVertices;
	private int totalEdges;
	private List<Vertex<T>> vertices;
	private List<ArrayList<Integer>> adjMatrix;
	private List<ArrayList<Double>> weightsMatrix;
	private HashMap<T, Vertex<T>> hashMap;

	public AdjMatrixGraph(boolean directed, boolean weighted) {
		this.directed = directed;
		this.weighted = weighted;
		totalVertices = 0;
		totalEdges = getTotalEdges();
		vertices = new LinkedList<Vertex<T>>();
		adjMatrix = new ArrayList<ArrayList<Integer>>();
		weightsMatrix = new ArrayList<ArrayList<Double>>();
		hashMap = new HashMap<>();
	}

	@Override
	public void addVertex(T value) {
		if (!isInGraph(value)) {
			Vertex<T> vertex = new Vertex<T>(value);
			hashMap.put(value, vertex);
			vertices.add(vertex);
			ArrayList<Integer> adj = new ArrayList<>();
			ArrayList<Double> weights = new ArrayList<>();
			for (int i = 0; i < adjMatrix.size(); i++) {
				adjMatrix.get(i).add(0);
				weightsMatrix.get(i).add((double) INFINITE);
			}
			for (int i = 0; i < vertices.size(); i++) {
				adj.add(0);
				weights.add((double) INFINITE);
			}
			weights.set(weights.size() - 1, 0.0);
			adjMatrix.add(adj);
			weightsMatrix.add(weights);
			totalVertices++;
		}
	}

	@Override
	public boolean isInGraph(T value) {
		return searchVertex(value) != null;
	}

	@Override
	public Vertex<T> searchVertex(T value) {
		return hashMap.get(value);
	}

	public void deleteVertex(T v) {
		if (isInGraph(v)) {
			deleteVertex(searchVertex(v));
		}
	}

	private void deleteVertex(Vertex<T> v) {
		int index = getIndexOf(v);
		for (int i = 0; i < adjMatrix.size(); i++) {
			adjMatrix.get(i).remove(index);
			weightsMatrix.get(i).remove(index);
		}
		adjMatrix.remove(index);
		weightsMatrix.remove(index);
		vertices.remove(v);
		hashMap.remove(v.getValue());
		totalVertices--;
	}

	@Override
	public void addEdge(T x, T y) {
		Vertex<T> initial = searchVertex(x);
		Vertex<T> destination = searchVertex(y);
		addEdge(initial, destination);
	}

	private void addEdge(Vertex<T> initial, Vertex<T> destination) {
		addEdge(initial, destination, 1D);
	}

	@Override
	public void addEdge(T x, T y, double w) {
		if (weighted) {
			Vertex<T> initial = searchVertex(x);
			Vertex<T> destination = searchVertex(y);
			addEdge(initial, destination, w);
		}
	}

	private void addEdge(Vertex<T> initial, Vertex<T> destination, double w) {
		if (initial != null && destination != null) {
			adjMatrix.get(getIndexOf(initial)).set(getIndexOf(destination), 1);
			weightsMatrix.get(getIndexOf(initial)).set(getIndexOf(destination),
					Math.min(w, weightsMatrix.get(getIndexOf(initial)).get(getIndexOf(destination))));
			if (!isDirected()) {
				adjMatrix.get(getIndexOf(destination)).set(getIndexOf(initial), 1);
				weightsMatrix.get(getIndexOf(destination)).set(getIndexOf(initial),
						Math.min(w, weightsMatrix.get(getIndexOf(destination)).get(getIndexOf(initial))));
			}
			totalEdges++;
		}
	}

	@Override
	public void deleteEdge(T x, T y) {
		if (isInGraph(x) && isInGraph(y)) {
			deleteEdge(searchVertex(x), searchVertex(y));
		}
	}

	private void deleteEdge(Vertex<T> initial, Vertex<T> destination) {
		adjMatrix.get(getIndexOf(initial)).set(getIndexOf(destination), 0);
		weightsMatrix.get(getIndexOf(initial)).set(getIndexOf(destination), (double) INFINITE);
		if (!isDirected()) {
			adjMatrix.get(getIndexOf(destination)).set(getIndexOf(initial), 0);
			weightsMatrix.get(getIndexOf(destination)).set(getIndexOf(initial), (double) INFINITE);
		}
		totalEdges--;
	}

	@Override
	public boolean areAdjacent(Vertex<T> x, Vertex<T> y) {
		return getAdjVertices(x).contains(y);
	}

	@Override
	public List<Vertex<T>> getAdjVertices(Vertex<T> x) {
		List<Vertex<T>> adjVertices = new ArrayList<>();
		int index = getIndexOf(x);
		for (int i = 0; i < adjMatrix.get(index).size(); i++) {
			if (adjMatrix.get(index).get(i) == 1.0) {
				adjVertices.add(vertices.get(i));
			}
		}
		return adjVertices;
	}

	@Override
	public ArrayList<Edge<T>> getEdges() {
		ArrayList<Edge<T>> edges = new ArrayList<>();
		for (int i = 0; i < adjMatrix.size(); i++) {
			for (int j = 0; j < adjMatrix.get(i).size(); j++) {
				if (adjMatrix.get(i).get(j) == 1) {
					edges.add(new Edge<>(vertices.get(i), vertices.get(j), weightsMatrix.get(i).get(j)));
				}
			}
		}
		return edges;
	}

	@Override
	public double getEdgeWeight(Vertex<T> x, Vertex<T> y) {
		double w = 0;
		int indX = getIndexOf(x);
		int indY = getIndexOf(y);
		if (isInGraph(x.getValue()) && isInGraph(y.getValue())) {
			w = weightsMatrix.get(indX).get(indY);
		}
		return w;
	}

	@Override
	public void setEdgeWeight(Vertex<T> x, Vertex<T> y, double w) {
		int indX = getIndexOf(x);
		int indY = getIndexOf(y);
		if (isInGraph(x.getValue()) && isInGraph(y.getValue()) && weighted) {
			weightsMatrix.get(indX).set(indY, w);
			if (!isDirected()) {
				weightsMatrix.get(indY).set(indX, w);
			}
		}
	}

	@Override
	public void bfs(Vertex<T> x) {
		for (Vertex<T> u : vertices) {
			u.setColor(Vertex.WHITE);
			u.setInitialTimeStamp(INFINITE);
			u.setPred(null);
		}
		x.setColor(Vertex.GRAY);
		x.setInitialTimeStamp(0);
		x.setPred(null);
		Queue<Vertex<T>> q = new LinkedList<>();
		q.offer(x);
		while (!q.isEmpty()) {
			Vertex<T> u = q.poll();
			List<Vertex<T>> adjVertices = getAdjVertices(u);
			for (int i = 0; i < adjVertices.size(); i++) {
				Vertex<T> v = adjVertices.get(i);
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
		int time = 0;
		for (Vertex<T> u : vertices) {
			if (u.getColor() == Vertex.WHITE)
				time = dfsVisited(u, time);
		}
	}

	private int dfsVisited(Vertex<T> u, int timeStamp) {
		timeStamp++;
		u.setInitialTimeStamp(timeStamp);
		u.setColor(Vertex.GRAY);
		List<Vertex<T>> adjVertices = getAdjVertices(u);
		for (int i = 0; i < adjVertices.size(); i++) {
			Vertex<T> v = adjVertices.get(i);
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
	public void prim(Vertex<T> r) {
		for (Vertex<T> u : vertices) {
			u.setInitialTimeStamp(INFINITE);
			u.setColor(Vertex.WHITE);
		}
		r.setInitialTimeStamp(0);
		r.setPred(null);
		PriorityQueue<Vertex<T>> queue = new PriorityQueue<>();
		for (Vertex<T> u : vertices) {
			queue.add(u);
		}
		while (!queue.isEmpty()) {
			Vertex<T> u = queue.poll();
			List<Vertex<T>> adjVertices = getAdjVertices(u);
			for (Vertex<T> v : adjVertices) {
				if (v.getColor() == Vertex.WHITE && getEdgeWeight(u, v) < v.getInitialTimeStamp()) {
					queue.remove(v);
					v.setInitialTimeStamp(getEdgeWeight(u, v));
					queue.add(v);
					v.setPred(u);
				}
			}
			u.setColor(Vertex.BLACK);
		}
	}

	@Override
	public ArrayList<Edge<T>> kruskal() {
		ArrayList<Edge<T>> result = new ArrayList<>();
		int e = 0;
		int i = 0;
		ArrayList<Edge<T>> edges = getEdges();
		Collections.sort(edges);
		DisjointSets dss = new DisjointSets(vertices.size());

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
		setInitialVertex(x);
		PriorityQueue<Vertex<T>> queue = new PriorityQueue<>();
		queue.add(x);
		while (!queue.isEmpty()) {
			Vertex<T> u = queue.poll();
			List<Vertex<T>> adjVertices = getAdjVertices(u);
			for (Vertex<T> v : adjVertices) {
				double weight = getEdgeWeight(u, v);
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
	
	private void setInitialVertex(Vertex<T> x) {
		for (Vertex<T> u : vertices) {
			u.setInitialTimeStamp(INFINITE);
			u.setPred(null);
		}
		x.setInitialTimeStamp(0);
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

	@Override
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

	public double[][] getWeightsMatrix() {
		double[][] weights = new double[vertices.size()][vertices.size()];
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				weights[i][j] = weightsMatrix.get(i).get(j);
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

	public List<ArrayList<Integer>> getAdjMatrix() {
		return adjMatrix;
	}
	
	@Override
	public List<Vertex<T>> getVertices() {
		return vertices;
	}

	@Override
	public int getTotalVertices() {
		return totalVertices;
	}

	@Override
	public int getTotalEdges() {
		return totalEdges;
	}

	@Override
	public boolean isDirected() {
		return directed;
	}

	@Override
	public boolean isWeighted() {
		return weighted;
	}
}
