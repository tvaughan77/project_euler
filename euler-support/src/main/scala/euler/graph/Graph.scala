package euler.graph

import scala.io.Source
import scala.collection.immutable.Stack
import scala.collection.mutable.Set
import euler.LogHelper

/**
 * <p>Note - this Graph implementation assumes one-way edges (e.g. "A -> B" does not imply vertex A is 
 * reachable from vertex B</p>
 */
case class Graph private(verticies: Set[Vertex], edges: Set[Edge]) extends LogHelper {
  
  
  def addEdge(edge: Edge): Graph = {
    Graph(verticies, edges + edge)
  }
  
  def addVertex(vertex: Vertex): Graph = {
    Graph(verticies + vertex, edges)
  }
  
  // FIXME - this is a code smell; why not just disallow the ability to get in to a bad state?
  def checkConsistency() = {
    val edgesWithUnknownV1 = edges filterNot ((x: Edge) => verticies.contains(x.v1))
    if(!edgesWithUnknownV1.isEmpty)
      throw new IllegalStateException("An edge exists referencing a v1 vertex that doesn't exist: " + edgesWithUnknownV1)
    
    val edgesWithUnknownV2 = edges filterNot ((x: Edge) => verticies.contains(x.v2))
    if(!edgesWithUnknownV2.isEmpty)
      throw new IllegalStateException("An edge exists referencing a v2 vertex that doesn't exist: " + edgesWithUnknownV2)
  }
  
  /**
   * @param v a Starting vertex
   * @return a list of all the vertexes reachable within 1 edge from {@code v} (may be an empty list if 
   * {@code v} is disconnected from the graph
   */
  def verticiesFrom(v: Vertex): List[Vertex] = {
    (edges filter ((e:Edge) => e.v1 == v)) flatMap ((e:Edge) => List.apply(e.v2)) toList
  }
  
  /**
   * TODO - prevent infinite loops when cycles happen
   * @param v a starting vertex
   * @return a set of all paths from {@code v} through the graph
   */
  def distinctPaths(v: Vertex): Set[List[Vertex]] = {
    var stack = Stack.empty[List[Vertex]]
    val paths = Set.empty[List[Vertex]]
    
    stack = stack.push(List(v))
    
    while(!stack.isEmpty) {
      val path = stack.top
      stack = stack.pop                   // This is a nasty API, Scala
      val nextVertexInPath = path.head
      val reachableVerticies = verticiesFrom(nextVertexInPath)
      if(reachableVerticies.isEmpty) {
        info("Adding a path from %s to my set of paths: %s", v, path.reverse)
        paths += path
      }
      else {
        debug("Pushing new directions %s onto stack from path %s", reachableVerticies, path)
        stack = stack.pushAll(reachableVerticies map ((v:Vertex) => v :: path))
      }
    }
    
    paths map (_.reverse)
  }
  
}

object Graph extends LogHelper {
  
  /**
   * <p>Super-simple loader that assumes one pair of verticies with a single edge between them per line, 
   * in the format:</br>
   *   V1 -> V2
   * </p>
   * @param an I/O Source from which a graph can be parsed
   * @return a new Graph object containing all the verticies and edges specified in the {@code source} file
   * @throws IllegalStateException if an edge is found that references a vertex not mentioned
   */
  def loadFromResource(source: Source): Graph = {
    val regex = """(.+) -> (.+)$""".r
    var graph = new Graph(Set.empty[Vertex], Set.empty[Edge])

    for(line <- source.getLines) {
      val regex(v1, v2) = line
      
      val vertex1 = new Vertex(v1)
      val vertex2 = new Vertex(v2)
      val edge = Edge(line, vertex1, vertex2)
      
      debug("Read line '%s' which is parsed into verticies %s and %s", line.trim, v1, v2)
      
      graph = graph.addVertex(vertex1).addVertex(vertex2).addEdge(edge)
    }
    graph.checkConsistency
    graph
  }
  
  def mock(): Graph = {
    val vertex1 = new Vertex("A")
    val vertex2 = new Vertex("B")
    val vertex3 = new Vertex("C")
    val vertex4 = new Vertex("D")
    
    val v1v2edge = Edge("A -> B", vertex1, vertex2)
    val v1v3edge = Edge("A -> C", vertex1, vertex3)
    val v2v4edge = Edge("B -> D", vertex2, vertex4)
    val v3v4edge = Edge("C -> D", vertex3, vertex4)
    
    val graph = new Graph(Set(vertex1, vertex2, vertex3, vertex4),
                          Set(v1v2edge, v1v3edge, v2v4edge, v3v4edge))
    graph.checkConsistency
    graph
  }
  
  /**
   * @param filename the name of a file to save the graph output to
   * @param dim the dimensions of the square graph
   */
  def createGraphFile(filename: String, dim: Int) = {
    val out = new java.io.FileWriter(filename)
    
    for(row <- 1 to dim) {
      for(col <- 1 to dim) {
        val currentVertex = "r" + row + "c" + col
        if(col != dim) {
          out.write(currentVertex + " -> " + "r" + row + "c" + (col + 1) + "\n")
        }
        if(row != dim) {
          out.write(currentVertex + " -> " + "r" + (row + 1) + "c" + col + "\n")
        }
      }
    }
    out.close
  }
}
