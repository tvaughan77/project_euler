package euler.graph

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._

import scala.io.Source


@RunWith(classOf[JUnitRunner])
class GraphSuite extends FunSuite {

  /**
   * Our 2x2_graph.txt should produce the same graph as the hard-coded Graph.mock() function does
   */
  test("Loading a small graph with the factory method produces the expected object") {
    val graph = Graph.loadFromResource(Source.fromInputStream(getClass.getResourceAsStream("2x2_graph.txt")))
    check2x2Graph(graph)
  }
  
  /**
   * Our Graph.mock() function should produce the same graph as the one encoded in our 2x2_graph.txt resource
   */
  test("Creating the mock graph yields a 2x2 graph") {
    val graph = Graph.mock()
    check2x2Graph(graph)
  }
  
  def check2x2Graph(graph: Graph) = {
    assertEquals(4, graph.verticies.size)
    assertEquals(4, graph.edges.size)
    assertTrue(graph.verticies.contains(Vertex("A")))
    assertTrue(graph.edges.contains(Edge("A -> B", Vertex("A"), Vertex("B"))))
    assertTrue(graph.edges.contains(Edge("A -> C", Vertex("A"), Vertex("C"))))
    assertTrue(graph.edges.contains(Edge("B -> D", Vertex("B"), Vertex("D"))))
    assertTrue(graph.edges.contains(Edge("C -> D", Vertex("C"), Vertex("D"))))
    graph.checkConsistency    
  }
  
  test("Graph.checkConsistency fails when an edge mentioned a v1 vertex that isn't in graph.verticies") {
    var graph = Graph.mock().addEdge(Edge("v5 -> v1", Vertex("E"), Vertex("A")))
    intercept[IllegalStateException] {
      graph.checkConsistency
    }    
  }
  
  
  test("Graph.checkConsistency fails when an edge mentioned a v2 vertex that isn't in graph.verticies") {
    var graph = Graph.mock().addEdge(Edge("v1 -> v5", Vertex("A"), Vertex("E")))
    intercept[IllegalStateException] {
      graph.checkConsistency
    }    
  }
}
