package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import graphs.AdjListGraph;
import graphs.AdjVertex;

class TestAdjListGraph {

	private AdjListGraph<Integer> graph;
	private AdjListGraph<Integer> dGraph;

	public void setUpStage1() {
		graph = new AdjListGraph<Integer>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(4);
	}

	public void setUpStage2() {
		dGraph = new AdjListGraph<Integer>(true, true);
		dGraph.addVertex(1);
		dGraph.addVertex(2);
		dGraph.addVertex(5);
		dGraph.addVertex(7);
	}

	public void setUpStage3() {
		graph = new AdjListGraph<Integer>(false, true);
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
		graph = new AdjListGraph<Integer>(false, true);
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
		graph = new AdjListGraph<>(false, false);
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

	public void setUpStage7() {
		setUpStage4();
		dGraph.addEdge(5, 7, 3);
	}

	public void setUpStage8() {
		dGraph = new AdjListGraph<>(true, true);
		dGraph.addVertex(3);
		dGraph.addVertex(4);
		dGraph.addVertex(5);
	}

	public void setUpStage9() {
		setUpStage7();
		dGraph.addEdge(1, 1, 8);
	}
	
	public void setUpStage10() {
		graph = new AdjListGraph<Integer>(false, false);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
	}

	public void setUpStage11() {
		graph = new AdjListGraph<Integer>(false, true);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 2);
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
		assertTrue(dGraph.searchVertex(5).isAdjacent(dGraph.searchVertex(7)));
		assertTrue(dGraph.searchVertex(5).findEdge(dGraph.searchVertex(7)).getWeight() == 3);
		assertTrue(dGraph.searchVertex(7).findEdge(dGraph.searchVertex(5)) == null);

		setUpStage3();
		graph.addEdge(5, 7, 3);
		assertTrue(graph.searchVertex(5).isAdjacent(graph.searchVertex(7)));
		assertTrue(graph.searchVertex(5).findEdge(graph.searchVertex(7)).getWeight() == 3);
		assertTrue(graph.searchVertex(7).findEdge(graph.searchVertex(5)) != null);

		setUpStage2();
		dGraph.addEdge(5, 5, 8);
		assertTrue(dGraph.searchVertex(5).isAdjacent(dGraph.searchVertex(5)));
		assertTrue(dGraph.searchVertex(5).findEdge(dGraph.searchVertex(5)).getWeight() == 8);

		setUpStage3();
		graph.addEdge(5, 5, 8);
		assertTrue(graph.searchVertex(5).isAdjacent(graph.searchVertex(5)));
		assertTrue(graph.searchVertex(5).findEdge(graph.searchVertex(5)).getWeight() == 8);

		setUpStage4();
		dGraph.addEdge(5, 7, 3);
		assertTrue(dGraph.searchVertex(5).isAdjacent(dGraph.searchVertex(2)));
		assertTrue(dGraph.searchVertex(5).isAdjacent(dGraph.searchVertex(7)));
		assertTrue(dGraph.searchVertex(5).findEdge(dGraph.searchVertex(2)).getWeight() == 3);
	}

	@Test
	public void testDeleteVertex() {
		setUpStage7();
		dGraph.deleteVertex(2);
		assertTrue(dGraph.searchVertex(1).getAdjList().size() == 1);
		assertTrue(dGraph.searchVertex(1).getAdjList().get(0).getDestination().getValue() == 5);
		assertTrue(dGraph.searchVertex(5).getAdjList().size() == 1);
		assertTrue(dGraph.searchVertex(5).getAdjList().get(0).getDestination().getValue() == 7);

		setUpStage7();
		dGraph.deleteVertex(1);
		assertTrue(dGraph.searchVertex(1) == null);

		setUpStage7();
		dGraph.deleteVertex(5);
		assertTrue(dGraph.searchVertex(1).getAdjList().size() == 1);
		assertTrue(dGraph.searchVertex(1).getAdjList().get(0).getDestination().getValue() == 2);
		assertTrue(dGraph.searchVertex(7).getAdjList().size() == 0);

		setUpStage5();
		graph.deleteVertex(2);
		assertTrue(graph.searchVertex(1).getAdjList().size() == 1);
		assertTrue(graph.searchVertex(1).getAdjList().get(0).getDestination().getValue() == 4);
		assertTrue(graph.searchVertex(3).getAdjList().size() == 1);
		assertTrue(graph.searchVertex(3).getAdjList().get(0).getDestination().getValue() == 4);
	}

