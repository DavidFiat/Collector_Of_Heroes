package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import graphs.AdjMatrixGraph;
import graphs.Edge;
import graphs.Vertex;

class TestAdjMatrixGraph {

	private AdjMatrixGraph<Integer> graph;
	private AdjMatrixGraph<Integer> dGraph;

	public void setUpStage1() {
		graph = new AdjMatrixGraph<Integer>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(4);
	}

	public void setUpStage2() {
		dGraph = new AdjMatrixGraph<Integer>(true, true);
		dGraph.addVertex(1);
		dGraph.addVertex(2);
		dGraph.addVertex(5);
		dGraph.addVertex(7);
	}

	public void setUpStage3() {
		graph = new AdjMatrixGraph<Integer>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(5);
		graph.addVertex(7);
	}

	public void setUpStage4() {
		setUpStage2();
		dGraph.addEdge(1, 2, 3);
		dGraph.addEdge(1, 5, 6);
		dGraph.addEdge(5, 2, 3);
		dGraph.addEdge(7, 5, 5);
	}

	public void setUpStage5() {
		graph = new AdjMatrixGraph<Integer>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 4, 1);
		graph.addEdge(4, 1, 1);
	}

	public void setUpStage6() {
		setUpStage2();
		dGraph.addEdge(1, 2, 3);
		dGraph.addEdge(1, 5, 6);
		dGraph.addEdge(5, 2, 3);
		dGraph.addEdge(7, 5, 5);
		dGraph.addEdge(5, 7, 3);
		dGraph.addEdge(1, 1, 8);
	}

	public void setUpStage7() {
		graph = new AdjMatrixGraph<>(false, false);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 4);
		graph.addEdge(3, 4);
	}
	
	public void setUpStage8() {
		setUpStage4();
		dGraph.addEdge(5, 7, 3);
	}

	public void setUpStage9() {
		dGraph = new AdjMatrixGraph<>(true, true);
		dGraph.addVertex(3);
		dGraph.addVertex(4);
		dGraph.addVertex(5);
	}

	public void setUpStage10() {
		setUpStage8();
		dGraph.addEdge(1, 1, 8);
	}


	public void setUpStage11() {
		graph = new AdjMatrixGraph<Integer>(false, false);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
	}

	public void setUpStage12() {
		graph = new AdjMatrixGraph<Integer>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 2);
	}
	
	public void setUpStage13() {
		dGraph = new AdjMatrixGraph<Integer>(true, true);
		dGraph.addVertex(1);
		dGraph.addVertex(2);
		dGraph.addVertex(3);
		dGraph.addVertex(4);
		dGraph.addEdge(1, 3, -2);
		dGraph.addEdge(3, 4, 2);
		dGraph.addEdge(4, 2, -1);
		dGraph.addEdge(2, 1, 4);
		dGraph.addEdge(2, 3, 3);
	}
	
	public void setUpStage14() {
		graph = new AdjMatrixGraph<>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 8, 9);
		graph.addEdge(2, 3, 9);
		graph.addEdge(2, 8, 11);
		graph.addEdge(3, 9, 2);
		graph.addEdge(4, 5, 10);
		graph.addEdge(4, 6, 15);
		graph.addEdge(5, 6, 11);
		graph.addEdge(7, 8, 1);
		graph.addEdge(7, 9, 6);
		graph.addEdge(8, 7, 1);
	}
	
	public void setUpStage15() {
		graph = new AdjMatrixGraph<>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 4);
		graph.addEdge(2, 3, 2);
		graph.addEdge(2, 4, 3);
		graph.addEdge(2, 5, 4);
		graph.addEdge(2, 6, 2);
		graph.addEdge(4, 5, 3);
		graph.addEdge(5, 6, 3);
	}
	
	@Test
	public void testAddVertex() {
		setUpStage1();
		graph.addVertex(1);
		assertTrue(graph.isInGraph(1));
		assertTrue(graph.getVertices().size() == 3);

		setUpStage1();
		graph.addVertex(3);
		assertTrue(graph.isInGraph(3));
		assertTrue(graph.getVertices().size() == 4);

		setUpStage1();
		graph.addVertex(4);
		assertTrue(graph.isInGraph(1));
		assertTrue(graph.isInGraph(2));
		assertTrue(graph.isInGraph(4));
		assertTrue(graph.getVertices().size() == 3);
	}

	@Test
	public void testAddEdge() {
		setUpStage2();
		dGraph.addEdge(5, 7, 3);
		assertTrue(dGraph.getAdjMatrix().get(dGraph.getIndexOf(dGraph.searchVertex(5)))
				.get(dGraph.getIndexOf(dGraph.searchVertex(7))) == 1.0);
		assertTrue(dGraph.getWeightsMatrix()[dGraph.getIndexOf(dGraph.searchVertex(5))]
				[dGraph.getIndexOf(dGraph.searchVertex(7))] == 3.0);
		assertTrue(dGraph.getAdjMatrix().get(dGraph.getIndexOf(dGraph.searchVertex(7)))
				.get(dGraph.getIndexOf(dGraph.searchVertex(5))) == 0);

		setUpStage3();
		graph.addEdge(5, 7, 3);
		assertTrue(graph.getAdjMatrix().get(graph.getIndexOf(graph.searchVertex(5)))
				.get(graph.getIndexOf(graph.searchVertex(7))) == 1.0);
		assertTrue(graph.getWeightsMatrix()[graph.getIndexOf(graph.searchVertex(5))]
				[graph.getIndexOf(graph.searchVertex(7))] == 3.0);
		assertTrue(graph.getAdjMatrix().get(graph.getIndexOf(graph.searchVertex(7)))
				.get(graph.getIndexOf(graph.searchVertex(5))) == 1);
	
		setUpStage4();
		dGraph.addEdge(5, 7, 3);
		assertTrue(dGraph.getAdjMatrix().get(dGraph.getIndexOf(dGraph.searchVertex(5)))
				.get(dGraph.getIndexOf(dGraph.searchVertex(2))) == 1.0);
		assertTrue(dGraph.getAdjMatrix().get(dGraph.getIndexOf(dGraph.searchVertex(5)))
				.get(dGraph.getIndexOf(dGraph.searchVertex(7))) == 1.0);
		assertTrue(dGraph.getWeightsMatrix()[dGraph.getIndexOf(dGraph.searchVertex(5))]
				[dGraph.getIndexOf(dGraph.searchVertex(2))] == 3.0);
	}
	
	@Test
	public void testDeleteVertex() {
		setUpStage8();
		dGraph.deleteVertex(2);
		assertTrue(dGraph.getVertices().size() == 3);
		assertTrue(dGraph.getAdjMatrix().size() == 3);
		assertTrue(dGraph.getWeightsMatrix().length == 3);
		assertTrue(dGraph.getAdjMatrix().get(dGraph.getIndexOf(dGraph.searchVertex(1))).size() == 3);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).size() == 1);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).get(0).getValue() == 5);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(5)).size() == 1);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(5)).get(0).getValue() == 7);

		setUpStage8();
		dGraph.deleteVertex(1);
		assertTrue(dGraph.searchVertex(1)==null);
		
		setUpStage8();
		dGraph.deleteVertex(5);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).size() == 1);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).get(0).getValue() == 2);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(7)).size() == 0);
		
		setUpStage5();
		graph.deleteVertex(2);
		assertTrue(graph.getAdjVertices(graph.searchVertex(1)).size() == 1);
		assertTrue(graph.getAdjVertices(graph.searchVertex(1)).get(0).getValue() == 4);
		assertTrue(graph.getAdjVertices(graph.searchVertex(3)).size() == 1);
		assertTrue(graph.getAdjVertices(graph.searchVertex(3)).get(0).getValue() == 4);
	}
	
	@Test
	public void testRemoveEdge() {
		setUpStage10();
		dGraph.deleteEdge(1, 2);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).size() == 2);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).get(1).getValue() == 5);
		assertTrue(dGraph.getAdjVertices(dGraph.searchVertex(1)).get(0).getValue() == 1);
		
		setUpStage10();
		dGraph.deleteEdge(5, 7);
		assertTrue(dGraph.areAdjacent(dGraph.searchVertex(7), dGraph.searchVertex(5)));
		assertFalse(dGraph.areAdjacent(dGraph.searchVertex(5), dGraph.searchVertex(7)));
		
		setUpStage5();
		graph.deleteEdge(1, 2);
		assertFalse(graph.areAdjacent(graph.searchVertex(1), graph.searchVertex(2)));
		assertFalse(graph.areAdjacent(graph.searchVertex(2), graph.searchVertex(1)));
		
		setUpStage5();
		graph.deleteEdge(3, 4);
		assertFalse(graph.areAdjacent(graph.searchVertex(3), graph.searchVertex(4)));
		assertFalse(graph.areAdjacent(graph.searchVertex(4), graph.searchVertex(3)));
	}
	
	@Test
	public void testSearchVertex() {
		Vertex<Integer> x;
		setUpStage5();
		x = graph.searchVertex(1);
		assertTrue(x.getValue()==1);
		assertTrue(graph.getAdjVertices(x).size() == 2);
		assertTrue(graph.areAdjacent(x, graph.searchVertex(2)));
		assertTrue(graph.areAdjacent(x, graph.searchVertex(4)));
		x = graph.searchVertex(5);
		assertTrue(x==null);
		
		setUpStage10();
		x = dGraph.searchVertex(2);
		assertTrue(x.getValue()==2);
		assertTrue(dGraph.getAdjVertices(x).size() == 0);
		x = dGraph.searchVertex(1);
		assertTrue(x.getValue()==1);
		assertTrue(dGraph.getAdjVertices(x).size() == 3);
		assertTrue(dGraph.areAdjacent(x, dGraph.searchVertex(1)));
		assertTrue(dGraph.areAdjacent(x, dGraph.searchVertex(2)));
		assertTrue(dGraph.areAdjacent(x, dGraph.searchVertex(5)));
		x = dGraph.searchVertex(8);
		assertTrue(x==null);
	}
	
	@Test
	public void testAreAdjacent() {
		setUpStage5();
		assertTrue(graph.areAdjacent(graph.searchVertex(1), graph.searchVertex(2)));
		assertTrue(!graph.areAdjacent(graph.searchVertex(1), graph.searchVertex(3)));
		
		setUpStage10();
		assertTrue(dGraph.areAdjacent(dGraph.searchVertex(1), dGraph.searchVertex(2)));
		assertTrue(!dGraph.areAdjacent(dGraph.searchVertex(2), dGraph.searchVertex(1)));
		assertTrue(dGraph.areAdjacent(dGraph.searchVertex(1), dGraph.searchVertex(1)));
	}
	
	@Test
	public void testBfs() {
		setUpStage7();
		graph.bfs(graph.searchVertex(3));
		assertTrue(graph.searchVertex(3).getPred()==null);
		assertTrue(graph.searchVertex(2).getPred().getValue()==3);
		assertTrue(graph.searchVertex(4).getPred().getValue()==3);
		assertTrue(graph.searchVertex(1).getPred().getValue()==2);
		assertTrue(graph.searchVertex(5).getPred().getValue()==2);
		
		setUpStage9();
		dGraph.bfs(dGraph.searchVertex(3));
		assertTrue(dGraph.searchVertex(3).getPred()==null);
		assertTrue(dGraph.searchVertex(4).getPred()==null);
		assertTrue(dGraph.searchVertex(5).getPred()==null);
		assertTrue(dGraph.getVertices().size()==3);
	}
	
	@Test
	public void testDfs() {
		setUpStage11();
		graph.dfs();
		for (int i=0; i<graph.getVertices().size(); i++)
			assertTrue(graph.getVertices().get(i).getPred()==null);

		setUpStage7();
		graph.dfs();
		assertTrue(graph.searchVertex(1).getPred()==null);
		assertTrue(graph.searchVertex(2).getPred().getValue()==1);
		assertTrue(graph.searchVertex(3).getPred().getValue()==2);
		assertTrue(graph.searchVertex(4).getPred().getValue()==3);
		assertTrue(graph.searchVertex(5).getPred().getValue()==4);
		assertTrue(graph.searchVertex(1).getInitialTimeStamp()==1 && graph.searchVertex(1).getFinalTimeStamp()==10);
		assertTrue(graph.searchVertex(2).getInitialTimeStamp()==2 && graph.searchVertex(2).getFinalTimeStamp()==9);
		assertTrue(graph.searchVertex(3).getInitialTimeStamp()==3 && graph.searchVertex(3).getFinalTimeStamp()==8);
		assertTrue(graph.searchVertex(4).getInitialTimeStamp()==4 && graph.searchVertex(4).getFinalTimeStamp()==7);
		assertTrue(graph.searchVertex(5).getInitialTimeStamp()==5 && graph.searchVertex(5).getFinalTimeStamp()==6);
	}

	@Test
	public void testDijkstra() {
		setUpStage12();
		graph.dijkstra(graph.searchVertex(1));	
		assertTrue(graph.searchVertex(4).getInitialTimeStamp()==AdjMatrixGraph.INFINITE);
	}
	
	@Test
	public void testFloydWarshall() {
		double[][] matrix;
		setUpStage13();
		matrix = dGraph.floydWarshall();
		assertTrue(matrix[0][1] == -1);
		assertTrue(matrix[0][2] == -2);
		assertTrue(matrix[0][3] == 0);
		assertTrue(matrix[1][0] == 4);
		assertTrue(matrix[1][2] == 2);
		assertTrue(matrix[1][3] == 4);
		assertTrue(matrix[2][0] == 5);
		assertTrue(matrix[2][1] == 1);
		assertTrue(matrix[2][3] == 2);
		assertTrue(matrix[3][0] == 3);
		assertTrue(matrix[3][1] == -1);
		assertTrue(matrix[3][2] == 1);
	}
	
	@Test
	public void testPrim() {
		double totalW = 0;
		setUpStage15();
		graph.prim(graph.searchVertex(1));
		totalW = 0;
		for (int i = 0; i < graph.getVertices().size(); i++) {
			totalW += graph.getVertices().get(i).getInitialTimeStamp();
		}
		assertTrue(totalW == 14);
	}

	@Test
	public void testKruskal() {
		double totalW = 0;
		setUpStage15();
		ArrayList<Edge<Integer>> edges = graph.kruskal();
		totalW = 0;
		Edge<Integer> e = edges.get(0);
		assertTrue(e.getInitial() == graph.searchVertex(2));
		assertTrue(e.getDestination() == graph.searchVertex(3));
		assertTrue(e.getWeight() == 2);
		totalW += e.getWeight();
		e = edges.get(1);
		assertTrue(e.getInitial() == graph.searchVertex(2));
		assertTrue(e.getDestination() == graph.searchVertex(6));
		assertTrue(e.getWeight() == 2);
		totalW += e.getWeight();
		e = edges.get(2);
		assertTrue(e.getInitial() == graph.searchVertex(2));
		assertTrue(e.getDestination() == graph.searchVertex(4));
		assertTrue(e.getWeight() == 3);
		totalW += e.getWeight();
		e = edges.get(3);
		assertTrue(e.getInitial() == graph.searchVertex(4));
		assertTrue(e.getDestination() == graph.searchVertex(5));
		assertTrue(e.getWeight() == 3);
		totalW += e.getWeight();
		e = edges.get(4);
		assertTrue(e.getInitial() == graph.searchVertex(1));
		assertTrue(e.getDestination() == graph.searchVertex(2));
		assertTrue(e.getWeight() == 4);
		totalW += e.getWeight();
		assertTrue(totalW == 14);
	}
}
