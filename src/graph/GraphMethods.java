package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphMethods<T extends Comparable<T>, V extends Comparable<V>>{
	public GraphMethods() {
		// TODO Auto-generated constructor stub
	}

	//DFS
	@SuppressWarnings("unchecked")
	private ArrayList<Vertex<T>> DFS(GraphList<T, V> g, Vertex<T> v, boolean[] visited, Stack<Vertex<T>> stack, ArrayList<Vertex<T>> dfs) {
		if (dfs.size() == g.getVertices().size()) {
			return dfs;
		}
		ArrayList<Vertex<T>> vertices = g.getVertices();
		int index = g.getIndexVertex(v.getValue());
		visited[index] = true;
		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {
			if (stack.peek() != v) {
				stack.push(v);
				dfs.add(v);
			}
			T value = (T) vertices.get(index).getEdges().get(i).getVertexEnd().getValue();
			if (visited[g.getIndexVertex(value)] == false) {
				return DFS(g, (Vertex<T>) vertices.get(index).getEdges().get(i).getVertexEnd(), visited, stack, dfs);
			}
		}
		stack.pop();
		return DFS(g, stack.peek(), visited, stack, dfs);
	}

	public ArrayList<Vertex<T>> DFS(GraphList<T, V> g, Vertex<T> v) {
		boolean[] visited = new boolean[g.getVertices().size()];
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		ArrayList<Vertex<T>> dfs = new ArrayList<>();
		stack.push(v);
		dfs.add(v);
		return DFS(g, v, visited, stack, dfs);
	}

	//BFS
	@SuppressWarnings("unchecked")
	private ArrayList<Vertex<T>> BFS(GraphList<T, V> g, Vertex<T> v, boolean[] visited, Queue<Vertex<T>> queue, ArrayList<Vertex<T>> bfs) {
		if (bfs.size() == g.getVertices().size()) {
			return bfs;
		}
		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();
		visited[index] = true;
		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {
			if (visited[g.getIndexVertex((T) vertices.get(index).getEdges().get(i).getVertexEnd().getValue())] == false) {
				queue.add((Vertex<T>) vertices.get(index).getEdges().get(i).getVertexEnd());
			}
		}
		bfs.add(queue.poll());
		return BFS(g, queue.peek(), visited, queue, bfs);
	}

	public ArrayList<Vertex<T>> BFS(GraphList<T, V> g, Vertex<T> v) {
		boolean[] visited = new boolean[g.getVertices().size()];
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		ArrayList<Vertex<T>> bfs = new ArrayList<>();
		queue.add(v);
		return BFS(g, v, visited, queue, bfs);
	}

	//DIJKSTRA
	private void relax(int actual, int adj, double weight, double[] distances, PriorityQueue<Node<T>> queue, GraphList<T, V> g) {
		if (distances[actual] + weight < distances[adj]) {
			distances[adj] = distances[actual] + weight;
			queue.add(new Node<T>(g.getVertices().get(adj), distances[adj]));
		}
	}

	@SuppressWarnings("unchecked")
	private double[] Dijkstra(GraphList<T, V> g, Vertex<T> v, boolean[] included, double[] distances, ArrayList<Double> minDistances, PriorityQueue<Node<T>> queue) {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = Double.MAX_VALUE;
		}
		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();
		distances[index] = 0.0;
		queue.add(new Node<>(v, distances[index]));
		while (!queue.isEmpty()) {
			Node<T> u = queue.poll();
			int indexAux = g.getIndexVertex(u.getVertex().getValue());
			if (included[indexAux]) {
				u = queue.poll();
			}
			included[indexAux] = true;
			for (int i = 0; i < vertices.get(indexAux).getEdges().size(); i++) {
				int adj = g.getIndexVertex((T) vertices.get(indexAux).getEdges().get(i).getVertexEnd().getValue());
				double weight = vertices.get(indexAux).getEdges().get(i).getWeight();
				if (included[adj] == false) {
					relax(indexAux, adj, weight, distances, queue, g);
				}
			}
		}
		return distances;
	}

	public double[] Dijkstra(GraphList<T, V> g, Vertex<T> v) {
		boolean[] included = new boolean[g.getVertices().size()];
		double[] distances = new double[g.getVertices().size()];
		PriorityQueue<Node<T>> queue = new PriorityQueue<>();
		ArrayList<Double> minDistances = new ArrayList<>();
		return Dijkstra(g, v, included, distances, minDistances, queue);
	}

	//FLOYDWARSHALL
	@SuppressWarnings("unchecked")
	private double[][] floydWarshall(GraphList<T, V> g, double[][] matrixFW) {
		for (int i = 0; i < matrixFW.length; i++) {
			for (int j = 0; j < matrixFW[0].length; j++) {
				if (i != j) {
					matrixFW[i][j] = Double.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < g.getVertices().size(); i++) {
			for (int j = 0; j < g.getVertices().get(i).getEdges().size(); j++) {
				int index = g.getIndexVertex((T) g.getVertices().get(i).getEdges().get(j).getVertexEnd().getValue());
				if (matrixFW[i][index] != Double.MAX_VALUE) {
					if (matrixFW[i][index] > g.getVertices().get(i).getEdges().get(j).getWeight()) {
						matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getWeight();
					}
				} else {
					matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getWeight();
				}
			}
		}
		for (int k = 0; k < matrixFW.length; k++) {
			for (int i = 0; i < matrixFW.length; i++) {
				for (int j = 0; j < matrixFW.length; j++) {
					matrixFW[i][j] = Math.min(matrixFW[i][j], matrixFW[i][k] + matrixFW[k][j]);
				}
			}
		}
		return matrixFW;
	}

	public double[][] floydWarshall(GraphList<T, V> g) {
		double[][] matrixFW = new double[g.getVertices().size()][g.getVertices().size()];
		return floydWarshall(g, matrixFW);
	}

	//KRUSKAL
	private int disjoinAuxVertex(int[] disjoin, int pos) {
		if (disjoin[pos] < 0) {
			return pos;
		} else {
			return disjoinAuxVertex(disjoin, disjoin[pos]);
		}
	}

	@SuppressWarnings("unchecked")
	private double kruskal(GraphList<T, V> g, int[] disjoin, ArrayList<Edge<V>> edges) {
		double minCost = 0.0;
		int edgesValidate = 0;
		for (int i = 0; i < disjoin.length; i++) {
			disjoin[i] = -1;
		}
		while (edgesValidate != g.getVertices().size() - 1) {
			Edge<V> aux = edges.remove(0);
			Vertex<T> ini = (Vertex<T>) aux.getVertex();
			Vertex<T> dest = (Vertex<T>) aux.getVertexEnd();
			int posIni = g.getIndexVertex(ini.getValue());
			int posDest = g.getIndexVertex(dest.getValue());
			if ((disjoin[posIni] < 0) && (disjoin[posDest] < 0)) {
				disjoin[posDest] += disjoin[posIni];
				disjoin[posIni] = posDest;
				minCost += aux.getWeight();
				edgesValidate++;
			} else {
				int disjoinFrom = disjoinAuxVertex(disjoin, posIni);
				int disjoinTo = disjoinAuxVertex(disjoin, posDest);
				if (disjoinFrom != disjoinTo) {
					int valueFrom = disjoin[disjoinFrom];
					disjoin[disjoinTo] += valueFrom;
					disjoin[disjoinFrom] = disjoinTo;
					minCost += aux.getWeight();
					edgesValidate++;
				}
			}
		}
		return minCost;
	}

	public double kruskal(GraphList<T, V> g) {
		ArrayList<Edge<V>> edges = g.getEdges();
		int[] disjoin = new int[g.getVertices().size()];
		Collections.sort(edges);
		return kruskal(g, disjoin, edges);
	}

	private int indexMinimumCost(double[] costs, boolean[] visited) {
		int indexAux = 0;
		double[] costsCopy = new double[costs.length];
		for (int i = 0; i < costs.length; i++) {
			costsCopy[i] = costs[i];
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				costsCopy[i] = Integer.MAX_VALUE;
			}
		}

		double min = costsCopy[0];
		for (int i = 1; i < costs.length; i++) {
			if (costsCopy[i] < min) {
				min = costsCopy[i];
				indexAux = i;
			}
		}
		return indexAux;
	}

	//PRIM
	@SuppressWarnings("unchecked")
	private double prim(GraphList<T, V> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited, double[] costs, int[] paths,
			int visits, int start, double cost, int initial) {

		if (visits == vertices.size()) {
			for (int i = 0; i < costs.length; i++) {
				if (i != initial) {
					cost += costs[i];
				}
			}
			return cost;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getVertexEnd().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getVertexEnd().getValue())] > actual
							.getEdges().get(i).getWeight()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getVertexEnd().getValue())] = actual
								.getEdges().get(i).getWeight();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getVertexEnd().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return prim(g, ini, vertices, visited, costs, paths, visits, min, cost, initial);
		}

		return cost;
	}

	public double prim(GraphList<T, V> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < paths.length; i++) {
			paths[i] = -1;
		}

		return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);
	}
}