	@Test
	public void testRemoveEdge() {
		setUpStage9();
		dGraph.deleteEdge(1, 2);
		assertTrue(dGraph.searchVertex(1).getAdjList().size() == 2);
		assertTrue(dGraph.searchVertex(1).getAdjList().get(0).getDestination().getValue() == 5);
		assertTrue(dGraph.searchVertex(1).getAdjList().get(1).getDestination().getValue() == 1);

		setUpStage9();
		dGraph.deleteEdge(5, 7);
		assertTrue(dGraph.searchVertex(7).isAdjacent(dGraph.searchVertex(5)));
		assertTrue(!dGraph.searchVertex(5).isAdjacent(dGraph.searchVertex(7)));

		setUpStage5();
		graph.deleteEdge(1, 2);
		assertTrue(!graph.searchVertex(1).isAdjacent(graph.searchVertex(2)));
		assertTrue(!graph.searchVertex(2).isAdjacent(graph.searchVertex(1)));

		setUpStage5();
		graph.deleteEdge(3, 4);
		assertTrue(!graph.searchVertex(3).isAdjacent(graph.searchVertex(4)));
		assertTrue(!graph.searchVertex(4).isAdjacent(graph.searchVertex(3)));
	}

	@Test
	public void testSearchVertex() {
		AdjVertex<Integer> x;
		setUpStage5();
		x = graph.searchVertex(1);
		assertTrue(x.getValue() == 1);
		assertTrue(x.getAdjList().size() == 2);
		assertTrue(x.isAdjacent(graph.searchVertex(2)));
		assertTrue(x.isAdjacent(graph.searchVertex(4)));
		x = graph.searchVertex(5);
		assertTrue(x == null);

		setUpStage9();
		x = dGraph.searchVertex(2);
		assertTrue(x.getValue() == 2);
		assertTrue(x.getAdjList().size() == 0);

		x = dGraph.searchVertex(1);
		assertTrue(x.getValue() == 1);
		assertTrue(x.getAdjList().size() == 3);
		assertTrue(x.isAdjacent(dGraph.searchVertex(1)));
		assertTrue(x.isAdjacent(dGraph.searchVertex(2)));
		assertTrue(x.isAdjacent(dGraph.searchVertex(5)));

		x = dGraph.searchVertex(8);
		assertTrue(x == null);
	}

	@Test
	public void testAreAdjacent() {
		setUpStage5();
		assertTrue(graph.areAdjacent(graph.searchVertex(1), graph.searchVertex(2)));
		assertTrue(!graph.areAdjacent(graph.searchVertex(1), graph.searchVertex(3)));

		setUpStage9();
		assertTrue(dGraph.areAdjacent(dGraph.searchVertex(1), dGraph.searchVertex(2)));
		assertTrue(!dGraph.areAdjacent(dGraph.searchVertex(2), dGraph.searchVertex(1)));
		assertTrue(dGraph.areAdjacent(dGraph.searchVertex(1), dGraph.searchVertex(1)));
	}

	@Test
	public void testBfs() {
		setUpStage6();
		graph.bfs(graph.searchVertex(3));
		assertTrue(graph.searchVertex(3).getPred() == null);
		assertTrue(graph.searchVertex(2).getPred().getValue() == 3);
		assertTrue(graph.searchVertex(4).getPred().getValue() == 3);
		assertTrue(graph.searchVertex(1).getPred().getValue() == 2);
		assertTrue(graph.searchVertex(5).getPred().getValue() == 2);

		setUpStage8();
		dGraph.bfs(dGraph.searchVertex(3));
		assertTrue(dGraph.searchVertex(3).getPred() == null);
		assertTrue(dGraph.searchVertex(4).getPred() == null);
		assertTrue(dGraph.searchVertex(5).getPred() == null);
		assertTrue(dGraph.getVertices().size() == 3);
	}

	@Test
	public void testDfs() {
		setUpStage10();
		graph.dfs();
		for (int i = 0; i < graph.getVertices().size(); i++)
			assertTrue(graph.getVertices().get(i).getPred() == null);
		
		setUpStage6();
		graph.dfs();
		assertTrue(graph.searchVertex(1).getPred() == null);
		assertTrue(graph.searchVertex(2).getPred().getValue() == 1);
		assertTrue(graph.searchVertex(3).getPred().getValue() == 2);
		assertTrue(graph.searchVertex(4).getPred().getValue() == 3);
		assertTrue(graph.searchVertex(5).getPred().getValue() == 4);
		assertTrue(graph.searchVertex(1).getInitialTimeStamp() == 1 && graph.searchVertex(1).getFinalTimeStamp() == 10);
		assertTrue(graph.searchVertex(2).getInitialTimeStamp() == 2 && graph.searchVertex(2).getFinalTimeStamp() == 9);
		assertTrue(graph.searchVertex(3).getInitialTimeStamp() == 3 && graph.searchVertex(3).getFinalTimeStamp() == 8);
		assertTrue(graph.searchVertex(4).getInitialTimeStamp() == 4 && graph.searchVertex(4).getFinalTimeStamp() == 7);
		assertTrue(graph.searchVertex(5).getInitialTimeStamp() == 5 && graph.searchVertex(5).getFinalTimeStamp() == 6);
	}

	@Test
	public void testDijkstra() {
		setUpStage11();
		graph.dijkstra(graph.searchVertex(1));
		assertTrue(graph.searchVertex(4).getInitialTimeStamp() == AdjListGraph.INFINITE);
	}
}
