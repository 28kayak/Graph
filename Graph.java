import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class Graph 
{
	public Set<Vertex> vs;
	public Map<Vertex, List<Edge>> es;
	
	public Graph()
	{
		this.vs = new HashSet<Vertex>();
		this.es = new HashMap<Vertex, List<Edge>>();
	}
	public List<Edge> getEdge(Vertex vertex)
	{
		return es.get(vertex);
	}
	public boolean find(Graph graph, Vertex start, Vertex goal)
	{//if this search can find goal successfully, return true; otherwise, return false
		return depthFirstSearch(graph, start, goal, new HashSet<Vertex>());
		//by passing an instance of HashSet, it creates a new Set-table and is going to hold on the result
		//whether vertex has been visited or not. 
	}
	public boolean depthFirstSearch(Graph graph, Vertex aVertex, Vertex goal, Set<Vertex> visited)
	{
		if(aVertex.equals(goal))
		{
			//find! 
			return true;
		}
		if(visited.contains(aVertex))
		{//In order to avoid to get into a loop, try not to visit a vertex that has already been visited
			return false;
		}
		visited.add(aVertex);
		//Now walk thorough all edges from aVertex(= start at the most first time)
		List<Edge> edges = graph.getEdge(aVertex);
		for(int i = 0; i < edges.size(); i++)
		{
			Edge edge = edges.get(i);
			//walking along edges 
			if(depthFirstSearch(graph, edge.end, goal,visited))
			{
				return true;
			}
		}
		return false;//means cannot find goal, which is a target
	}
	public void depthFirstSearchloop(Graph graph, Vertex start, Vertex goal)
	{
		Set<Vertex> visited = new HashSet<Vertex>();
		Stack<Vertex> q = new Stack<Vertex>();
		q.add(start);
	}
	
}//class
