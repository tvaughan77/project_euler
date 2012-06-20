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
    val graph = Graph.mock().addEdge(Edge("v5 -> v1", Vertex("E"), Vertex("A")))
    intercept[IllegalStateException] {
      graph.checkConsistency
    }    
  }
  
  
  test("Graph.checkConsistency fails when an edge mentioned a v2 vertex that isn't in graph.verticies") {
    val graph = Graph.mock().addEdge(Edge("v1 -> v5", Vertex("A"), Vertex("E")))
    intercept[IllegalStateException] {
      graph.checkConsistency
    }    
  }
  
  test("The verticies reachable from Vertex(A) are Verticies B and C") {
    assertEquals(List(Vertex("B"), Vertex("C")), Graph.mock().verticiesFrom(Vertex("A")))
  }
  
  test("The verticies reachable from either Vertex(B) or Vertex(C) is Vertex(D)") {
    assertEquals(List(Vertex("D")), Graph.mock().verticiesFrom(Vertex("B")))
    assertEquals(List(Vertex("D")), Graph.mock().verticiesFrom(Vertex("C")))
  }
  
  test("There are no verticies reachable from Vertex(D)") {
    assertTrue(Graph.mock().verticiesFrom(Vertex("D")).isEmpty)
  }
  
  test("The distinctPaths for our Mock Graph starting from A are (A, C, D) and (A, B, D)") {
    val distinctPaths = Graph.mock().distinctPaths(Vertex("A"))
    assertEquals(2, distinctPaths.size)
    assertTrue(distinctPaths.contains(List(Vertex("A"), Vertex("C"), Vertex("D"))))
    assertTrue(distinctPaths.contains(List(Vertex("A"), Vertex("B"), Vertex("D"))))
    
    println("The distinct paths for our Graph are: " + distinctPaths)
  }
}
